package com.niko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class NewsService {
    private final static Logger logger = LoggerFactory.getLogger ( NewsService.class );
    @Autowired
    private  NewsRepo repo;

    public News saveNews(News toSave){
        News result = null;
        if (toSave == null){
            logger.warn ( "save news is null" );
            return result;
        }
        if (toSave.getNews_content () == null){
            logger.warn ( "No content" );
            return result;
        }
        Calendar calendar = Calendar.getInstance ();
        calendar.add ( Calendar.DAY_OF_MONTH,1 );
        result = repo.save ( toSave );
        return result;
    }
    public News getNews(Long newsId){
        News n = new News ();
        if (newsId.intValue () == 1){
            n.setNews_id ( 1 );
            n.setNews_content ( "hello word" );
            n.setNews_time ( new Date (  ).toString () );
        }else if (newsId.intValue () == 2 ){
            n.setNews_id ( 2 );
            n.setNews_content ( "hello world" );
            n.setNews_time ( new Date (  ).toString () );
        }
        return  n;
    }
}
