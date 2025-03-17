package com.ravindra.personalblog.dao;

import com.ravindra.personalblog.Article;

import java.util.List;

public interface ArticleDAO {
    public List<Article> findAll();

    public Article findById(int id);

    public void deleteById(int id);

    public void updateArticle(Article article);

    public void createArticle(Article article);
}
