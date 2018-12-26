#!/usr/bin/env bash

mvn clean package
if [ $? -ne 0 ]
then
    exit 1
fi

java -cp target/demo-1.0-SNAPSHOT-with-dependencies.jar  com.tracholar.web.demo.TestWebDemo

