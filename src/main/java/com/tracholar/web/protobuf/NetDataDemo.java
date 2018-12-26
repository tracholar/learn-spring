package com.tracholar.web.protobuf;

import com.google.protobuf.ByteString;

/**
 * Created by zuoyuan on 2018/12/24.
 */
public class NetDataDemo {
    public static void main(String[] args) {
        NetData.netdata data = NetData.netdata.newBuilder()
                .setId(1)
                .setData(ByteString.copyFrom("afasfsdfads".getBytes())).build();

        System.out.println(data);
    }
}
