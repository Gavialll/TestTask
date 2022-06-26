package com.tech1.testtask.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tech1.testtask.color.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    private User user;
    private String text;
    @Enumerated(EnumType.STRING)
    private Color color;

    public Article setUser(User user) {
        this.user = user;
        return Article.this;
    }

    public Article setText(String text) {
        this.text = text;
        return Article.this;
    }

    public Article setColor(Color color) {
        this.color = color;
        return Article.this;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Article article = (Article) o;
        return id != null && Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}