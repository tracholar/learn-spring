package com.tracholar.web.demo;

import com.tracholar.protobuf.Libsvm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by zuoyuan on 2018/12/24.
 */
public class TestLibsvm {
    public static void main(String[] args) {
        Libsvm.DataSet.Builder dataSet = Libsvm.DataSet.newBuilder();
        Random r = new Random();
        for(int i=0; i< 1000; i++){
            Libsvm.LabelPoint.Builder lp = Libsvm.LabelPoint.newBuilder();
            for(int j=0; j<5; j++){
                Libsvm.LabelPoint.Point pb = Libsvm.LabelPoint.Point
                        .newBuilder()
                        .setF(j)
                        .setX(r.nextInt())
                        .setY(r.nextFloat())
                        .build();
                lp.addFeature(pb);
            }
            //lp.setRowid(r.nextLong() + "");
            dataSet.addLp(lp);
        }
        Libsvm.DataSet dataset = dataSet.build();
        try {
            dataset.writeTo(new FileOutputStream("train.data"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
