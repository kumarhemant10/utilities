package com.hk.prj.jsontocsv.reader;

import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public JSONParser jsonParser(){
        return new JSONParser();
    }
}
