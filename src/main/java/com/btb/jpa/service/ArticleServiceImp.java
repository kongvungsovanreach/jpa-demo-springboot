package com.btb.jpa.service;

import com.btb.jpa.repository.ArticleRepository;
import com.btb.jpa.repository.ArticleRepositoryJPA;
import com.btb.jpa.repository.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    ArticleRepositoryJPA articleRepository;

    @Override
    public List<Article> findAl() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(int id) {

        return articleRepository.findById(id).get();
    }

    @Override
    public void insert(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void delete(int id) {
        articleRepository.delete(findById(id));
    }

    @Override
    public void update(Article article) {
        Article article1 = findById(article.getId());
        article1.setTitle(article.getTitle());
        articleRepository.save(article1);
    }
}
