package com.ftq.webpage.dao;

import com.ftq.webpage.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

}
