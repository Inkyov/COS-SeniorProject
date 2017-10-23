package core;

import database.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public Button createTournamentButton;
    @FXML
    public TextField tournamentCity;
    @FXML
    public TextField tournamentType;
    @FXML
    public Label prompt;

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTournamentButton.setOnAction(event -> {
            Database database = new Database();
            try {
                database.addTournament(tournamentName.getText(), tournamentFrom.getValue().toString(), tournamentTo.getValue().toString(), tournamentType.getText(), tournamentCity.getText());
                prompt.setText("Tournament added!");
            } catch (SQLException | ClassNotFoundException e) {
                LOGGER.log(Level.SEVERE, "Error", e);
                prompt.setText("Tournament couldn't be added!");
            }
        });

    }
}
