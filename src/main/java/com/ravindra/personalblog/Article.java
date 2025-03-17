package com.ravindra.personalblog;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "articles")
public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int articleId;

    @Column(name = "article_name")
    String articleName;

    @Column(name = "description")
    String description;

    @Column(name = "date_created")
    String dateCreated;

    @Column(name = "date_last_modified")
    String dateLastModified;

    public Article() {
    }

    public Article(String articleName, String description, String dateCreated, String dateLastModified) {
        this.articleName = articleName;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateLastModified = dateLastModified;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(String dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                "articleName='" + articleName + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateLastModified=" + dateLastModified +
                '}';
    }
}
