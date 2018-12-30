package com.tracholar.web.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zuoyuan on 2018/12/27.
 */
public class BasicBean {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value = "";

    public long getId() {
        return id;
    }

    @Autowired
    private long id = 24234324234324L;


    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("Beans.xml");
        BasicBean bean = (BasicBean) factory.getBean("test_bean");
        System.out.println(bean.getValue());
    }
}
