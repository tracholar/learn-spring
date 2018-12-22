package com.tracholar.web.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * Created by zuoyuan on 2018/12/17.
 */
public class CStartEventHandler implements ApplicationListener<ApplicationEvent> {
    public void onApplicationEvent(ApplicationEvent evt){
        System.out.println(evt);
    }
}
