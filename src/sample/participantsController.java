package sample;

import database.Database;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class ParticipantsController implements Initializable{

    @FXML
    public TableView<Participant> participantsTable;
    @FXML
    public ComboBox<Club> clubBox;
    @FXML
    public ComboBox<Rank> rankBox;
    @FXML
    public ComboBox<Category> categoryBox;
    @FXML
    public ComboBox<Age> ageBox;
    @FXML
    public TextField nameBox;
    @FXML
    public Button addParticipant;
    @FXML
    public Button deleteParticipant;
    @FXML
    public Button takeParticipant;
    @FXML
    public Button updateParticipant;
    @FXML
    public TableColumn<Participant, Integer> idCol;
    @FXML
    public TableColumn<Participant, String> nameCol;
    @FXML
    public TableColumn<Participant, String> clubCol;
    @FXML
    public TableColumn<Participant, String> rankCol;
    @FXML
    public TableColumn<Participant, String> catCol;
    @FXML
    public TableColumn<Participant, String> ageCol;
    @FXML
    public TableColumn<Participant, String> tourCol;
    @FXML
    public ComboBox<Club> clubBox1;
    @FXML
    public ComboBox<Rank> rankBox1;
    @FXML
    public ComboBox<Age> ageBox1;
    @FXML
    public ComboBox<Category> categoryBox1;
    @FXML
    public TableColumn<Tournament, Integer> tourId;
    @FXML
    public TableColumn<Tournament, String> tourName;
    @FXML
    public TableColumn<Tournament, String> tourFrom;
    @FXML
    public TableColumn<Tournament, String> tourTo;
    @FXML
    public TableColumn<Tournament, String> tourType;
    @FXML
    public TableColumn<Tournament, String> tourCity;
    @FXML
    public Button listGenerator;
    @FXML
    public ListView<Participant> randomList;
    @FXML
    public TableView<Tournament> tourTable;
    @FXML
    public TableView<Participant> participantsTable1;
    @FXML
    public TableColumn<Participant, Integer> idCol1;
    @FXML
    public TableColumn<Participant, String> nameCol1;
    @FXML
    public TableColumn<Participant, String> clubCol1;
    @FXML
    public TableColumn<Participant, String> rankCol1;
    @FXML
    public TableColumn<Participant, String> catCol1;
    @FXML
    public TableColumn<Participant, String> ageCol1;
    @FXML
    public TableColumn<Participant, String> tourCol1;
    @FXML
    public ComboBox<Tournament> tourBox;
    @FXML
    public ComboBox<Age> ageRandom;
    @FXML
    public ComboBox<Category> categoryRandom;
    @FXML
    public Button newTour;

    ObservableList<Club> clubData = FXCollections.observableArrayList();
    ObservableList<Rank> rankData = FXCollections.observableArrayList();
    ObservableList<Category> categoryData = FXCollections.observableArrayList();
    ObservableList<Age> ageData = FXCollections.observableArrayList();
    ObservableList<Participant> participants = FXCollections.observableArrayList();
    ObservableList<Tournament> tournamentData = FXCollections.observableArrayList();

    Database database = new Database();

    public void initialize(URL location, ResourceBundle resources){
        participantsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        participantsTable1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tourTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        clubCol.setCellValueFactory(new PropertyValueFactory<>("Club"));
        rankCol.setCellValueFactory(new PropertyValueFactory<>("Rank"));
        catCol.setCellValueFactory(new PropertyValueFactory<>("Category"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("Age"));
        tourCol.setCellValueFactory(new PropertyValueFactory<>("Tournament"));

        idCol1.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameCol1.setCellValueFactory(new PropertyValueFactory<>("Name"));
        clubCol1.setCellValueFactory(new PropertyValueFactory<>("Club"));
        rankCol1.setCellValueFactory(new PropertyValueFactory<>("Rank"));
        catCol1.setCellValueFactory(new PropertyValueFactory<>("Category"));
        ageCol1.setCellValueFactory(new PropertyValueFactory<>("Age"));
        tourCol1.setCellValueFactory(new PropertyValueFactory<>("Tournament"));

        tourId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tourName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tourFrom.setCellValueFactory(new PropertyValueFactory<>("From"));
        tourTo.setCellValueFactory(new PropertyValueFactory<>("To"));
        tourType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        tourCity.setCellValueFactory(new PropertyValueFactory<>("City"));



        try{
            participants.addAll(database.showParticipants());
            clubData.addAll(database.fillClubs());
            rankData.addAll(database.fillRanks());
            categoryData.addAll(database.fillCategories());
            ageData.addAll(database.fillAges());
            tournamentData.addAll(database.fillTournament());

            tourTable.setItems(database.showTournaments());
            clubBox.getItems().addAll(clubData);
            clubBox.setCellFactory(e -> new ListCell<Club>() {
                @Override
                protected void updateItem(Club club, boolean empty) {
                    super.updateItem(club, empty);

                    if (club == null || empty) {
                        setText(null);
                    } else {
                        setText(club.getClubName());
                    }
                }
            });
            clubBox.setConverter(new StringConverter<Club>() {
                @Override
                public String toString(Club object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getClubName();
                    }
                }

                @Override
                public Club fromString(String string) {
                    return null;
                }
            });
            clubBox1.getItems().addAll(clubData);
            clubBox1.setCellFactory(e -> new ListCell<Club>() {
                @Override
                protected void updateItem(Club club, boolean empty) {
                    super.updateItem(club, empty);

                    if (club == null || empty) {
                        setText(null);
                    } else {
                        setText(club.getClubName());
                    }
                }
            });
            clubBox1.setConverter(new StringConverter<Club>() {
                @Override
                public String toString(Club object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getClubName();
                    }
                }

                @Override
                public Club fromString(String string) {
                    return null;
                }
            });

            rankBox.setItems(rankData);
            rankBox.setCellFactory(e -> new ListCell<Rank>() {
                @Override
                protected void updateItem(Rank rank, boolean empty) {
                    super.updateItem(rank, empty);

                    if (rank == null || empty) {
                        setText(null);
                    } else {
                        setText(rank.getRankName());
                    }
                }
            });
            rankBox.setConverter(new StringConverter<Rank>() {
                @Override
                public String toString(Rank object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getRankName();
                    }
                }

                @Override
                public Rank fromString(String string) {
                    return null;
                }
            });
            rankBox1.setItems(rankData);
            rankBox1.setCellFactory(e -> new ListCell<Rank>() {
                @Override
                protected void updateItem(Rank rank, boolean empty) {
                    super.updateItem(rank, empty);

                    if (rank == null || empty) {
                        setText(null);
                    } else {
                        setText(rank.getRankName());
                    }
                }
            });
            rankBox1.setConverter(new StringConverter<Rank>() {
                @Override
                public String toString(Rank object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getRankName();
                    }
                }

                @Override
                public Rank fromString(String string) {
                    return null;
                }
            });

            categoryBox.setItems(categoryData);
            categoryBox.setCellFactory(e -> new ListCell<Category>() {
                @Override
                protected void updateItem(Category category, boolean empty) {
                    super.updateItem(category, empty);

                    if (category == null || empty) {
                        setText(null);
                    } else {
                        setText(category.getCategoryName());
                    }
                }
            });
            categoryBox.setConverter(new StringConverter<Category>() {
                @Override
                public String toString(Category object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getCategoryName();
                    }
                }

                @Override
                public Category fromString(String string) {
                    return null;
                }
            });
            categoryBox1.setItems(categoryData);
            categoryBox1.setCellFactory(e -> new ListCell<Category>() {
                @Override
                protected void updateItem(Category category, boolean empty) {
                    super.updateItem(category, empty);

                    if (category == null || empty) {
                        setText(null);
                    } else {
                        setText(category.getCategoryName());
                    }
                }
            });
            categoryBox1.setConverter(new StringConverter<Category>() {
                @Override
                public String toString(Category object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getCategoryName();
                    }
                }

                @Override
                public Category fromString(String string) {
                    return null;
                }
            });
            categoryRandom.setItems(categoryData);
            categoryRandom.setCellFactory(e -> new ListCell<Category>() {
                @Override
                protected void updateItem(Category category, boolean empty) {
                    super.updateItem(category, empty);

                    if (category == null || empty) {
                        setText(null);
                    } else {
                        setText(category.getCategoryName());
                    }
                }
            });
            categoryRandom.setConverter(new StringConverter<Category>() {
                @Override
                public String toString(Category object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getCategoryName();
                    }
                }

                @Override
                public Category fromString(String string) {
                    return null;
                }
            });

            ageBox.setItems(ageData);
            ageBox.setCellFactory(e -> new ListCell<Age>() {
                @Override
                protected void updateItem(Age age, boolean empty) {
                    super.updateItem(age, empty);

                    if (age == null || empty) {
                        setText(null);
                    } else {
                        setText(age.getAge());
                    }
                }
            });
            ageBox.setConverter(new StringConverter<Age>() {
                @Override
                public String toString(Age object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getAge();
                    }
                }

                @Override
                public Age fromString(String string) {
                    return null;
                }
            });
            ageBox1.setItems(ageData);
            ageBox1.setCellFactory(e -> new ListCell<Age>() {
                @Override
                protected void updateItem(Age age, boolean empty) {
                    super.updateItem(age, empty);

                    if (age == null || empty) {
                        setText(null);
                    } else {
                        setText(age.getAge());
                    }
                }
            });
            ageBox1.setConverter(new StringConverter<Age>() {
                @Override
                public String toString(Age object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getAge();
                    }
                }

                @Override
                public Age fromString(String string) {
                    return null;
                }
            });
            ageRandom.setItems(ageData);
            ageRandom.setCellFactory(e -> new ListCell<Age>() {
                @Override
                protected void updateItem(Age age, boolean empty) {
                    super.updateItem(age, empty);

                    if (age == null || empty) {
                        setText(null);
                    } else {
                        setText(age.getAge());
                    }
                }
            });
            ageRandom.setConverter(new StringConverter<Age>() {
                @Override
                public String toString(Age object) {
                    if(object == null){
                        return "";
                    }else{
                        return object.getAge();
                    }
                }

                @Override
                public Age fromString(String string) {
                    return null;
                }
            });

            tourBox.setItems(tournamentData);
            tourBox.setCellFactory(e -> new ListCell<Tournament>(){
                @Override
                protected void updateItem(Tournament tournament, boolean empty) {
                    super.updateItem(tournament, empty);

                    if (tournament == null || empty) {
                        setText(null);
                    } else {
                        setText(tournament.getName());
                    }
                }
            });
            tourBox.setConverter(new StringConverter<Tournament>() {
                @Override
                public String toString(Tournament tournament) {
                    if(tournament == null){
                        return "";
                    }else{
                        return tournament.getName();
                    }
                }

                @Override
                public Tournament fromString(String string) {
                    return null;
                }
            });

            bindControls(participants);


        }catch (Exception e){
            e.printStackTrace();
        }

        addParticipant.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if(!Objects.equals(nameBox.getText(), "") || clubBox.getSelectionModel().getSelectedItem() != null || rankBox.getSelectionModel().getSelectedItem() != null || categoryBox.getSelectionModel().getSelectedItem() != null || ageBox.getSelectionModel().getSelectedItem() != null){
                try {
                    database.insertParticipant(nameBox.getText(), clubBox.getSelectionModel().getSelectedIndex()+1, rankBox.getSelectionModel().getSelectedIndex()+1, categoryBox.getSelectionModel().getSelectedIndex()+1, ageBox.getSelectionModel().getSelectedIndex()+1, tourBox.getSelectionModel().getSelectedIndex()+1);
                    participants.setAll(database.showParticipants());
                    participantsTable.setItems(participants);
                    bindControls(participants);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        deleteParticipant.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if(participantsTable.getSelectionModel().getSelectedItem() != null){
            Participant participant = participantsTable.getSelectionModel().getSelectedItem();
            try {
                database.deleteParticipant(participant.getId());
                participants.setAll(database.showParticipants());
                participantsTable.setItems(participants);
                bindControls(participants);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }});

        takeParticipant.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if(participantsTable.getSelectionModel().getSelectedItem() != null){
                Participant participant = participantsTable.getSelectionModel().getSelectedItem();
                nameBox.setText(participant.getName());
                clubBox.setEditable(true);
                clubBox.getEditor().setText(participant.getClub());
                rankBox.setEditable(true);
                rankBox.getEditor().setText(participant.getRank());
                categoryBox.setEditable(true);
                categoryBox.getEditor().setText(participant.getCategory());
                ageBox.setEditable(true);
                ageBox.getEditor().setText(participant.getAge());
                tourBox.setEditable(true);
                tourBox.getEditor().setText(participant.getTournament());
            }
        });

        updateParticipant.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
            if(participantsTable.getSelectionModel().getSelectedItem() != null || !Objects.equals(nameBox.getText(), "") ||clubBox.getSelectionModel().getSelectedItem() != null || rankBox.getSelectionModel().getSelectedItem() != null || categoryBox.getSelectionModel().getSelectedItem() != null || ageBox.getSelectionModel().getSelectedItem() != null){
                try {
                    database.updateParticipant(participantsTable.getSelectionModel().getSelectedItem().getId(),nameBox.getText(), clubBox.getSelectionModel().getSelectedIndex()+1, rankBox.getSelectionModel().getSelectedIndex()+1, categoryBox.getSelectionModel().getSelectedIndex()+1, ageBox.getSelectionModel().getSelectedIndex()+1, tourBox.getSelectionModel().getSelectedIndex()+1);
                    participants.setAll(database.showParticipants());
                    participantsTable.setItems(participants);
                    bindControls(participants);
                    nameBox.setText("");
                    clubBox.setEditable(false);
                    rankBox.setEditable(false);
                    categoryBox.setEditable(false);
                    ageBox.setEditable(false);
                    tourBox.setEditable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        listGenerator.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            ObservableList<Participant> randomParticipants = FXCollections.observableArrayList();
            ArrayList<Integer> values = new ArrayList<>();
            participantsTable1.getItems().stream().forEach(participant -> values.add(Integer.parseInt(idCol1.getCellData(participant).toString())));
            try {
                randomParticipants.setAll(database.randomList(values));
                randomList.setItems(randomParticipants);
                randomList.setCellFactory((comboBox) -> new ListCell<Participant>(){
                    @Override
                    protected void updateItem(Participant participant, boolean empty) {
                        super.updateItem(participant, empty);

                        if (participant == null || empty) {
                            setText(null);
                        } else {
                            setText(participant.getName());
                        }
                    }
                });
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        newTour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("../views/CreateTournament.fxml"));
                    Parent root = fxmLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Add Tournament");
                    stage.getIcons().add(new Image("file:resources/images/icon.png"));
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void bindControls(ObservableList<Participant> participants){
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Participant> filteredData = new FilteredList<>(participants, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
                        participant ->
                                participant.getClub().contains(clubBox1.getEditor().getText())
                                        && participant.getRank().contains(rankBox1.getEditor().getText())
                                        && participant.getCategory().contains(categoryBox1.getEditor().getText())
                                        && participant.getAge().contains(ageBox1.getEditor().getText()),
                clubBox1.getEditor().textProperty(),
                rankBox1.getEditor().textProperty(),
                categoryBox1.getEditor().textProperty(),
                ageBox1.getEditor().textProperty()
        ));
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Participant> sortedData = new SortedList<>(filteredData);
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(participantsTable.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
        participantsTable.setItems(sortedData);

        FilteredList<Participant> filteredParticipants = new FilteredList<>(participants, p -> true);
        tourTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            filteredParticipants.predicateProperty().bind(Bindings.createObjectBinding(()->
                            participant ->
                                    participant.getTournament().contains(tourTable.getSelectionModel().getSelectedItem().getName())
                                    && participant.getCategory().contains(categoryRandom.getEditor().getText())
                                    && participant.getAge().contains(ageRandom.getEditor().getText()),
                    tourTable.getSelectionModel().selectedItemProperty(),
                    categoryRandom.getEditor().textProperty(),
                    ageRandom.getEditor().textProperty()
            ));
        });
        SortedList<Participant> sortedParticipants = new SortedList<>(filteredParticipants);
        sortedParticipants.comparatorProperty().bind(participantsTable1.comparatorProperty());
        participantsTable1.setItems(sortedParticipants);

    }
}

