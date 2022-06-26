package com.tech1.testtask.service;

import com.tech1.testtask.controller.exeption.UserNotFound;
import com.tech1.testtask.dto.CreateArticleDto;
import com.tech1.testtask.models.Article;
import com.tech1.testtask.models.User;
import com.tech1.testtask.respository.ArticleRepository;
import com.tech1.testtask.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public Article add(CreateArticleDto createArticleDto){
       User user = userRepository.findById(createArticleDto.getUserId()).orElseThrow(UserNotFound::new);

       Article article = new Article()
               .setText(createArticleDto.getText())
               .setColor(createArticleDto.getColor())
               .setUser(user);

       return articleRepository.save(article);
    }
}
