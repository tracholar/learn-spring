package com.tracholar.web.demo;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zuoyuan on 2018/12/27.
 */
@RestController
@Configuration
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/")
    public BasicBean greeting(@RequestParam(value="name", defaultValue="World") String name) {
        BasicBean bean = new BasicBean();
        bean.setValue(String.format(template, name));

        return bean;
    }

    @RequestMapping("/test")
    public String test() {
        return "Hello Test";
    }
}
