package com.tech1.testtask.models;

import com.tech1.testtask.dto.CreateUserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Article> articles = new ArrayList<>();

    public User(CreateUserDto createUserDto) {
        this.name = createUserDto.getName();
        this.age = createUserDto.getAge();
    }

    public User setName(String name){
        this.name = name;
        return User.this;
    }

    public User setArticles(List<Article> articles) {
        this.articles = articles;
        return User.this;
    }

    public User setArticle(Article article) {
        this.articles.add(article);
        return User.this;
    }


    public User setAge(Integer age){
        this.age = age;
        return User.this;
    }

    public User setId(Long id) {
        this.id = id;
        return User.this;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
