package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import javafx.util.Duration;

/**
 * Created by Inkyov on 10/28/2016.
 */

public class CustomTimeline extends Task{
    private int minutes, seconds;
    private Controller controller;
    Timeline timer;
    public SimpleBooleanProperty interrupted = new SimpleBooleanProperty(false);

    CustomTimeline(Controller controller, int minutes, int seconds){
        this.controller = controller;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    protected Object call() throws Exception {
        performTask();
        return null;

    }

    private void performTask(){
        timer = new Timeline(new KeyFrame(Duration.millis(100), ae -> {
            String formatted = String.format("%02d", seconds);
            controller.secondsLabelProperty().setValue(formatted);
            controller.minutesProperty().setValue(minutes-1);
            if(seconds == 0){
                minutes--;
                controller.minutesProperty().setValue(minutes);
                seconds = 59;
                controller.secondsLabelProperty().setValue(Integer.toString(seconds));
                if(minutes == 0){
                    controller.minutesProperty().setValue(minutes);
                    minutes = controller.minutesProperty().get();
                    seconds = 0;
                    formatted = String.format("%02d", seconds);
                    controller.secondsLabelProperty().setValue(formatted);
                    timer.stop();
                    interrupted.setValue(true);
                }
            }else {
                seconds--;
            }
        }
        ));
        timer.setCycleCount(Timeline.INDEFINITE);
        }

    public synchronized void pause(){
        timer.pause();
    }

    public synchronized void play(){
        performTask();
        timer.play();
    }
}
