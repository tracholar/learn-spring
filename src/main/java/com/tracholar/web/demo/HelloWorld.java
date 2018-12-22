package com.tracholar.web.demo;

import com.tracholar.web.dao.Student;
import com.tracholar.web.dao.StudentJDBCTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zuoyuan on 2018/12/17.
 */
public class HelloWorld implements InitializingBean {
    public void afterPropertiesSet() {
        System.out.println("*********** after properties set **********");
    }

    public void init(){
        System.out.println("*********** init **********");
    }
    public void destroy(){
        System.out.println("*********** destroy **********");
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public void sayHi(){
        System.out.println("*************** Hello World! *****************");
        System.out.println(msg);
    }

    public void testClassConf(){
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorld hw = context.getBean(HelloWorld.class);

        hw.sayHi();
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
        ctx.start();

        HelloWorld hw = (HelloWorld) ctx.getBean("helloWorld");
        hw.sayHi();


        CustomEventPublisher cep = (CustomEventPublisher) ctx.getBean("publisher1");
        cep.publish();
        cep.publish();


        StudentJDBCTemplate tmp = (StudentJDBCTemplate)ctx.getBean("studentTmp");

        tmp.create("Andy", 11);
        tmp.create("John", 31);
        tmp.create("Jack", 40);


        for(Student s : tmp.listStudents()) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge());
        }

        ctx.stop();


    }
}
