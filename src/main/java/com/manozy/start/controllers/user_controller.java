package com.manozy.start.controllers;

import com.manozy.start.dto.userDto;
import com.manozy.start.service.userService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin

public class user_controller {
    final
    userService userservice;

    public user_controller(userService userservice) {
        this.userservice = userservice;
    }

    //get user
    @GetMapping("/getUser")
    public String getUser() {
        return "Hello World";
    }

    //save_user
    @PostMapping("/saveUser")
    public userDto saveUser(@RequestBody userDto userdto) {
        return userservice.saveUser(userdto);
    }

    //delete user
    @DeleteMapping("/deleteUser")
    public String deleteUser() {
        return "user deleted";
    }

    //update user
    @PutMapping("/updateUser")
    public String updateUser() {
        return "user data updated";
    }

}





