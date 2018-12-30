package com.tracholar.web.impl;

import com.tracholar.thrift.HelloWorldServer;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zuoyuan on 2018/12/28.
 */
public class HelloWorldServerImpl implements HelloWorldServer.Iface {
    @Override
    public String call(String name) throws TException{
        return "Hello, " + name + "! Now: " + (new Date());
    }
}
