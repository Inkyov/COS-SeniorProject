package core;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/ScoreBoard.fxml"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Match Grading System");
        primaryStage.getIcons().add(new Image("file:resources/images/icon.png"));
        primaryStage.setMaximized(true);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
