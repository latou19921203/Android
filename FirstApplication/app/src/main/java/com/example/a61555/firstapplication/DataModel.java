package com.example.a61555.firstapplication;

/**
 * Created by 61555 on 2017/6/1.
 */

public class DataModel {

    private String data1;
    private String data2;
    private String data3;

    public DataModel(String data1, String data2, String data3){
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }
}
