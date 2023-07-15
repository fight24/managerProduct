package com.website.managerProduct.PresentationLayer;


import com.website.managerProduct.Entity.User;
import com.website.managerProduct.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;
    @GetMapping("/apiUser")
    public ResponseEntity<List<User>> methodGetAllUser(){
        return (userService.getAllUser().isEmpty())?new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("/apiUser/{id}")
    public ResponseEntity<User> methodGetUserById(@PathVariable("id") long id){


        return (userService.getUserByIdUser(id).isPresent())? new ResponseEntity<>(
                userService.getUserByIdUser(id).get(),HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/apiUser")
    public ResponseEntity<User> methodCreateUser(@RequestBody User user){
        try{
            userService.createUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @PutMapping("/apiUser/{id}")
    public ResponseEntity<Boolean> methodUpdateUser(@PathVariable("id") long id,@RequestBody User user){
        try{
            if(userService.updateUser(id,user)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/apiUser")
    public ResponseEntity<Boolean> methodDeleteUser(){
        return (userService.deleteUserAll()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/apiUser/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable("id") long id){
        return (userService.deleteUserById(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
