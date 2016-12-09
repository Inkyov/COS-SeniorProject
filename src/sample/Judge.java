package sample;

import com.example.inkyov.judgepanel.Point;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * Created by Inkyov on 11/24/2016.
 */
public class Judge extends Task{

    private int port = 0;
    Socket clientSocket = null;
    ServerSocket serverSocket = null;
    VisibleScoreBoardController visibleScoreBoardController;
    private Controller controller;
    private SimpleIntegerProperty redProperty;
    private SimpleIntegerProperty blueProperty;

    public Judge(int port, Controller controller, VisibleScoreBoardController visibleScoreBoardController, SimpleIntegerProperty redProperty, SimpleIntegerProperty blueProperty) {
        this.controller = controller;
        this.port = port;
        this.visibleScoreBoardController = visibleScoreBoardController;
        this.redProperty = redProperty;
        this.blueProperty = blueProperty;
    }

    @Override
    protected Object call() throws Exception {
        Point point = null;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Listening: " + port);
            while (true) {
                clientSocket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                point = (Point) objectInputStream.readObject();
                int assignRedPoint = redProperty.get();
                int assignBluePoint = blueProperty.get();
                if(Objects.equals(point.getColor(), "red")){
                    assignRedPoint +=  point.getPoint();
                    final int finalAssignPoint = assignRedPoint;
                    Platform.runLater(()-> redProperty.setValue(finalAssignPoint));
                }else{
                    assignBluePoint +=  point.getPoint();
                    final int finalAssignPoint = assignBluePoint;
                    Platform.runLater(()-> blueProperty.setValue(finalAssignPoint));
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return point;
    }
}
