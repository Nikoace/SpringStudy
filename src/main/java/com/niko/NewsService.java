package com.niko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class NewsService {
    private final static Logger logger = LoggerFactory.getLogger ( NewsService.class );
    public News saveNews(News toSave){
        News result = null;
        if (toSave == null){
            logger.warn ( "save news is null" );
            return result;
        }
        if (toSave.getContent () == null){
            logger.warn ( "No content" );
            return result;
        }
        Calendar calendar = Calendar.getInstance ();
        calendar.add ( Calendar.DAY_OF_MONTH,1 );

        return result;
    }
    public News getNews(Long newsId){
        News n = new News ();
        if (newsId.intValue () == 1){
            n.setId ( 1L );
            n.setTitle ( "Hello" );
            n.setContent ( "hello word" );
            n.setDate ( new Date (  ) );
        }else if (newsId.intValue () == 2 ){
            n.setId ( 2L );
            n.setTitle ( "Hello!" );
            n.setContent ( "hello world" );
            n.setDate ( new Date (  ) );
        }
        return  n;
    }
}
