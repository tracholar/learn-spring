package com.tracholar.web.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zuoyuan on 2018/12/27.
 */
@RestController
@RequestMapping("/conf")
public class MyConfigController {
    @Autowired
    private MyConfig myConfig;

    @RequestMapping("/")
    public Object getConf(){
        return myConfig.getFiles();
    }
}
