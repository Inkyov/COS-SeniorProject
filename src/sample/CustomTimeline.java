package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.util.Duration;

/**
 * Created by Inkyov on 10/28/2016.
 */

public class CustomTimeline{
    private int minutes, seconds;
    private Controller controller;
    private visibleScoreBoardController visibleScoreBoardController;

    CustomTimeline(Controller controller,visibleScoreBoardController visibleScoreBoardController, int minutes, int seconds){
        this.controller = controller;
        this.visibleScoreBoardController = visibleScoreBoardController;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /*public void runMe(){
        //controller.setMinutes(minutes);
        //controller.setSeconds(seconds);
        controller.setSeconds(seconds);
        controller.setMinutes(minutes-1);
          /*minutesLabel.setText(Integer.toString(minutesTemp-1));
          visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutesTemp-1));
        if(seconds == 0){
            minutes--;
            controller.setMinutes(minutes);
              /*minutesLabel.setText(Integer.toString(minutesTemp));
              visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutesTemp));
            seconds = 59;
            if(minutes == 0){
                controller.setMinutes(minutes);
                  /*minutesLabel.setText(Integer.toString(minutesTemp));
                  visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutesTemp));
            }
        }
        seconds--;
    }*/
}
