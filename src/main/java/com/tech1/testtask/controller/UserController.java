package com.tech1.testtask.controller;

import com.tech1.testtask.color.Color;
import com.tech1.testtask.color.exception.ColorNotFoundException;
import com.tech1.testtask.dto.CreateUserDto;
import com.tech1.testtask.dto.ResponseUserDto;
import com.tech1.testtask.models.User;
import com.tech1.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users_older_than")
    public List<ResponseUserDto> usersOlderThan(@RequestParam() Integer age){
        return ResponseUserDto.mapFrom(userService.usersOlderThan(age));
    }

    @GetMapping("/users_by_article_color")
    public Set<User> usersByArticleColor(@RequestParam() String color){
        try{
            return userService.usersByArticleColor(Color.valueOf(color.toUpperCase()));
        }catch(IllegalArgumentException e){
            throw new ColorNotFoundException("Color not found");
        }
    }

    @PostMapping("/user/add")
    public ResponseUserDto add(@RequestBody CreateUserDto createUserDto){
        return new ResponseUserDto(userService.add(new User(createUserDto)));
    }

    @GetMapping("/user/distinct")
    public Set<String> distinctUsers(){
        return userService.distinctUsers();
    }
}
