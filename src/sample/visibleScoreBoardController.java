package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
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
    public Label rPJ4Label;
    public Label bPJ4Label;
    public Label rPJ3Label;
    public Label bPJ3Label;
    public Label rPJ1Label;
    public Label bPJ1Label;
    public Label rPJ2Label;
    public Label bPJ2Label;
    //penalties controls
    public Rectangle redChuiBackground;
    public Rectangle blueChuiBackground;
    public Label manyRChLabel;
    public Label manyBChLabel;
    //timer controls
    public Label minutesLabel;
    public Label secondLabel;
    public Label roundsLabel;
    //yellow card rectangles
    public Rectangle rKamChum1;
    public Rectangle rKamChum2;
    public Rectangle bKamChum1;
    public Rectangle bKamChum2;
    private int redScore1;
    private int redScore2;
    private int redScore3;
    private int redScore4;
    private int blueScore1;
    private int blueScore2;
    private int blueScore3;
    private int blueScore4;

    public void initialize(URL location, ResourceBundle resources){
    File file = new File("E:/Downloads/kick.png");
    Image image = new Image(file.toURI().toString());
    redTimyoIm.setImage(image);
    blueTimyoIm.setImage(image);

    //integer representation of the point labels
    redScore1 = Integer.parseInt(rPJ1Label.getText());
    redScore2 = Integer.parseInt(rPJ2Label.getText());
    redScore3 = Integer.parseInt(rPJ3Label.getText());
    redScore4 = Integer.parseInt(rPJ4Label.getText());
    blueScore1 = Integer.parseInt(bPJ1Label.getText());
    blueScore2 = Integer.parseInt(bPJ2Label.getText());
    blueScore3 = Integer.parseInt(bPJ3Label.getText());
    blueScore4 = Integer.parseInt(bPJ4Label.getText());
    }

    public void getWinner(){
        if(redScore1 > blueScore1){
            J1Rect.setFill(Color.RED);
        }else if(redScore1 < blueScore1){
            J1Rect.setFill(Color.BLUE);
        }else {
            J1Rect.setFill(Color.web("#d1d1d1"));
        }
        if(redScore2 > blueScore2){
            J2Rect.setFill(Color.RED);
        }else if(redScore2 < blueScore2){
            J2Rect.setFill(Color.BLUE);
        }else {
            J2Rect.setFill(Color.web("#d1d1d1"));
        }
        if(redScore3 > blueScore3){
            J3Rect.setFill(Color.RED);
        }else if(redScore3 < blueScore3){
            J3Rect.setFill(Color.BLUE);
        }else {
            J3Rect.setFill(Color.web("#d1d1d1"));
        }
        if(redScore4 > blueScore4){
            J4Rect.setFill(Color.RED);
        }else if(redScore4 < blueScore4){
            J4Rect.setFill(Color.BLUE);
        }else {
            J4Rect.setFill(Color.web("#d1d1d1"));
        }

    }

    public void setRedTimyoIm(double op){
        redTimyoIm.setOpacity(op);
    }

    public void setBlueTimyoIm(double op){
        blueTimyoIm.setOpacity(op);
    }

    public void setRedKamChumRectangle(int kCh, int op){
        switch (kCh){
            case 1:
                rKamChum1.setOpacity(op);
                break;
            case 2:
                rKamChum2.setOpacity(op);
                break;
        }
    }

    public void unsetRedKamChumRectangle(int kCh, int op){
        switch (kCh){
            case 0:
                rKamChum1.setOpacity(op);
                break;
            case 1:
                rKamChum2.setOpacity(op);
                break;
        }
    }

    public void setBlueKamChumRectangle(int kCh, int op){
        switch (kCh){
            case 1:
                bKamChum1.setOpacity(op);
                break;
            case 2:
                bKamChum2.setOpacity(op);
                break;
        }
    }

    public void unsetBlueKamChumRectangle(int kCh, int op){
        switch (kCh){
            case 0:
                bKamChum1.setOpacity(op);
                break;
            case 1:
                bKamChum2.setOpacity(op);
                break;
        }
    }

    public void setBlueChuiCircles(int kCh) {
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

    public void unsetBlueChuiCircles(int kCh){
        if(kCh > 12){
            manyBChLabel.setText(Integer.toString(kCh));
        }
        switch (kCh){
            case 0:
                bChuiCirc1.setFill(Color.web("#d1d1d1"));
                bChuiCirc1.setOpacity(0.2);
                break;
            case 1:
                bChuiCirc2.setFill(Color.web("#d1d1d1"));
                bChuiCirc2.setOpacity(0.2);
                break;
            case 2:
                bChuiCirc3.setFill(Color.web("#d1d1d1"));
                bChuiCirc3.setOpacity(0.2);
                break;
            case 3:
                bChuiCirc4.setFill(Color.web("#d1d1d1"));
                bChuiCirc4.setOpacity(0.2);
                break;
            case 4:
                bChuiCirc5.setFill(Color.web("#d1d1d1"));
                bChuiCirc5.setOpacity(0.2);
                break;
            case 5:
                bChuiCirc6.setFill(Color.web("#d1d1d1"));
                bChuiCirc6.setOpacity(0.2);
                break;
            case 6:
                bChuiCirc7.setFill(Color.web("#d1d1d1"));
                bChuiCirc7.setOpacity(0.2);
                break;
            case 7:
                bChuiCirc8.setFill(Color.web("#d1d1d1"));
                bChuiCirc8.setOpacity(0.2);
                break;
            case 8:
                bChuiCirc9.setFill(Color.web("#d1d1d1"));
                bChuiCirc9.setOpacity(0.2);
                break;
            case 9:
                bChuiCirc10.setFill(Color.web("#d1d1d1"));
                bChuiCirc10.setOpacity(0.2);
                break;
            case 10:
                bChuiCirc11.setFill(Color.web("#d1d1d1"));
                bChuiCirc11.setOpacity(0.2);
                break;
            case 11:
                bChuiCirc12.setFill(Color.web("#d1d1d1"));
                bChuiCirc12.setOpacity(0.2);
                break;
            case 12:
                blueChuiBackground.setVisible(false);
                manyBChLabel.setVisible(false);
                break;
        }
    }

    public void setRedChuiCircles(int kCh) {
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

    public void unsetRedChuiCircles(int kCh) {
        if(kCh > 12){
            manyRChLabel.setText(Integer.toString(kCh));
        }
            switch (kCh) {
                case 0:
                    rChuiCirc1.setFill(Color.web("#d1d1d1"));
                    rChuiCirc1.setOpacity(0.2);
                    break;
                case 1:
                    rChuiCirc2.setFill(Color.web("#d1d1d1"));
                    rChuiCirc2.setOpacity(0.2);
                    break;
                case 2:
                    rChuiCirc3.setFill(Color.web("#d1d1d1"));
                    rChuiCirc3.setOpacity(0.2);
                    break;
                case 3:
                    rChuiCirc4.setFill(Color.web("#d1d1d1"));
                    rChuiCirc4.setOpacity(0.2);
                    break;
                case 4:
                    rChuiCirc5.setFill(Color.web("#d1d1d1"));
                    rChuiCirc5.setOpacity(0.2);
                    break;
                case 5:
                    rChuiCirc6.setFill(Color.web("#d1d1d1"));
                    rChuiCirc6.setOpacity(0.2);
                    break;
                case 6:
                    rChuiCirc7.setFill(Color.web("#d1d1d1"));
                    rChuiCirc7.setOpacity(0.2);
                    break;
                case 7:
                    rChuiCirc8.setFill(Color.web("#d1d1d1"));
                    rChuiCirc8.setOpacity(0.2);
                    break;
                case 8:
                    rChuiCirc9.setFill(Color.web("#d1d1d1"));
                    rChuiCirc9.setOpacity(0.2);
                    break;
                case 9:
                    rChuiCirc10.setFill(Color.web("#d1d1d1"));
                    rChuiCirc10.setOpacity(0.2);
                    break;
                case 10:
                    rChuiCirc11.setFill(Color.web("#d1d1d1"));
                    rChuiCirc11.setOpacity(0.2);
                    break;
                case 11:
                    rChuiCirc12.setFill(Color.web("#d1d1d1"));
                    rChuiCirc12.setOpacity(0.2);
                    break;
                case 12:
                    redChuiBackground.setVisible(false);
                    manyRChLabel.setVisible(false);
                    break;
            }
        }

}