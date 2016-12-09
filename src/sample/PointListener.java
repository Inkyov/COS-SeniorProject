package sample;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Inkyov on 11/29/2016.
 */
public class PointListener implements ChangeListener {

    private SimpleIntegerProperty redProp;
    private SimpleIntegerProperty blueProp;
    private SimpleBooleanProperty booleanProperty;
    private SimpleBooleanProperty redProperty;
    private SimpleBooleanProperty blueProperty;
    private Rectangle winnerRect;
    private Controller controller;

    PointListener(SimpleIntegerProperty redProp, SimpleIntegerProperty blueProp, Controller controller, SimpleBooleanProperty bool, SimpleBooleanProperty red, SimpleBooleanProperty blue, Rectangle winnerRect){
        this.redProp = redProp;
        this.blueProp = blueProp;
        this.controller = controller;
        this.booleanProperty = bool;
        this.redProperty = red;
        this.blueProperty = blue;
        this.winnerRect = winnerRect;
    }


    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        if(booleanProperty.get()){
            if(redProp.get() == blueProp.get() && redProperty.get()){
                controller.redResultProperty().setValue(controller.redResultProperty().get()-1);
                winnerRect.setFill(Color.web("#d1d1d1"));
                redProperty.setValue(false);
                booleanProperty.setValue(false);
            }else if(redProp.get() == blueProp.get() && blueProperty.get()){
                controller.blueResultProperty().setValue(controller.blueResultProperty().get()-1);
                winnerRect.setFill(Color.web("#d1d1d1"));
                blueProperty.setValue(false);
                booleanProperty.setValue(false);
            }
        }else{
            if(redProp.get() > blueProp.get()){
                controller.redResultProperty().setValue(controller.redResultProperty().get()+1);
                winnerRect.setFill(Color.RED);
                redProperty.setValue(true);
                booleanProperty.setValue(true);
            }else if(redProp.get() < blueProp.get()){
                controller.blueResultProperty().setValue(controller.blueResultProperty().get()+1);
                winnerRect.setFill(Color.BLUE);
                blueProperty.setValue(true);
                booleanProperty.setValue(true);
            }
        }
    }
}
