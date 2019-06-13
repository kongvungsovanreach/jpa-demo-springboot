package com.btb.jpa.service;

import com.btb.jpa.repository.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAl();
    Article findById(int id);
    void insert(Article article);
    void delete(int id);
    void update(Article article);
}
