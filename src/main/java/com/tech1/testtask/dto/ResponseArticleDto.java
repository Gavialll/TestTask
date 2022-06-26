package com.tech1.testtask.dto;

import com.tech1.testtask.color.Color;
import com.tech1.testtask.models.Article;
import lombok.Getter;

@Getter
public class ResponseArticleDto {
    private Long id;
    private Long userId;
    private String text;
    private Color color;

    public ResponseArticleDto() {
    }

    public ResponseArticleDto(Article article) {
        this.id = article.getId();
        this.userId = article.getUser().getId();
        this.text = article.getText();
        this.color = article.getColor();
    }

    public ResponseArticleDto setId(Long id) {
        this.id = id;
        return ResponseArticleDto.this;
    }

    public ResponseArticleDto setUserId(Long userId) {
        this.userId = userId;
        return ResponseArticleDto.this;
    }

    public ResponseArticleDto setText(String text) {
        this.text = text;
        return ResponseArticleDto.this;
    }

    public ResponseArticleDto setColor(Color color) {
        this.color = color;
        return ResponseArticleDto.this;
    }
}
