package com.tech1.testtask.service;

import com.tech1.testtask.color.Color;
import com.tech1.testtask.models.Article;
import com.tech1.testtask.models.User;
import com.tech1.testtask.respository.ArticleRepository;
import com.tech1.testtask.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<User> usersOlderThan(Integer age){
        return userRepository.usersOlderThan(age);
    }

    public Set<User> usersByArticleColor(Color color){
        return articleRepository.findByColor(color.name()).stream().map(Article::getUser).collect(Collectors.toSet());
    }

    public User add(User user){
        return userRepository.save(user);
    }

    public Set<String> distinctUsers(){
         Set<String> set = userRepository.findAll().stream()
                 .filter(user -> user.getArticles().size() > 3)
                 .map(User::getName)
                 .collect(Collectors.toSet());
         return set;
    }
}
