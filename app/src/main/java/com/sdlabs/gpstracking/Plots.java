package com.sdlabs.gpstracking;

public class Plots {
    Plots(){

    }

    private int plot_no;
    private String id;
    private double lat;
    private double lon;
    private int sensor;

    void setPlot_no(int p){
        plot_no = p;
    }

    void setId(String i){
        id = i;
    }

    void setLat(double l){
        lat = l;
    }

    void setLon(double l){
        lon = l;
    }

    void setSensor(int s){
        sensor = s;
    }

    String getId(){ return id;}
    int getPlot_no(){ return plot_no;}
    double getLat(){ return lat;}
    double getLon(){ return lon;}
    int getSensor(){ return sensor;}
}
