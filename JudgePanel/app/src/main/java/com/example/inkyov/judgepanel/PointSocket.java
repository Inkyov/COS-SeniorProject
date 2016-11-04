package com.example.inkyov.judgepanel;

import java.net.Socket;

/**
 * Created by Inkyov on 10/23/2016.
 */
public class PointSocket extends Thread {
    Socket client;
    private int port;

    PointSocket(int port){
        this.port = port;
    }

    @Override
    public void run(){
        try{
            client = new Socket("192.168.0.101", port);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
