package com.sdlabs.gpstracking;

class User {
    User(){

    }

    private String phone;
    private String name;
    private String id;
    private int plots;
    private String password;

    void setPhone(String ph){
        phone = ph;
    }

    void setName(String n){
        name = n;
    }

    void setID(String i){
        id = i;
    }

    void setPlot(int p){
        plots = p;
    }

    void setPassword(String n){
        password = n;
    }

    String getPhone(){ return phone;}
    String getName(){ return name;}
    String getId(){ return id;}
    String getPassword(){ return password;}
    int getPlots(){ return plots;}
}
