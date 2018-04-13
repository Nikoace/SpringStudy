package com.niko;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final static Logger log = LoggerFactory.getLogger(NewsController1.class);

    @Autowired
    private NewsService newsService;
    /**
     * 增加新闻
     * @param news
     * @return
     */
    @PostMapping
    public boolean saveNews(@RequestBody News1 news) {
        News1 result = newsService.saveNews(news);
        if (result != null) {
            return true;
        }
        return false;
    }
    /**
     * 修改新闻
     * @param toUpdateNews
     * @return
     */
    @PutMapping
    public boolean updateNews(@RequestBody News1 toUpdateNews) {
        boolean result;
        log.debug(toUpdateNews.toString());
        //TODO 把toUpdateNews保存到数据库
        result = true;

        return result;
    }

    @DeleteMapping("/{id}")
    public boolean deleteNews(@PathVariable("id") int news_id) {
        boolean result = false;
        log.debug("即将删除编号为"+news_id+"的新闻！");
        //TODO 从数据库中删除该新闻
        result = true;
        return result;
    }

    @GetMapping(path="/{id}")
    public News1 getNews(@PathVariable("id") Long newsId) {
        log.debug("准备读取新闻："+ newsId);
        //TODO
        return null;
    }

    @GetMapping
    public List<News> getAllNews() {
        List<News> result  = new ArrayList<>();
        News n1 = new News1();
        n1.setNews_id(1);
        n1.setNews_content("hello");
        News n2 = new News1();
        n2.setNews_id(2);
        n2.setNews_content("Nice to see u");
        result.add(n1);
        result.add(n2);

        return result;
    }

}