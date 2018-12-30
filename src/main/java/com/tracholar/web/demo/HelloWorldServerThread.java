package com.tracholar.web.demo;

import com.tracholar.thrift.HelloWorldServer;
import com.tracholar.web.impl.HelloWorldServerImpl;
import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

import java.net.ServerSocket;

/**
 * Created by zuoyuan on 2018/12/28.
 */
public class HelloWorldServerThread {
    public static final int port = 9120;
    public static void main(String[] args) throws Exception{
        ServerSocket socket = new ServerSocket(port);
        TServerSocket tsocket = new TServerSocket(socket);
        HelloWorldServer.Processor processor = new HelloWorldServer.Processor(new HelloWorldServerImpl());
        TServer server = new TSimpleServer(new TServer.Args(tsocket).processor(processor));
        System.out.println("Starting the simple server...");
        server.serve();
    }
}
