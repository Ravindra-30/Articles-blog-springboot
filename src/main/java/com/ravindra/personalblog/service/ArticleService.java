package com.ravindra.personalblog.service;

import com.ravindra.personalblog.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> findAll();

    public Article findById(int id);

    public void deleteById(int id);

    public void updateArticle(Article article);

    public void createArticle(Article article);
}
