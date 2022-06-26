package com.tech1.testtask.respository;

import com.tech1.testtask.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT * FROM articles WHERE color = ?1", nativeQuery = true)
    List<Article> findByColor(String color);
}
