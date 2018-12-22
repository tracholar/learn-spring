package com.tracholar.web.demo;

import org.springframework.context.ApplicationEvent;

/**
 * Created by zuoyuan on 2018/12/17.
 */
public class CustomEvent extends ApplicationEvent{
    public CustomEvent(Object source){
        super(source);
    }
    private static int invokNum = 0;
    public String toString(){
        invokNum++;
        return "My Custom Event " + invokNum;
    }
}
