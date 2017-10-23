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

public class VisibleScoreBoardController implements Initializable {

    @FXML
    public ImageView redTimyoIm;
    @FXML
    public ImageView blueTimyoIm;
    //penalty circle containers
    @FXML
    public Rectangle j1Rect;
    @FXML
    public Rectangle j2Rect;
    @FXML
    public Rectangle j3Rect;
    @FXML
    public Rectangle j4Rect;
    //penalty circles
    @FXML
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
    private Circle rChuiCirc12;
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
        ArrayList<Circle> blueCircles = new ArrayList<>(Arrays.asList(bChuiCirc1, bChuiCirc2, bChuiCirc3, bChuiCirc4, bChuiCirc5, bChuiCirc6, bChuiCirc7, bChuiCirc8, bChuiCirc9, bChuiCirc10, bChuiCirc11, bChuiCirc12));
        ArrayList<Circle> redCircles = new ArrayList<>(Arrays.asList(rChuiCirc1, rChuiCirc2, rChuiCirc3, rChuiCirc4, rChuiCirc5, rChuiCirc6, rChuiCirc7, rChuiCirc8, rChuiCirc9, rChuiCirc10, rChuiCirc11, rChuiCirc12));
        switch (function){
            case 1:
                setCircles(kCh, blueChuiBackground, manyBChLabel, blueCircles, "#0000ff");
                break;
            case 2:
                unsetCircles(kCh, blueChuiBackground, manyBChLabel, blueCircles);
                break;
            case 3:
                setCircles(kCh, redChuiBackground, manyRChLabel, redCircles, "#ffff00");
                break;
            case 4:
                unsetCircles(kCh, redChuiBackground, manyRChLabel, redCircles);
                break;
        }
    }

    private void setCircles(int kCh, Rectangle rectangle, Label label, ArrayList<Circle> circles, String color) {
        if (kCh > 12) {
            rectangle.setVisible(true);
            label.setText(Integer.toString(kCh));
            label.setVisible(true);
        } else {
            Circle circle = circles.get(kCh);
            circle.setFill(Color.web(color));
            circle.setOpacity(1);
        }
    }

    private void unsetCircles(int kCh, Rectangle rectangle, Label manyLabel, ArrayList<Circle> circles){
        if(kCh > 12){
            manyLabel.setText(Integer.toString(kCh));
        }else{
            if(kCh != 12 && kCh >= 0){
                Circle circle = circles.get(kCh);
                circle.setFill(Color.web("#d1d1d1"));
                circle.setOpacity(0.2);
            }
            rectangle.setVisible(false);
            manyLabel.setVisible(false);
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