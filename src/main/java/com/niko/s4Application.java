package com.niko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class s4Application {

    @Autowired
    private AuthorSettings authorSettings;
    @RequestMapping("/")
    public String index(){
        return "author name is "+authorSettings.getName ()+" and author age is "+authorSettings.getAge ();
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder ( s4Application.class ).bannerMode ( Banner.Mode.OFF ).run ( args );

    }
}