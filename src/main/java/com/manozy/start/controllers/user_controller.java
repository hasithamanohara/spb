package com.manozy.start.controllers;

import com.manozy.start.dto.userDto;
import com.manozy.start.service.userService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin

public class user_controller {
    @Autowired
    userService userservice;
    @Autowired
    private ModelMapper modelMapper;

    //save_user
    @PostMapping("/saveUser")
    public ResponseEntity<userDto> saveUser(@RequestBody userDto userdto,@Valid BindingResult result) {
        if (result.hasErrors()) return ResponseEntity.badRequest().body(null);
        userDto savedUser = userservice.saveUser(userdto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //get user
    @GetMapping("/users")
    public List<userDto> getUser() {
        return userservice.getAllUsers();
    }

    //update user
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<userDto> userUpdate(@PathVariable int id, @RequestBody userDto userdto) {
        userDto updatedUser = userservice.updateUser(id, userdto);
        return updatedUser != null
                ? ResponseEntity.ok(updatedUser)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //delete user
    @DeleteMapping("/deleteUser")
    public boolean deleteUser(userDto userDto) {
        return userservice.deleteUser(userDto);
    }

}





