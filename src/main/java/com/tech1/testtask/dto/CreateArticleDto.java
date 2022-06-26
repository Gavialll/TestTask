package com.tech1.testtask.dto;

import com.tech1.testtask.color.Color;
import lombok.Getter;

@Getter
public class CreateArticleDto {
    private Long userId;
    private String text;
    private Color color;

    public CreateArticleDto(Long userId, String text, Color color) {
        this.userId = userId;
        this.text = text;
        this.color = color;
    }
}


