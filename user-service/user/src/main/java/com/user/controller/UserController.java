package com.user.controller;


import com.user.dto.UserDTO;
import com.user.entities.UserInfoEntity;
import com.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "")
public class UserController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    /**
     * Method for creating Hotels
     * 127.0.0.1:8080/Hotel_app/v1/Hotels
     */


    @PostMapping(value = "api/v1/users", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewUser(@RequestBody UserDTO userDTO) {
        UserInfoEntity savedUserDetails = userService.saveUserDetails(userDTO);
        //returns the response dto and status as created
        return new ResponseEntity(savedUserDetails, HttpStatus.CREATED);
    }

    //method to fetch user details from the database
    @GetMapping(value = "api/v1/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserDetails(@PathVariable int id) {
        UserInfoEntity getUserDetails = userService.getUserDetails(id);
        //returns the response dto and status as created
        return new ResponseEntity(getUserDetails, HttpStatus.CREATED);
    }
}
