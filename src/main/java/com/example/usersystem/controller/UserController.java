package com.example.usersystem.controller;

import com.example.usersystem.domain.User;
import com.example.usersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    // user service depends on UserService, decoupling
    // If there is no Autowired, maybe private UserService userService = new HashMapUserService(); coupling
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String HelloWorld() {
        return "Hello Spring!";
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
//        User res = new User();
//        res.setId(0L);
//        res.setRole("Test User");
//        return res;
        User user = userService.findById(id);
        return user;
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User input) {
        return userService.save(input);
    }

}
