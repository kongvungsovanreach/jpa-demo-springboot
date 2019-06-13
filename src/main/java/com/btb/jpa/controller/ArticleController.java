package com.btb.jpa.controller;

import com.btb.jpa.repository.model.Article;
import com.btb.jpa.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String findAll(ModelMap modelMap){
        modelMap.addAttribute("articles",articleService.findAl());
        return "index";
    }
    @GetMapping("/find/{id}")
    public String findById(ModelMap modelMap, @PathVariable int id){
        modelMap.addAttribute("articles",articleService.findById(id));
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String delete(ModelMap modelMap,@PathVariable int id){
        articleService.delete(id);
        modelMap.addAttribute("articles",articleService.findAl());
        return "redirect:/";
    }
    @GetMapping("/add")
    public String add(ModelMap modelMap){
        Article article = new Article("asdfasdf");
        articleService.insert(article);
        modelMap.addAttribute("articles",articleService.findAl());
        return "redirect:/";
    }
    @GetMapping("/update")
    public String update(ModelMap modelMap, @RequestParam int id, @RequestParam String title){
        Article article = new Article(id,title);
        articleService.update(article);
        modelMap.addAttribute("articles",articleService.findAl());
        return "redirect:/";
    }

}
