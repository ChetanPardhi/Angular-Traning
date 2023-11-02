package com.example.portfolio.ui.user;

import com.example.portfolio.user.domain.User;
import com.example.portfolio.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("**")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
        return this.userService.login(email , password);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        return this.userService.deleteUser(userId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> findUserById(@PathVariable Long userId){
        return this.userService.findUserById(userId);
    }

    @PutMapping("/user/edit/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId ,@RequestBody User user){
        return this.userService.updateUser(userId , user);
    }

    @GetMapping("/userList")
    public ResponseEntity<?> getAllUsers(){
        return  this.userService.findAllUser();
    }
}
