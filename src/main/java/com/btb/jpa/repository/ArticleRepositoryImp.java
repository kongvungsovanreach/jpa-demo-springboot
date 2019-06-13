package com.btb.jpa.repository;

import com.btb.jpa.repository.model.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ArticleRepositoryImp implements ArticleRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Article> findAl() {
        return entityManager.createQuery("from Article").getResultList();
    }

    @Override
    public Article findById(int id) {
        return entityManager.find(Article.class,id);
    }
    @Transactional
    @Override
    public void insert(Article article) {
        entityManager.persist(article);
    }
    @Transactional
    @Override
    public void delete(int id) {
        Article article = findById(id);
        entityManager.remove(article);
    }
    @Transactional
    @Override
    public void update(Article article) {
        Article article1 = findById(article.getId());
        article1.setTitle(article.getTitle());
        entityManager.merge(article1);
    }
}
