package sample;

import javafx.concurrent.Task;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Inkyov on 9/26/2016.
 */
class PointsSocket extends Task {

    private int port = 0;
    Socket clientSocket = null;
    ServerSocket serverSocket = null;
    DataInputStream dataInputStream = null;

    PointsSocket(int port){
        this.port = port;
    }

    @Override
    protected Object call() throws Exception{
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Listening: " + port);
            while (true) {
                //while the connection is up accept the packets I need a flag or smth to check and execute the accept method
                //accept the packets
                clientSocket = serverSocket.accept();
                dataInputStream = new DataInputStream(clientSocket.getInputStream());
                int k = dataInputStream.readInt();
                System.out.print(k);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
