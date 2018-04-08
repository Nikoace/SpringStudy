package com.niko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final static Logger log = LoggerFactory.getLogger ( NewsController.class );

    @Autowired
    private NewsService newsService;

    @PostMapping
    public boolean saveNews(@RequestBody News news){
        News result = newsService.saveNews ( news );
        if (result != null){
            return true;
        }
        return false;
    }
    @PutMapping
    public boolean updateNews(@RequestBody News toUpdateNews) {
        boolean result = false;
        log.debug(toUpdateNews.toString());
        //TODO 把toUpdateNews保存到数据库
        result = true;

        return result;
    }

    @DeleteMapping("/{id}")
    public boolean deleteNews(@PathVariable("id") int news_id) {
        boolean result;
        log.debug("即将删除编号为"+news_id+"的新闻！");
        //TODO 从数据库中删除该新闻
        result = true;
        return result;
    }
    @GetMapping(path="/{id}")
    public News getNews(@PathVariable("id") Long newsId) {
        log.debug("准备读取新闻："+ newsId);
        //TODO
        return null;
    }

    @GetMapping
    public List<News> getAllNews() {
        List<News> result  = new ArrayList <> ();
        News n1 = new News();
        n1.setNews_id(1);
        n1.setNews_content("heelo");
        News n2 = new News();
        n2.setNews_id(2);
        n2.setNews_content("Nice to see u");
//        result.add(n1);
//        result.add(n2);

        return result;
    }
}
