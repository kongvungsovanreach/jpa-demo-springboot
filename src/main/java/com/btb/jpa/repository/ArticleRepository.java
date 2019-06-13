package com.btb.jpa.repository;

import com.btb.jpa.repository.model.Article;

import java.util.List;

public interface ArticleRepository {
    List<Article> findAl();
    Article findById(int id);
    void insert(Article article);
    void delete(int id);
    void update(Article article);
}
