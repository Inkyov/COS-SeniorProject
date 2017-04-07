package core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class VisibleScoreBoardController implements Initializable{

    @FXML
    public ImageView redTimyoIm;
    @FXML
    public ImageView blueTimyoIm;
    //penalty circle containers
    @FXML
    public Rectangle J1Rect;
    @FXML
    public Rectangle J2Rect;
    @FXML
    public Rectangle J3Rect;
    @FXML
    public Rectangle J4Rect;
    //penalty circles
    public Circle rChuiCirc6;
    @FXML
    public Circle rChuiCirc5;
    @FXML
    public Circle rChuiCirc4;
    @FXML
    public Circle bChuiCirc4;
    @FXML
    public Circle bChuiCirc5;
    @FXML
    public Circle bChuiCirc6;
    @FXML
    public Circle rChuiCirc12;
    @FXML
    public Circle rChuiCirc11;
    @FXML
    public Circle rChuiCirc10;
    @FXML
    public Circle bChuiCirc12;
    @FXML
    public Circle bChuiCirc10;
    @FXML
    public Circle bChuiCirc11;
    @FXML
    public Circle rChuiCirc3;
    @FXML
    public Circle rChuiCirc2;
    @FXML
    public Circle rChuiCirc1;
    @FXML
    public Circle rChuiCirc9;
    @FXML
    public Circle rChuiCirc8;
    @FXML
    public Circle rChuiCirc7;
    @FXML
    public Circle bChuiCirc1;
    @FXML
    public Circle bChuiCirc2;
    @FXML
    public Circle bChuiCirc3;
    @FXML
    public Circle bChuiCirc7;
    @FXML
    public Circle bChuiCirc8;
    @FXML
    public Circle bChuiCirc9;
    @FXML
    //score labels of the four judges
    public Label rPJ4Label;
    @FXML
    public Label bPJ4Label;
    @FXML
    public Label rPJ3Label;
    @FXML
    public Label bPJ3Label;
    @FXML
    public Label rPJ1Label;
    @FXML
    public Label bPJ1Label;
    @FXML
    public Label rPJ2Label;
    @FXML
    public Label bPJ2Label;
    @FXML
    //penalties controls
    public Rectangle redChuiBackground;
    @FXML
    public Rectangle blueChuiBackground;
    @FXML
    public Label manyRChLabel;
    @FXML
    public Label manyBChLabel;
    @FXML
    //timer controls
    public Label minutesLabel;
    @FXML
    public Label secondLabel;
    @FXML
    public Label roundsLabel;
    @FXML
    //yellow card rectangles
    public Rectangle rKamChum1;
    @FXML
    public Rectangle rKamChum2;
    @FXML
    public Rectangle bKamChum1;
    @FXML
    public Rectangle bKamChum2;
    @FXML
    public Label category;

    public void initialize(URL location, ResourceBundle resources){
    File file = new File("resources/images/kick.png");
    Image image = new Image(file.toURI().toString());
    redTimyoIm.setImage(image);
    blueTimyoIm.setImage(image);

    }

    void setTimyoIm(double op, ImageView imageView){
        imageView.setOpacity(op);
    }

    void setKamChum(int kCh, int op, Rectangle rectangle1, Rectangle rectangle2){
        switch (kCh){
            case 0:
                rectangle1.setOpacity(op);
                break;
            case 1:
                if(op == 1){
                    rectangle1.setOpacity(op);
                }else if(op == 0){
                    rectangle2.setOpacity(op);
                }
                break;
            case 2:
                rectangle2.setOpacity(op);
        }
    }

    void setChuiCircles(int kCh, int function) {
        switch (function){
            case 1:
                setBlueChuiCircles(kCh);
                break;
            case 2:
                unsetCircles(kCh, blueChuiBackground, manyBChLabel, bChuiCirc1, bChuiCirc2, bChuiCirc3, bChuiCirc4, bChuiCirc5, bChuiCirc6, bChuiCirc7, bChuiCirc8, bChuiCirc9, bChuiCirc10, bChuiCirc11, bChuiCirc12);
                break;
            case 3:
                setRedChuiCircles(kCh);
                break;
            case 4:
                unsetCircles(kCh, redChuiBackground, manyRChLabel, rChuiCirc1, rChuiCirc2, rChuiCirc3, rChuiCirc4, rChuiCirc5, rChuiCirc6, rChuiCirc7, rChuiCirc8, rChuiCirc9, rChuiCirc10, rChuiCirc11, rChuiCirc12);
                break;
        }
    }

    private void setBlueChuiCircles(int kCh) {
        if (kCh > 12) {
            blueChuiBackground.setVisible(true);
            manyBChLabel.setText(Integer.toString(kCh));
            manyBChLabel.setVisible(true);
        } else {
            switch (kCh) {
                case 1:
                    bChuiCirc1.setFill(Color.BLUE);
                    bChuiCirc1.setOpacity(1);
                    break;
                case 2:
                    bChuiCirc2.setFill(Color.BLUE);
                    bChuiCirc2.setOpacity(1);
                    break;
                case 3:
                    bChuiCirc3.setFill(Color.BLUE);
                    bChuiCirc3.setOpacity(1);
                    break;
                case 4:
                    bChuiCirc4.setFill(Color.BLUE);
                    bChuiCirc4.setOpacity(1);
                    break;
                case 5:
                    bChuiCirc5.setFill(Color.BLUE);
                    bChuiCirc5.setOpacity(1);
                    break;
                case 6:
                    bChuiCirc6.setFill(Color.BLUE);
                    bChuiCirc6.setOpacity(1);
                    break;
                case 7:
                    bChuiCirc7.setFill(Color.BLUE);
                    bChuiCirc7.setOpacity(1);
                    break;
                case 8:
                    bChuiCirc8.setFill(Color.BLUE);
                    bChuiCirc8.setOpacity(1);
                    break;
                case 9:
                    bChuiCirc9.setFill(Color.BLUE);
                    bChuiCirc9.setOpacity(1);
                    break;
                case 10:
                    bChuiCirc10.setFill(Color.BLUE);
                    bChuiCirc10.setOpacity(1);
                    break;
                case 11:
                    bChuiCirc11.setFill(Color.BLUE);
                    bChuiCirc11.setOpacity(1);
                    break;
                case 12:
                    bChuiCirc12.setFill(Color.BLUE);
                    bChuiCirc12.setOpacity(1);
                    break;
            }
        }
    }

    private void unsetCircles(int kCh, Rectangle rectangle, Label manyLabel, Circle circle1, Circle circle2, Circle circle3, Circle circle4, Circle circle5, Circle circle6, Circle circle7, Circle circle8, Circle circle9, Circle circle10, Circle circle11, Circle circle12){
        if(kCh > 12){
            manyLabel.setText(Integer.toString(kCh));
        }else{
            switch (kCh){
                case 0:
                    circle1.setFill(Color.web("#d1d1d1"));
                    circle1.setOpacity(0.2);
                    break;
                case 1:
                    circle2.setFill(Color.web("#d1d1d1"));
                    circle2.setOpacity(0.2);
                    break;
                case 2:
                    circle3.setFill(Color.web("#d1d1d1"));
                    circle3.setOpacity(0.2);
                    break;
                case 3:
                    circle4.setFill(Color.web("#d1d1d1"));
                    circle4.setOpacity(0.2);
                    break;
                case 4:
                    circle5.setFill(Color.web("#d1d1d1"));
                    circle5.setOpacity(0.2);
                    break;
                case 5:
                    circle6.setFill(Color.web("#d1d1d1"));
                    circle6.setOpacity(0.2);
                    break;
                case 6:
                    circle7.setFill(Color.web("#d1d1d1"));
                    circle7.setOpacity(0.2);
                    break;
                case 7:
                    circle8.setFill(Color.web("#d1d1d1"));
                    circle8.setOpacity(0.2);
                    break;
                case 8:
                    circle9.setFill(Color.web("#d1d1d1"));
                    circle9.setOpacity(0.2);
                    break;
                case 9:
                    circle10.setFill(Color.web("#d1d1d1"));
                    circle10.setOpacity(0.2);
                    break;
                case 10:
                    circle11.setFill(Color.web("#d1d1d1"));
                    circle11.setOpacity(0.2);
                    break;
                case 11:
                    circle12.setFill(Color.web("#d1d1d1"));
                    circle12.setOpacity(0.2);
                    break;
                case 12:
                    rectangle.setVisible(false);
                    manyLabel.setVisible(false);
                    break;
            }
        }
    }

    private void setRedChuiCircles(int kCh){
        if (kCh > 12) {
            redChuiBackground.setVisible(true);
            manyRChLabel.setText(Integer.toString(kCh));
            manyRChLabel.setVisible(true);
        } else {
            switch (kCh) {
                case 1:
                    rChuiCirc1.setFill(Color.RED);
                    rChuiCirc1.setOpacity(1);
                    break;
                case 2:
                    rChuiCirc2.setFill(Color.RED);
                    rChuiCirc2.setOpacity(1);
                    break;
                case 3:
                    rChuiCirc3.setFill(Color.RED);
                    rChuiCirc3.setOpacity(1);
                    break;
                case 4:
                    rChuiCirc4.setFill(Color.RED);
                    rChuiCirc4.setOpacity(1);
                    break;
                case 5:
                    rChuiCirc5.setFill(Color.RED);
                    rChuiCirc5.setOpacity(1);
                    break;
                case 6:
                    rChuiCirc6.setFill(Color.RED);
                    rChuiCirc6.setOpacity(1);
                    break;
                case 7:
                    rChuiCirc7.setFill(Color.RED);
                    rChuiCirc7.setOpacity(1);
                    break;
                case 8:
                    rChuiCirc8.setFill(Color.RED);
                    rChuiCirc8.setOpacity(1);
                    break;
                case 9:
                    rChuiCirc9.setFill(Color.RED);
                    rChuiCirc9.setOpacity(1);
                    break;
                case 10:
                    rChuiCirc10.setFill(Color.RED);
                    rChuiCirc10.setOpacity(1);
                    break;
                case 11:
                    rChuiCirc11.setFill(Color.RED);
                    rChuiCirc11.setOpacity(1);
                    break;
                case 12:
                    rChuiCirc12.setFill(Color.RED);
                    rChuiCirc12.setOpacity(1);
                    break;
            }
        }
    }


    void setColor(){
        List<Circle> circles = new ArrayList<>(Arrays.asList(bChuiCirc1, bChuiCirc2, bChuiCirc3, bChuiCirc4, bChuiCirc5, bChuiCirc6, bChuiCirc7, bChuiCirc8, bChuiCirc9, bChuiCirc10, bChuiCirc11, bChuiCirc12, rChuiCirc1, rChuiCirc2, rChuiCirc3, rChuiCirc4, rChuiCirc5, rChuiCirc6, rChuiCirc7, rChuiCirc8, rChuiCirc9, rChuiCirc10, rChuiCirc11, rChuiCirc12));
        circles.forEach(e-> e.setFill(Color.web("#d1d1d1")));
    }

    void setOpacity(){
        List<Circle> circles = new ArrayList<>(Arrays.asList(bChuiCirc1, bChuiCirc2, bChuiCirc3, bChuiCirc4, bChuiCirc5, bChuiCirc6, bChuiCirc7, bChuiCirc8, bChuiCirc9, bChuiCirc10, bChuiCirc11, bChuiCirc12, rChuiCirc1, rChuiCirc2, rChuiCirc3, rChuiCirc4, rChuiCirc5, rChuiCirc6, rChuiCirc7, rChuiCirc8, rChuiCirc9, rChuiCirc10, rChuiCirc11, rChuiCirc12));
        circles.forEach(e-> e.setOpacity(0.2));
        List<Rectangle> rectangles = new ArrayList<>(Arrays.asList(rKamChum1, rKamChum2, bKamChum1, bKamChum2));
        rectangles.forEach(e->e.setOpacity(0));
        List<ImageView> images = new ArrayList<>(Arrays.asList(blueTimyoIm, redTimyoIm));
        images.forEach(e->e.setOpacity(0.1));
    }
}