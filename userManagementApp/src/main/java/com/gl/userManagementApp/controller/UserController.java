package com.gl.userManagementApp.controller;

import com.gl.userManagementApp.dto.User;
import com.gl.userManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
public class UserController {

   @Autowired
    private UserService userService;

    @GetMapping("/Users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
          }

    @GetMapping("/User/{id}")
     public User getUser(@PathVariable String id){
        return userService.getUser(id);
     }

     @PostMapping("/User")
     public ResponseEntity<Object> addUser(@RequestBody User user){
        userService.addUser(user);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(path).build();
     }

     @PutMapping("/user")
     public User updateUser(@RequestBody User user){

        return userService.updateUser(user);
     }

     @DeleteMapping("/user/{id}")
     public  User deleteUser(@PathVariable String id){

        return userService.deleteUser(id);
     }
}
