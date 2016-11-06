package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.util.Duration;

/**
 * Created by Inkyov on 10/28/2016.
 */

public class CustomTimeline extends Task {
    private Timeline timer;
    private int minutes, seconds;
    private Controller controller;
    private visibleScoreBoardController visibleScoreBoardController;

    CustomTimeline(Controller controller,visibleScoreBoardController visibleScoreBoardController, int minutes, int seconds){
        this.controller = controller;
        this.visibleScoreBoardController = visibleScoreBoardController;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    protected Object call() throws Exception {

    timer = new Timeline(new KeyFrame(Duration.millis(100), ae -> {
        String formatted = String.format("%02d", seconds);
        controller.secondLabel.setText(formatted);
        visibleScoreBoardController.secondLabel.setText(formatted);
        controller.minutesLabel.setText(Integer.toString(minutes-1));
        visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutes-1));
        if(seconds == 0){
            minutes--;
            controller.minutesLabel.setText(Integer.toString(minutes-1));
            visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutes-1));
            seconds = 59;
            if(minutes == 0){
                controller.minutesLabel.setText(Integer.toString(minutes));
                visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutes));
                timer.stop();
            }
        }
        seconds--;
    }));
    timer.setCycleCount(Animation.INDEFINITE);
        return null;
    }
}
