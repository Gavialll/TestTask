package com.tech1.testtask.controller;

import com.tech1.testtask.dto.CreateArticleDto;
import com.tech1.testtask.dto.ResponseArticleDto;
import com.tech1.testtask.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public ResponseArticleDto add(@RequestBody CreateArticleDto createArticleDto){
       return new ResponseArticleDto(articleService.add(createArticleDto));
    }
}
