package com.example.a61555.maintenance_demo10.model;

/**
 * Created by 61555 on 2017/8/17.
 */

public class ParameterRecordModel {

    private float jddy;//机端电压
    private float jddl;//机端电流
    private float jdpl;//机端频率
    private float glys;//功率因数
    private float yggl;//有功功率
    private float wggl;//无功功率
    private float jzzs;//机组转速
    private float dykd;//导叶开度
    private float tlw;//推力瓦
    private float jxw;//径向瓦
    private float dw;//大瓦
    private float qzw;//前轴瓦
    private float hzw;//后轴瓦
    private float dwdy;//电网电压
    private float dwsl;//电网电流
    private float sw;//水位
    private String watcher;//值班员

    public String getWatcher() {
        return watcher;
    }

    public void setWatcher(String watcher) {
        this.watcher = watcher;
    }

    public float getJddy() {
        return jddy;
    }

    public void setJddy(float jddy) {
        this.jddy = jddy;
    }

    public float getJddl() {
        return jddl;
    }

    public void setJddl(float jddl) {
        this.jddl = jddl;
    }

    public float getJdpl() {
        return jdpl;
    }

    public void setJdpl(float jdpl) {
        this.jdpl = jdpl;
    }

    public float getGlys() {
        return glys;
    }

    public void setGlys(float glys) {
        this.glys = glys;
    }

    public float getYggl() {
        return yggl;
    }

    public void setYggl(float yggl) {
        this.yggl = yggl;
    }

    public float getWggl() {
        return wggl;
    }

    public void setWggl(float wggl) {
        this.wggl = wggl;
    }

    public float getJzzs() {
        return jzzs;
    }

    public void setJzzs(float jzzs) {
        this.jzzs = jzzs;
    }

    public float getDykd() {
        return dykd;
    }

    public void setDykd(float dykd) {
        this.dykd = dykd;
    }

    public float getTlw() {
        return tlw;
    }

    public void setTlw(float tlw) {
        this.tlw = tlw;
    }

    public float getJxw() {
        return jxw;
    }

    public void setJxw(float jxw) {
        this.jxw = jxw;
    }

    public float getDw() {
        return dw;
    }

    public void setDw(float dw) {
        this.dw = dw;
    }

    public float getQzw() {
        return qzw;
    }

    public void setQzw(float qzw) {
        this.qzw = qzw;
    }

    public float getHzw() {
        return hzw;
    }

    public void setHzw(float hzw) {
        this.hzw = hzw;
    }

    public float getDwdy() {
        return dwdy;
    }

    public void setDwdy(float dwdy) {
        this.dwdy = dwdy;
    }

    public float getDwsl() {
        return dwsl;
    }

    public void setDwsl(float dwsl) {
        this.dwsl = dwsl;
    }

    public float getSw() {
        return sw;
    }

    public void setSw(float sw) {
        this.sw = sw;
    }
}
