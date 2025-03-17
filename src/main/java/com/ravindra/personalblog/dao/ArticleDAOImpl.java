package com.ravindra.personalblog.dao;

import com.ravindra.personalblog.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDAOImpl implements ArticleDAO{

    EntityManager entityManager;
    @Autowired
    public ArticleDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Article> findAll() {
        TypedQuery<Article> query = entityManager.createQuery("from Article", Article.class);

        return query.getResultList();
    }

    @Override
    public Article findById(int id) {
        TypedQuery<Article> query = entityManager.createQuery("from Article WHERE articleId=:data", Article.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public void deleteById(int id) {
        Article article = findById(id);
        entityManager.remove(article);
    }

    @Override
    public void updateArticle(Article article) {
        entityManager.merge(article);
    }

    @Override
    public void createArticle(Article article) {
        entityManager.persist(article);
    }
}
