package sample;

import javafx.concurrent.Task;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Inkyov on 9/26/2016.
 */
class PointsSocket extends Task {

    private int port = 0;
    Socket clientSocket = null;
    ServerSocket serverSocket = null;
    DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;

    PointsSocket(int port){
        this.port = port;
    }

    @Override
    protected Object call() throws Exception{
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Listening: " + port);
            clientSocket = serverSocket.accept();
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            //String msg;
            try{

                System.out.println("message: " + dataInputStream.readUTF());
                System.out.println(clientSocket.isConnected());
                System.out.println(serverSocket.isClosed());


            }catch (EOFException e){
                System.out.print("fuck");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
