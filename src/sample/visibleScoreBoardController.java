package sample;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class visibleScoreBoardController implements Initializable{
    public ImageView redTimyoIm;
    public ImageView blueTimyoIm;
    public Label rSJ1Label;
    public Rectangle J1Rect;
    public Rectangle J2Rect;
    public Rectangle J3Rect;
    public Rectangle J4Rect;
    public Label roundsLabel;

    private Controller cont;

    public void initialize(URL location, ResourceBundle resources){
    File file = new File("E:/Downloads/kick.jpg");
    Image image = new Image(file.toURI().toString());
    redTimyoIm.setImage(image);
    blueTimyoIm.setImage(image);


        roundsLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                    roundsLabel.setText("Почивка 1");
            }
        });

    }



}