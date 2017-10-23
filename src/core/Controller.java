package core;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

  @FXML
  public ImageView redTimyo;
  @FXML
  public ImageView blueTimyo;
  @FXML
  public Label rChLbl;
  @FXML
  public Label bChLbl;
  @FXML
  public Label rPJ2Label;
  @FXML
  public Label bPJ2Label;
  @FXML
  public Label rPJ1Label;
  @FXML
  public Label bPJ1Label;
  @FXML
  public Label rPJ3Label;
  @FXML
  public Label bPJ3Label;
  @FXML
  public Label rPJ4Label;
  @FXML
  public Label bPJ4Label;
  @FXML
  public Label rKChLabel;
  @FXML
  public Label bKChLabel;
  @FXML
  public Label rPLbl1;
  @FXML
  public Label bPLbl1;
  @FXML
  public Label result;
  @FXML
  public ComboBox<String> categories;
  @FXML
  public Label roundsLabel;
  @FXML
  public Button leftArrow;
  @FXML
  public Button rightArrow;
  @FXML
  public Label secondLabel;
  @FXML
  public Label minutesLabel;
  @FXML
  public Pane timerPane;
  @FXML
  public MenuItem participantsMenuItem;
  @FXML
  public MenuItem refreshButt;
  @FXML
  public GridPane grid;
  private int round = 1;
  private CustomTimeline customTimeline;
  private Parent root;
  private VisibleScoreBoardController visibleScoreBoardController;

  private SimpleIntegerProperty redPoint1 = new SimpleIntegerProperty(-2);

  private SimpleIntegerProperty redPoint1Property() {
    return redPoint1;
  }

  private SimpleIntegerProperty redPoint2 = new SimpleIntegerProperty(-2);

  private SimpleIntegerProperty redPoint2Property() {
    return redPoint2;
  }

  private SimpleIntegerProperty redPoint3 = new SimpleIntegerProperty(-2);

  private SimpleIntegerProperty redPoint3Property() {
    return redPoint3;
  }

  private SimpleIntegerProperty redPoint4 = new SimpleIntegerProperty(-2);

  private SimpleIntegerProperty redPoint4Property() {
    return redPoint4;
  }

  private SimpleIntegerProperty bluePoint1 = new SimpleIntegerProperty(-2);

  private SimpleIntegerProperty bluePoint1Property() {
    return bluePoint1;
  }

  private SimpleIntegerProperty bluePoint2 = new SimpleIntegerProperty(-2);

  private SimpleIntegerProperty bluePoint2Property() {
    return bluePoint2;
  }

  private SimpleIntegerProperty bluePoint3 = new SimpleIntegerProperty(-2);

  private SimpleIntegerProperty bluePoint3Property() {
    return bluePoint3;
  }

  private SimpleIntegerProperty bluePoint4 = new SimpleIntegerProperty(-2);

  private SimpleIntegerProperty bluePoint4Property() {
    return bluePoint4;
  }

  private SimpleIntegerProperty minutes = new SimpleIntegerProperty(2);

  SimpleIntegerProperty minutesProperty() {
    return minutes;
  }

  private SimpleStringProperty secondsLabel = new SimpleStringProperty("00");

  SimpleStringProperty secondsLabelProperty() {
    return secondsLabel;
  }

  private SimpleStringProperty resultLabel = new SimpleStringProperty("Срещата е равна");

  private SimpleStringProperty resultLabelProperty() {
    return resultLabel;
  }

  private SimpleIntegerProperty redResult = new SimpleIntegerProperty(0);

  private SimpleIntegerProperty redResultProperty() {
    return redResult;
  }

  private SimpleIntegerProperty blueResult = new SimpleIntegerProperty(0);

  private SimpleIntegerProperty blueResultProperty() {
    return blueResult;
  }

  private SimpleBooleanProperty redGiven1 = new SimpleBooleanProperty(false);
  private SimpleBooleanProperty blueGiven1 = new SimpleBooleanProperty(false);

  private SimpleBooleanProperty redGiven2 = new SimpleBooleanProperty(false);
  private SimpleBooleanProperty blueGiven2 = new SimpleBooleanProperty(false);

  private SimpleBooleanProperty redGiven3 = new SimpleBooleanProperty(false);
  private SimpleBooleanProperty blueGiven3 = new SimpleBooleanProperty(false);

  private SimpleBooleanProperty redGiven4 = new SimpleBooleanProperty(false);
  private SimpleBooleanProperty blueGiven4 = new SimpleBooleanProperty(false);

  private SimpleBooleanProperty redOpacity = new SimpleBooleanProperty(false);
  private SimpleBooleanProperty blueOpacity = new SimpleBooleanProperty(false);

  private SimpleIntegerProperty blueChui = new SimpleIntegerProperty(0);

  private SimpleIntegerProperty blueChuiProperty() {
    return blueChui;
  }

  private SimpleIntegerProperty redChui = new SimpleIntegerProperty(0);

  private SimpleIntegerProperty redChuiProperty() {
    return redChui;
  }

  private SimpleIntegerProperty redKamChum = new SimpleIntegerProperty(0);

  private SimpleIntegerProperty redKamChumProperty() {
    return redKamChum;
  }

  private SimpleIntegerProperty blueKamChum = new SimpleIntegerProperty(0);

  private SimpleIntegerProperty blueKamChumProperty() {
    return blueKamChum;
  }

  private SimpleStringProperty roundLabel = new SimpleStringProperty("Рунд 1");

  private SimpleStringProperty roundLabelProperty() {
    return roundLabel;
  }

  public void initialize(URL location, ResourceBundle resources) {

    File file = new File("resources/images/kick.png");
    Image image = new Image(file.toURI().toString());
    redTimyo.setImage(image);
    blueTimyo.setImage(image);

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/VisibleScoreBoard.fxml"));
    try {
      root = fxmlLoader.load();
      Stage stage = new Stage();
      stage.setScene(new Scene(root, 1680, 850));
      stage.getIcons().add(new Image("file:resources/images/icon.png"));
      stage.setTitle("Match Grading System");
      stage.setMaximized(true);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
    visibleScoreBoardController = fxmlLoader.getController();

    rPJ1Label.textProperty().bind(redPoint1Property().asString());
    rPJ2Label.textProperty().bind(redPoint2Property().asString());
    rPJ3Label.textProperty().bind(redPoint3Property().asString());
    rPJ4Label.textProperty().bind(redPoint4Property().asString());

    bPJ1Label.textProperty().bind(bluePoint1Property().asString());
    bPJ2Label.textProperty().bind(bluePoint2Property().asString());
    bPJ3Label.textProperty().bind(bluePoint3Property().asString());
    bPJ4Label.textProperty().bind(bluePoint4Property().asString());

    visibleScoreBoardController.rPJ1Label.textProperty().bind(redPoint1Property().asString());
    visibleScoreBoardController.rPJ2Label.textProperty().bind(redPoint2Property().asString());
    visibleScoreBoardController.rPJ3Label.textProperty().bind(redPoint3Property().asString());
    visibleScoreBoardController.rPJ4Label.textProperty().bind(redPoint4Property().asString());

    visibleScoreBoardController.bPJ1Label.textProperty().bind(bluePoint1Property().asString());
    visibleScoreBoardController.bPJ2Label.textProperty().bind(bluePoint2Property().asString());
    visibleScoreBoardController.bPJ3Label.textProperty().bind(bluePoint3Property().asString());
    visibleScoreBoardController.bPJ4Label.textProperty().bind(bluePoint4Property().asString());

    minutesLabel.textProperty().bind(minutesProperty().asString());
    visibleScoreBoardController.minutesLabel.textProperty().bind(minutesProperty().asString());

    secondLabel.textProperty().bind(secondsLabelProperty());
    visibleScoreBoardController.secondLabel.textProperty().bind(secondsLabelProperty());

    rPLbl1.textProperty().bind(redResultProperty().asString());
    bPLbl1.textProperty().bind(blueResultProperty().asString());

    result.textProperty().bind(resultLabelProperty());

    roundsLabel.textProperty().bind(roundLabelProperty());
    visibleScoreBoardController.roundsLabel.textProperty().bind(roundLabelProperty());

    bChLbl.textProperty().bind(blueChuiProperty().asString());
    rChLbl.textProperty().bind(redChuiProperty().asString());

    bKChLabel.textProperty().bind(blueKamChumProperty().asString());
    rKChLabel.textProperty().bind(redKamChumProperty().asString());

    redResultProperty().addListener((observable, oldValue, newValue) -> winner());
    blueResultProperty().addListener((observable, oldValue, newValue) -> winner());

    redPoint1Property().addListener((observable, oldValue, newValue) -> countJudges());
    redPoint2Property().addListener((observable, oldValue, newValue) -> countJudges());
    redPoint3Property().addListener((observable, oldValue, newValue) -> countJudges());
    redPoint4Property().addListener((observable, oldValue, newValue) -> countJudges());

    bluePoint1Property().addListener((observable, oldValue, newValue) -> countJudges());
    bluePoint2Property().addListener((observable, oldValue, newValue) -> countJudges());
    bluePoint3Property().addListener((observable, oldValue, newValue) -> countJudges());
    bluePoint4Property().addListener((observable, oldValue, newValue) -> countJudges());

    //Red Timyo indicator
    redTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> timyoIndicator(mouseEvent, redOpacity, redTimyo, visibleScoreBoardController.redTimyoIm, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property()));

    //Blue Timyo indicator
    blueTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> timyoIndicator(mouseEvent, blueOpacity, blueTimyo, visibleScoreBoardController.blueTimyoIm, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(), bluePoint4Property()));

    //Red Chuis
    rChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setChuis(mouseEvent, redChui, redOpacity, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property(), 3, 4));

    //Blue Chuis
    bChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setChuis(mouseEvent, blueChui, blueOpacity, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(), bluePoint4Property(), 1, 2));

    //Blue Kam Chum
    bKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setKamChum(mouseEvent, blueKamChum, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(), bluePoint4Property(), visibleScoreBoardController.bKamChum1, visibleScoreBoardController.bKamChum2));

    //Red Kam Chum
    rKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setKamChum(mouseEvent, redKamChum, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property(), visibleScoreBoardController.rKamChum1, visibleScoreBoardController.rKamChum2));


    participantsMenuItem.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/ShowParticipants.fxml"));
          root = fxmlLoader.load();
          Stage stage = new Stage();
          stage.setTitle("Participants");
          stage.getIcons().add(new Image("file:resources/images/icon.png"));
          stage.setScene(new Scene(root));
          stage.show();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    categories.setItems(FXCollections.observableArrayList("Момичета(8-9) -20кг", "Момичета(8-9) -25кг", "Момичета(8-9) -30кг", "Момичета(8-9) -35кг", "Момичета(8-9) -40кг", "Момичета(8-9) -45кг", "Момичета(8-9) +45кг", "Момичета(10-11) -30кг", "Момичета(10-11) -35кг", "Момичета(10-11) -40кг", "Момичета(10-11) -45кг", "Момичета(10-11) -50кг", "Момичета(10-11) -55кг", "Момичета(10-11) +55кг", "Момичета(12-13) -30кг", "Момичета(12-13) -35кг", "Момичета(12-13) -40кг", "Момичета(12-13) -45кг", "Момичета(12-13) -50кг", "Момичета(12-13) -55кг", "Момичета(12-13) +55кг", "Момчета(8-9) -25кг", "Момчета(8-9) -30кг", "Момчета(8-9) -35кг", "Момчета(8-9) -40кг", "Момчета(8-9) -45кг", "Момчета(8-9) -50кг", "Момчета(8-9) -55кг", "Момчета(8-9) +55кг", "Момчета(10-11) -35кг", "Момчета(10-11) -40кг", "Момчета(10-11) -45кг", "Момчета(10-11) -50кг", "Момчета(10-11) -55кг", "Момчета(10-11) -60кг", "Момчета(10-11) +60кг", "Момчета(12-13) -35кг", "Момчета(12-13) -40кг", "Момчета(12-13) -45кг", "Момчета(12-13) -50кг", "Момчета(12-13) -55кг", "Момчета(12-13) -60кг", "Момчета(12-13) +60кг", "Юноши(14-15) -45кг", "Юноши(14-15) -51кг", "Юноши(14-15) -57кг", "Юноши(14-15) -63кг", "Юноши(14-15) -69кг", "Юноши(14-15) -75кг", "Юноши(14-15) +75кг", "Юноши(16-17) -45кг", "Юноши(16-17) -51кг", "Юноши(16-17) -57кг", "Юноши(16-17) -63кг", "Юноши(16-17) -69кг", "Юноши(16-17) -75кг", "Юноши(16-17) +75кг", "Девойки(14-15) -40кг", "Девойки(14-15) -46кг", "Девойки(14-15) -52кг", "Девойки(14-15) -58кг", "Девойки(14-15) -64кг", "Девойки(14-15) -70кг", "Девойки(14-15) +70кг", "Девойки(16-17) -40кг", "Девойки(16-17) -46кг", "Девойки(16-17) -52кг", "Девойки(16-17) -58кг", "Девойки(16-17) -64кг", "Девойки(16-17) -70кг", "Девойки(16-17) +70кг", "Мъже -50кг", "Мъже -57кг", "Мъже -64кг", "Мъже -71кг", "Мъже -78кг", "Мъже -85кг", "Мъже +85кг", "Жени -45кг", "Жени -51кг", "Жени -57кг", "Жени -63кг", "Жени -69кг", "Жени -75кг", "Жени +75кг"));
    categories.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
      refresh();
      if (observable.getValue().intValue() >= 0 && observable.getValue().intValue() <= 42) {
        customTimeline.pause();
        minutesProperty().setValue(1);
        secondsLabelProperty().setValue(String.format("%02d", 10));
        customTimeline = new CustomTimeline(this, 2, 30);
      }
      visibleScoreBoardController.category.setText(categories.getSelectionModel().getSelectedItem());
    });
    CustomComboBox comboBox = new CustomComboBox(categories);

    refreshButt.setOnAction(e -> refresh());
    refreshButt.setAccelerator(new KeyCodeCombination(KeyCode.F5));
    grid.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> grid.requestFocus());

    customTimeline = new CustomTimeline(this, 2, 59);
    Thread timerThread = new Thread(customTimeline);
    timerThread.start();

    rightArrow.setOnAction(e -> {
      switch (round) {
        case 1:
          customTimeline.pause();
          roundLabelProperty().setValue("Почивка 1");
          secondsLabelProperty().setValue(String.format("%02d", 0));
          minutesProperty().setValue(1);
          customTimeline = new CustomTimeline(this, 1, 59);
          visibleScoreBoardController.blueTimyoIm.setOpacity(0);
          visibleScoreBoardController.redTimyoIm.setOpacity(0);
          round = 2;
          break;
        case 2:
          customTimeline.pause();
          roundLabelProperty().setValue("Рунд 2");
          secondsLabelProperty().setValue(String.format("%02d", 0));
          minutesProperty().setValue(2);
          customTimeline = new CustomTimeline(this, 2, 59);
          visibleScoreBoardController.blueTimyoIm.setOpacity(0.1);
          visibleScoreBoardController.redTimyoIm.setOpacity(0.1);
          round = 3;
          if (blueTimyo.getOpacity() != 1) {
            changeLabels(-2, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(), bluePoint4Property());
          } else {
            blueTimyo.setOpacity(0.1);
            changeLabels(-2, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(), bluePoint4Property());
          }
          if (redTimyo.getOpacity() != 1) {
            changeLabels(-2, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property());
          } else {
            redTimyo.setOpacity(0.1);
            changeLabels(-2, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property());
          }
          break;
        case 3:
          customTimeline.pause();
          roundLabelProperty().setValue("Почивка 2");
          minutesProperty().setValue(0);
          secondsLabelProperty().setValue(String.format("%02d", 30));
          customTimeline = new CustomTimeline(this, 1, 30);
          round = 4;
          break;
        case 4:
          customTimeline.pause();
          roundLabelProperty().setValue("Рунд 3");
          minutesProperty().setValue(1);
          secondsLabelProperty().setValue(String.format("%02d", 0));
          customTimeline = new CustomTimeline(this, 1, 59);
          round = 5;
          break;
        case 5:
          customTimeline.pause();
          refresh();
          break;
      }
    });

    timerPane.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
      if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
        customTimeline.play();
      } else customTimeline.pause();
    });

    Judge socket1 = new Judge(8886, redPoint1Property(), bluePoint1Property());
    Thread socketThread1 = new Thread(socket1);
    Judge socket2 = new Judge(8887, redPoint2Property(), bluePoint2Property());
    Thread socketThread2 = new Thread(socket2);
    Judge socket3 = new Judge(8888, redPoint3Property(), bluePoint3Property());
    Thread socketThread3 = new Thread(socket3);
    Judge socket4 = new Judge(8889, redPoint4Property(), bluePoint4Property());
    Thread socketThread4 = new Thread(socket4);
    socketThread1.start();
    socketThread2.start();
    socketThread3.start();
    socketThread4.start();

  }

  private void winner() {
    if (redResult.get() > blueResult.get() && redResult.get() >= 2) {
      resultLabel.setValue("Червеният води");
    } else if (redResult.get() < blueResult.get() && blueResult.get() >= 2) {
      resultLabel.setValue("Синият води");
    } else if (redResult.get() == blueResult.get() || redResult.get() == 1 || blueResult.get() == 1) {
      resultLabel.setValue("Срещата е равна");
    }
  }

  private void refresh() {
    customTimeline.pause();
    redKamChum.setValue(0);
    blueKamChum.setValue(0);
    redChui.setValue(0);
    blueChui.setValue(0);
    round = 1;
    secondsLabelProperty().setValue("00");
    minutesProperty().setValue(2);
    customTimeline = new CustomTimeline(this, 2, 59);
    bluePoint1Property().setValue(-2);
    bluePoint2Property().setValue(-2);
    bluePoint3Property().setValue(-2);
    bluePoint4Property().setValue(-2);
    redPoint1Property().setValue(-2);
    redPoint2Property().setValue(-2);
    redPoint3Property().setValue(-2);
    redPoint4Property().setValue(-2);
    redResultProperty().setValue(0);
    blueResultProperty().setValue(0);
    roundLabelProperty().setValue("Рунд 1");
    blueTimyo.setOpacity(0.1);
    redTimyo.setOpacity(0.1);
    redOpacity.setValue(false);
    blueOpacity.setValue(false);
    visibleScoreBoardController.setColor();
    visibleScoreBoardController.setOpacity();
    visibleScoreBoardController.redChuiBackground.setVisible(false);
    visibleScoreBoardController.blueChuiBackground.setVisible(false);
    visibleScoreBoardController.manyBChLabel.setVisible(false);
    visibleScoreBoardController.manyRChLabel.setVisible(false);

  }

  private synchronized void changeLabels(int point, SimpleIntegerProperty sIntProp1, SimpleIntegerProperty sIntProp2, SimpleIntegerProperty sIntProp3, SimpleIntegerProperty sIntProp4) {
    List<SimpleIntegerProperty> simpleIntegerProperties = new ArrayList<>(Arrays.asList(sIntProp1, sIntProp2, sIntProp3, sIntProp4));
    simpleIntegerProperties.forEach(e -> e.setValue(e.get() + point));
  }

  private synchronized void setKamChum(MouseEvent mouseEvent, SimpleIntegerProperty kamChum, SimpleIntegerProperty sIntP1, SimpleIntegerProperty sIntP2, SimpleIntegerProperty sIntP3, SimpleIntegerProperty sIntP4, Rectangle rectangle1, Rectangle rectangle2) {
    if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
      kamChum.setValue(kamChum.get() + 1);
      visibleScoreBoardController.setKamChum(kamChum.get(), 1, rectangle1, rectangle2);
      changeLabels(-1, sIntP1, sIntP2, sIntP3, sIntP4);
    } else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
      kamChum.setValue(kamChum.get() - 1);
      visibleScoreBoardController.setKamChum(kamChum.get(), 0, rectangle1, rectangle2);
      changeLabels(1, sIntP1, sIntP2, sIntP3, sIntP4);
    }
  }

  private synchronized void timyoIndicator(MouseEvent e, SimpleBooleanProperty op, ImageView controllerImgView, ImageView visibleControllerImgView, SimpleIntegerProperty sIntP1, SimpleIntegerProperty sIntP2, SimpleIntegerProperty sIntP3, SimpleIntegerProperty sIntP4) {
    if (MouseButton.PRIMARY.equals(e.getButton()) && !op.get()) {
      controllerImgView.setOpacity(1);
      try {
        visibleScoreBoardController.setTimyoIm(1, visibleControllerImgView);
      } catch (NullPointerException ex) {
        ex.printStackTrace();
      }
      changeLabels(2, sIntP1, sIntP2, sIntP3, sIntP4);
      op.setValue(true);
    } else if (MouseButton.SECONDARY.equals(e.getButton()) && op.get()) {
      controllerImgView.setOpacity(0.1);
      try {
        visibleScoreBoardController.setTimyoIm(0.1, visibleControllerImgView);
      } catch (NullPointerException ex) {
        ex.printStackTrace();
      }
      changeLabels(-2, sIntP1, sIntP2, sIntP3, sIntP4);
      op.setValue(false);

    }
  }

  private synchronized void setChuis(MouseEvent mouseEvent, SimpleIntegerProperty chuis, SimpleBooleanProperty op, SimpleIntegerProperty sIntProp1, SimpleIntegerProperty sIntProp2, SimpleIntegerProperty sIntProp3, SimpleIntegerProperty sIntProp4, int set, int unset) {
    if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
      chuis.setValue(chuis.get() + 1);
      visibleScoreBoardController.setChuiCircles(chuis.get(), set);
      if (chuis.get() % 3 == 0) {
        changeLabels(-1, sIntProp1, sIntProp2, sIntProp3, sIntProp4);
      }
    } else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
      chuis.setValue(chuis.get() - 1);
      visibleScoreBoardController.setChuiCircles(chuis.get(), unset);
      if (chuis.get() % 3 == 0) {
        changeLabels(1, sIntProp1, sIntProp2, sIntProp3, sIntProp4);
        if (chuis.get() == 0 && !op.get()) {
          blueChui.setValue(0);
          changeLabels(0, sIntProp1, sIntProp2, sIntProp3, sIntProp4);
        }
      }
    }
  }

  private synchronized void countJudges() {
    int redCount = 0;
    int blueCount = 0;
    String grayColor = "#d1d1d1";


    if (redPoint1Property().get() == bluePoint1Property().get() && redGiven1.get()) {
      visibleScoreBoardController.j1Rect.setFill(Color.web(grayColor));
      redCount--;
      if (redCount == -1) {
        redCount++;
      }
      redGiven1.setValue(false);
    } else if (redPoint1Property().get() == bluePoint1Property().get() && blueGiven1.get()) {
      visibleScoreBoardController.j1Rect.setFill(Color.web(grayColor));
      blueCount--;
      if (blueCount == -1) {
        blueCount++;
      }
      blueGiven1.setValue(false);
    } else if (redPoint1Property().get() > bluePoint1Property().get()) {
      visibleScoreBoardController.j1Rect.setFill(Color.RED);
      redCount++;
      redGiven1.setValue(true);
    } else if (redPoint1Property().get() < bluePoint1Property().get()) {
      visibleScoreBoardController.j1Rect.setFill(Color.BLUE);
      blueCount++;
      blueGiven1.setValue(true);
    }

    if (redPoint2Property().get() == bluePoint2Property().get() && redGiven2.get()) {
      visibleScoreBoardController.j2Rect.setFill(Color.web(grayColor));
      redCount--;
      if (redCount == -1) {
        redCount++;
      }
      redGiven2.setValue(false);
    } else if (redPoint2Property().get() == bluePoint2Property().get() && blueGiven2.get()) {
      visibleScoreBoardController.j2Rect.setFill(Color.web(grayColor));
      blueCount--;
      if (blueCount == -1) {
        blueCount++;
      }
      blueGiven2.setValue(false);
    } else if (redPoint2Property().get() > bluePoint2Property().get()) {
      visibleScoreBoardController.j2Rect.setFill(Color.RED);
      redCount++;
      redGiven2.setValue(true);
    } else if (redPoint2Property().get() < bluePoint2Property().get()) {
      visibleScoreBoardController.j2Rect.setFill(Color.BLUE);
      blueCount++;
      blueGiven2.setValue(true);
    }

    if (redPoint3Property().get() == bluePoint3Property().get() && redGiven3.get()) {
      visibleScoreBoardController.j3Rect.setFill(Color.web(grayColor));
      redCount--;
      if (redCount == -1) {
        redCount++;
      }
      redGiven3.setValue(false);
    } else if (redPoint3Property().get() == bluePoint3Property().get() && blueGiven3.get()) {
      visibleScoreBoardController.j3Rect.setFill(Color.web(grayColor));
      blueCount--;
      if (blueCount == -1) {
        blueCount++;
      }
      blueGiven3.setValue(false);
    } else if (redPoint3Property().get() > bluePoint3Property().get()) {
      visibleScoreBoardController.j3Rect.setFill(Color.RED);
      redCount++;
      redGiven3.setValue(true);
    } else if (redPoint3Property().get() < bluePoint3Property().get()) {
      visibleScoreBoardController.j3Rect.setFill(Color.BLUE);
      blueCount++;
      blueGiven3.setValue(true);
    }

    if (redPoint4Property().get() == bluePoint4Property().get() && redGiven4.get()) {
      visibleScoreBoardController.j4Rect.setFill(Color.web(grayColor));
      redCount--;
      if (redCount == -1) {
        redCount++;
      }
      redGiven4.setValue(false);
    } else if (redPoint4Property().get() == bluePoint4Property().get() && blueGiven4.get()) {
      visibleScoreBoardController.j4Rect.setFill(Color.web(grayColor));
      blueCount--;
      if (blueCount == -1) {
        blueCount++;
      }
      blueGiven4.setValue(false);
    } else if (redPoint4Property().get() > bluePoint4Property().get()) {
      visibleScoreBoardController.j4Rect.setFill(Color.RED);
      redCount++;
      redGiven4.setValue(true);
    } else if (redPoint4Property().get() < bluePoint4Property().get()) {
      visibleScoreBoardController.j4Rect.setFill(Color.BLUE);
      blueCount++;
      blueGiven4.setValue(true);
    }
    if (redCount == -1) {
      redCount++;
    } else if (blueCount == -1) {
      blueCount++;
    }
    blueResult.setValue(blueCount);
    redResult.setValue(redCount);

  }
}
