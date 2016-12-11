package sample;

import database.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Inkyov on 12/11/2016.
 */
public class CreateTournament implements Initializable{
    @FXML
    public TextField tournamentName;
    @FXML
    public DatePicker tournamentFrom;
    @FXML
    public DatePicker tournamentTo;
    @FXML
    public Button createTournament;
    @FXML
    public TextField tournamentCity;
    @FXML
    public TextField tournamentType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTournament.setOnAction(event -> {
            Database database = new Database();
            try {
                database.addTournament(tournamentName.getText(), tournamentFrom.getValue().toString(), tournamentTo.getValue().toString(), tournamentType.getText(), tournamentCity.getText());
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

    }
}
