package com.ravindra.personalblog.controller;

import com.ravindra.personalblog.Article;
import com.ravindra.personalblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {

    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String redirectHome(Model model){
        return "redirect:/home";
    }


    @GetMapping("/home")
    public String getArticleList(Model model){
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);

        return "home";
    }

    @GetMapping("/article/{articleId}")
    public String getArticleList(@PathVariable int articleId, Model model){
        Article article = articleService.findById(articleId);
        model.addAttribute("article", article);

        return "article-page";
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model){
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);

        return "admin-page";
    }

    @GetMapping("/edit/{articleId}")
    public String getEditPage(@PathVariable int articleId, Model model){
        Article article = articleService.findById(articleId);
        model.addAttribute("article", article);

        return "edit-page";
    }

    @GetMapping("/new")
    public String getEditPage(Model model){
        Article article = new Article();
        model.addAttribute("article", article);

        return "edit-page";
    }

    @PostMapping("/save")
    public String updateArticle(@ModelAttribute("article") Article article){
        System.out.println("Saving the article: "+article);
        if(article.getArticleId() == 0){
            articleService.createArticle(article);
            return "redirect:/admin";
        }
        articleService.updateArticle(article);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{articleId}")
    public String deleteArticle(@PathVariable int articleId, Model model){
        articleService.deleteById(articleId);
        return "redirect:/admin";
    }
}
