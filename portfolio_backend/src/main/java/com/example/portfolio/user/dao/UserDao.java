package com.example.portfolio.user.dao;

import com.example.portfolio.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User , Long> {

    public User findByEmailAndUserPassword(String email , String userPassword);
}
