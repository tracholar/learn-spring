package com.tracholar.web.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuoyuan on 2018/12/27.
 */

@Component
@ConfigurationProperties(prefix = "my.conf")
public class MyConfig {
    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    private List<String> files = new ArrayList<>();

}
