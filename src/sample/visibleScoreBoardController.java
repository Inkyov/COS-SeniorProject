package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class visibleScoreBoardController implements Initializable{

    public ImageView redTimyoIm;
    public ImageView blueTimyoIm;
    //penalty circle containers
    public Rectangle J1Rect;
    public Rectangle J2Rect;
    public Rectangle J3Rect;
    public Rectangle J4Rect;
    //penalty circles
    public Circle rChuiCirc6;
    public Circle rChuiCirc5;
    public Circle rChuiCirc4;
    public Circle bChuiCirc4;
    public Circle bChuiCirc5;
    public Circle bChuiCirc6;
    public Circle rChuiCirc12;
    public Circle rChuiCirc11;
    public Circle rChuiCirc10;
    public Circle bChuiCirc12;
    public Circle bChuiCirc10;
    public Circle bChuiCirc11;
    public Circle rChuiCirc3;
    public Circle rChuiCirc2;
    public Circle rChuiCirc1;
    public Circle rChuiCirc9;
    public Circle rChuiCirc8;
    public Circle rChuiCirc7;
    public Circle bChuiCirc1;
    public Circle bChuiCirc2;
    public Circle bChuiCirc3;
    public Circle bChuiCirc7;
    public Circle bChuiCirc8;
    public Circle bChuiCirc9;
    //score labels of the four judges
    public Label rSJ4Label;
    public Label bSJ4Label;
    public Label rSJ3Label;
    public Label bSJ3Label;
    public Label rSJ1Label;
    public Label bSJ1Label;
    public Label rSJ2Label;
    public Label bSJ2Label;
    //penalties controls
    public Rectangle redChuiBackground;
    public Rectangle blueChuiBackground;
    public Label manyRChLabel;
    public Label manyBChLabel;
    //timer controls
    public Label minutesLabel;
    public Label secondLabel;
    public Label roundsLabel;

    public void initialize(URL location, ResourceBundle resources){
    File file = new File("E:/Downloads/kick.jpg");
    Image image = new Image(file.toURI().toString());
    redTimyoIm.setImage(image);
    blueTimyoIm.setImage(image);
    }

    public void setRedTimyoIm(double op){
        redTimyoIm.setOpacity(op);
    }
    public void setBlueTimyoIm(double op){
        blueTimyoIm.setOpacity(op);
    }
    public void setBlueLabelText(int point){
        bSJ1Label.setText(Integer.toString(point));
    }






}