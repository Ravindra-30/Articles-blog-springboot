package com.ravindra.personalblog.service;

import com.ravindra.personalblog.Article;
import com.ravindra.personalblog.dao.ArticleDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    ArticleDAO articleDAO;

    @Autowired
    public ArticleServiceImpl(ArticleDAO articleDAO){
        this.articleDAO = articleDAO;
    }

    @Override
    public List<Article> findAll() {
        return articleDAO.findAll();
    }

    @Override
    public Article findById(int id) {
        return articleDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        articleDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
    }

    @Override
    @Transactional
    public void createArticle(Article article) {
        articleDAO.createArticle(article);
    }
}
