package com.tracholar.web.demo;

import com.tracholar.thrift.HelloWorldServer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zuoyuan on 2018/12/28.
 */
@Configuration
@RestController
@RequestMapping("/thrift")
public class HelloWorldClient {
    private HelloWorldServer.Client client;

    public HelloWorldClient() throws Exception {
        this("localhost", HelloWorldServerThread.port);
    }
    public HelloWorldClient(String host, int port) throws Exception{
        TTransport transport = new TSocket(host,  port);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        client = new HelloWorldServer.Client(protocol);
    }

    @RequestMapping("/hello")
    public String sayHi(@RequestParam(name = "name", defaultValue = "world") String name) throws Exception{
        return client.call(name);
    }

    public static void main(String[] args) throws Exception {
        if(args.length == 2){
            HelloWorldClient client = new HelloWorldClient(args[0], Integer.parseInt(args[1]));
            System.out.println(client.sayHi("world"));
        }
    }
}
