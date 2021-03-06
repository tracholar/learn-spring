#!/usr/bin/env python
#coding:utf-8
import glob
import sys

import helloword
from helloword import HelloWorldServer

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer

import logging

logging.basicConfig(level=logging.INFO,
                    format='%(asctime)s %(filename)s[line:%(lineno)d] %(levelname)s %(message)s',
                    datefmt='%Y-%m-%d %H:%M:%S',
                    )


class HelloWorldHandler():
    def __init__(self):
        self.log = {}

    def call(self, name):
        logging.info("name = " + str(name))
        return "Hello, " + str(name)

if __name__ == '__main__':
    handler = HelloWorldHandler()
    processor = HelloWorldServer.Processor(handler)
    transport = TSocket.TServerSocket(host='0.0.0.0', port=9120)
    tfactory = TTransport.TBufferedTransportFactory()
    pfactory = TBinaryProtocol.TBinaryProtocolFactory()

    ## 多线程server
    server = TServer.TThreadedServer(processor, transport, tfactory, pfactory)

    logging.info('server info : ' + str(server))
    server.serve()

