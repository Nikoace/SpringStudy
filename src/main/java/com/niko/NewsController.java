package com.niko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final static Logger log = LoggerFactory.getLogger ( NewsController.class );

    @Autowired
    private NewsService service;
    @RequestMapping("/{id}")
    public News getNews(@PathVariable("id") Long newsId){
        return service.getNews ( newsId );
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean addNews(@RequestBody News news){
        System.out.println ( "News " + news.getTitle () + "has been saved" );
        return true;
    }
}
