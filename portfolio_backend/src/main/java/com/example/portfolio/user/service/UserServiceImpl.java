package com.example.portfolio.user.service;

import com.example.portfolio.user.dao.UserDao;
import com.example.portfolio.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<?> createUser(User user) {

        User newUser = new User();
        HashMap<String , String> response = new HashMap<>();

        try{
            newUser.setUserName(user.getUserName());
            newUser.setEmail(user.getEmail());
            newUser.setUserPassword(user.getUserPassword());

            userDao.save(newUser);

            response.put("message","User created successfully");
        }
        catch(Exception e){
            e.printStackTrace();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateUser(Long userId, User user) {

        HashMap<String , String> response = new HashMap<>();

        try{

            User existingUser = userDao.findById(userId).get();

            existingUser.setUserPassword(user.getUserPassword() == null ? existingUser.getUserPassword() : user.getUserPassword());
            existingUser.setUserName(user.getUserName() == null ? existingUser.getUserName() : user.getUserName());
            existingUser.setEmail(user.getEmail() == null ? existingUser.getEmail() : user.getEmail());

            this.userDao.save(existingUser);
            response.put("message","User updated successfully");

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findUserById(Long userId) {

        HashMap<String , Object> response = new HashMap<>();

        try{

            User requiredUser = userDao.findById(userId).get();
            response.put("message","User found Successfully");
            response.put("user",requiredUser);

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findAllUser() {

        HashMap<String , Object> response = new HashMap<>();

        try{
            List<User> userList = userDao.findAll();
            response.put("message","All User found successfully");
            response.put("users" , userList);

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {

        HashMap<String , String> response = new HashMap<>();

        try{
            User existingUser = userDao.findById(userId).get();
            userDao.delete(existingUser);
            response.put("message","User deleted successfully");

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> login(String email, String password) {

        HashMap<String , Object> response = new HashMap<>();

        try{
            User user = userDao.findByEmailAndUserPassword(email, password);

            System.out.println(user);
            response.put("message","User found successfully");
            response.put("userId" , user.getUserId());

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
