package com.niko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class NewsService {
    private final static Logger log =LoggerFactory.getLogger(NewsController1.class);
    public News1 saveNews(News1 tosave) {
        News1 result = null;
        //检查标题
        if(tosave==null) {
            log.warn("");
            return result;
        }

        if(tosave.getNews_content()==null||tosave.getNews_content().length()>50) {
            log.error("新闻为空");
            return result;
        }
        //自动修改日期
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        tosave.setNews_time("xx");
        return result;
    }

}
