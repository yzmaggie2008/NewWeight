package com.example.yumimama.weightloss;

/**
 * Created by yumimama on 1/18/18.
 */

public class historyData {
    private int id;
    private String date;
    private String wh;
    private String tips;

    public  historyData(int id, String date, String wh, String tips){
        this.id = id;
        this.date = date;
        this.wh = wh;
        this.tips = tips;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWh() {
        return wh;
    }

    public void setWh(String wh) {
        this.wh = wh;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
