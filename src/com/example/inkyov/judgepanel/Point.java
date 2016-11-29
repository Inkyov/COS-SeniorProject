package com.example.inkyov.judgepanel;

import java.io.Serializable;

/**
 * Created by Inkyov on 11/22/2016.
 */
public class Point implements Serializable{
    String color;
    int point;
    int port;
    private static final long serialVersionUID = 78931958389436584L;

    Point(String color, int point, int port){
        this.color = color;
        this.point = point;
        this.port = port;
    }

    public String getColor(){
        return this.color;
    }

    public int getPoint(){
        return this.point;
    }

    public int getPort() {
        return this.port;
    }
}
