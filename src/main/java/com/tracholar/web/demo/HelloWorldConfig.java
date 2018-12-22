package com.tracholar.web.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zuoyuan on 2018/12/17.
 */
@Configuration
public class HelloWorldConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }
}
