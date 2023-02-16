package com.example.learnStream.controller;

import com.example.learnStream.Service.UserService;

import com.example.learnStream.dto.UsersDto;
import com.example.learnStream.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user){
      return userService.registerUser(user);
    }

    @GetMapping("/getalluser")
    public ResponseEntity<List<UsersDto>> getUsers(){
        List<UsersDto>usersDtos=userService.getUsers();
        return ResponseEntity.ok(usersDtos);
    }

    @PostMapping("/savee")
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto){
        UsersDto usersDto1= userService.createUser(usersDto);
        return ResponseEntity.ok(usersDto1);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<UsersDto> getUserId(@PathVariable Long id){
        UsersDto usersDto1=userService.getUserId(id);
        return ResponseEntity.ok(usersDto1);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUserId(@PathVariable("id") Long id){
       return userService.deleteUserId(id);

    }

}
