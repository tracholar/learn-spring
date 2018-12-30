package com.tracholar.web.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by zuoyuan on 18/8/4.
 */

@SpringBootApplication
public class TestWebDemo {
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView indexView = new ModelAndView();
        indexView.setViewName("index");
        return indexView;
    }

    @RequestMapping("/test")
    public String test(){
            InputStream is = getClass().getResourceAsStream("/templates/index.html");
            return "";

    }

    @RequestMapping("/reset")
    public void reset(HttpServletResponse response) throws IOException{
        response.sendRedirect("/");
    }

    @RequestMapping(value = "/api", produces = "application/json; charset=UTF-8")
    public String api() {
        JSONObject js = new JSONObject();
        js.put("uid", "2312321312");
        js.put("status", "success");
        js.put("header", JSONObject.parse("{\"content-type\":\"application/json\"}"));
        return js.toString();
    }


    public static void main(String[] args){
        SpringApplication.run(TestWebDemo.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        final ApplicationContext c = ctx;
        return new CommandLineRunner(){
            public void run(String[] args){
                System.out.println("Let's inspect the beans provided by Spring Boot:");

                String[] beanNames = c.getBeanDefinitionNames();
                Arrays.sort(beanNames);
                for (String beanName : beanNames) {
                    System.out.println(beanName);
                }
            }
        };
    }
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory =
                new TomcatEmbeddedServletContainerFactory();
        return factory;
    }
}
