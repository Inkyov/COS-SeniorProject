package sample;

import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{

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
    public ComboBox categories;
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
    private int redChui;
    private int blueChui;
    private int redKCh;
    private int blueKCh;
    public static int redPoints1 = -2;
    public static int bluePoints1 = -2;
    private boolean rOpacity = false;
    private boolean bOpacity = false;
    private int round = 1;
    private int minutesTemp = 2;
    private int secondsTemp = 59;
    private Timeline timer;
    Parent root;
    visibleScoreBoardController visibleScoreBoardController;

    private SimpleIntegerProperty redPoint1 = new SimpleIntegerProperty(-2);
    public SimpleIntegerProperty redPoint1Property() { return redPoint1; }
    private SimpleIntegerProperty redPoint2 = new SimpleIntegerProperty(-2);
    public SimpleIntegerProperty redPoint2Property() { return redPoint2; }
    private SimpleIntegerProperty redPoint3 = new SimpleIntegerProperty(-2);
    public SimpleIntegerProperty redPoint3Property() { return redPoint3; }
    private SimpleIntegerProperty redPoint4 = new SimpleIntegerProperty(-2);
    public SimpleIntegerProperty redPoint4Property() { return redPoint4; }

    private SimpleIntegerProperty bluePoint1 = new SimpleIntegerProperty(-2);
    public SimpleIntegerProperty bluePoint1Property() { return bluePoint1; }
    private SimpleIntegerProperty bluePoint2 = new SimpleIntegerProperty(-2);
    public SimpleIntegerProperty bluePoint2Property() { return bluePoint2; }
    private SimpleIntegerProperty bluePoint3 = new SimpleIntegerProperty(-2);
    public SimpleIntegerProperty bluePoint3Property() { return bluePoint3; }
    private SimpleIntegerProperty bluePoint4 = new SimpleIntegerProperty(-2);
    public SimpleIntegerProperty bluePoint4Property() { return bluePoint4; }


    private SimpleIntegerProperty minutes = new SimpleIntegerProperty(2);
    public SimpleIntegerProperty minutesProperty() { return minutes; }

    private SimpleStringProperty secondsLabel = new SimpleStringProperty("00");
    public SimpleStringProperty secondsLabelProperty() {return secondsLabel;}

    public void initialize(URL location, ResourceBundle resources){

      File file = new File("E:/Downloads/kick.png");
      Image image = new Image(file.toURI().toString());
      redTimyo.setImage(image);
      blueTimyo.setImage(image);

      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/visibleScoreBoard.fxml"));
      try {
          root = fxmlLoader.load();
          Stage stage = new Stage();
          stage.setScene(new Scene(root, 1680, 850));
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



      //Red Timyo indicator
      redTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton()) && !rOpacity) {
              redTimyo.setOpacity(1);
              try {
                  visibleScoreBoardController.setRedTimyoIm(1);
              }catch (NullPointerException e){
                  e.printStackTrace();
              }
              redPoints1 += 2;
              ChangeRedLabels(redPoints1);
              rOpacity = true;

          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton()) && rOpacity) {
              redTimyo.setOpacity(0.1);
              try {
                  visibleScoreBoardController.setRedTimyoIm(0.1);
              }catch (NullPointerException e){
                  e.printStackTrace();
              }
              redPoints1 -= 2;
              ChangeRedLabels(redPoints1);
              rOpacity = false;

          }
      });

      //Blue Timyo indicator
      blueTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton()) && !bOpacity) {
              blueTimyo.setOpacity(1);
              try {
                  visibleScoreBoardController.setBlueTimyoIm(1);
              }catch (NullPointerException e){
                  e.printStackTrace();
              }
              bluePoints1 += 2;
              ChangeBlueLabels(bluePoints1);
              bOpacity = true;
          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton()) && bOpacity) {
              blueTimyo.setOpacity(0.1);
              try {
                  visibleScoreBoardController.setBlueTimyoIm(0.1);
              }catch (NullPointerException e){
                  e.printStackTrace();
              }
              bluePoints1 -= 2;
              ChangeBlueLabels(bluePoints1);
              bOpacity = false;

          }
      });

      //Red Chuis
      rChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              redChui++;
              rChLbl.setText(Integer.toString(redChui));
              visibleScoreBoardController.setRedChuiCircles(redChui);
              if(redChui % 3 == 0){
                  redPoints1--;
                  ChangeRedLabels(redPoints1);
              }
          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              redChui--;
              rChLbl.setText(Integer.toString(redChui));
              visibleScoreBoardController.unsetRedChuiCircles(redChui);
              if(redChui % 3 == 0){
                  redPoints1++;
                  ChangeRedLabels(redPoints1);

                  if  (rChLbl.getText().equals("0") && !rOpacity) {
                      redChui = 0;
                      redPoints1 =-2;
                      ChangeRedLabels(redPoints1);
                  }
              }
          }
      });

      //Blue Chuis
      bChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              blueChui++;
              bChLbl.setText(Integer.toString(blueChui));
              visibleScoreBoardController.setBlueChuiCircles(blueChui);
                  if(blueChui % 3 == 0){
                      bluePoints1--;
                      ChangeBlueLabels(bluePoints1);
                  }
          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              blueChui--;
              bChLbl.setText(Integer.toString(blueChui));
              visibleScoreBoardController.unsetBlueChuiCircles(blueChui);
              if(blueChui % 3 == 0){
                  bluePoints1++;
                  ChangeBlueLabels(bluePoints1);
                  if  (bChLbl.getText().equals("0") && !bOpacity){
                      blueChui = 0;
                      bluePoints1 =-2;
                      ChangeBlueLabels(bluePoints1);
                  }
              }
          }
      });

      //Blue Kam Chum
      bKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              blueKCh++;
              bKChLabel.setText(Integer.toString(blueKCh));
              visibleScoreBoardController.setBlueKamChumRectangle(blueKCh, 1);
              bluePoints1--;
              ChangeBlueLabels(bluePoints1);
          } else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              blueKCh--;
              bKChLabel.setText(Integer.toString(blueKCh));
              visibleScoreBoardController.unsetBlueKamChumRectangle(blueKCh, 0);
              bluePoints1++;
              ChangeBlueLabels(bluePoints1);
          }
      });

      //Red Kam Chum
      rKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              redKCh++;
              rKChLabel.setText(Integer.toString(redKCh));
              visibleScoreBoardController.setRedKamChumRectangle(redKCh, 1);
              redPoints1--;
              ChangeRedLabels(redPoints1);
          } else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              redKCh--;
              rKChLabel.setText(Integer.toString(redKCh));
              visibleScoreBoardController.unsetRedKamChumRectangle(redKCh, 0);
              redPoints1++;
              ChangeRedLabels(redPoints1);
          }
      });

      //ComboBox
      AutoCompleteComboBoxListener comboBox = new AutoCompleteComboBoxListener(categories);
      categories.setItems(FXCollections.observableArrayList("Юноши(14-15) -45кг", "Юноши(14-15) -51кг", "Юноши(14-15) -57кг", "Юноши(14-15) -63кг", "Юноши(14-15) -69кг", "Юноши(14-15) -75кг", "Юноши(14-15) +75кг", "Юноши(16-17) -45кг", "Юноши(16-17) -51кг", "Юноши(16-17) -57кг", "Юноши(16-17) -63кг", "Юноши(16-17) -69кг", "Юноши(16-17) -75кг", "Юноши(16-17) +75кг", "Мъже -51кг", "Мъже -57кг", "Мъже -64кг", "Мъже -71кг", "Мъже -78кг", "Мъже -85кг", "Мъже +85кг", "Жени -45кг", "Жени -51кг", "Жени -57кг", "Жени -63кг", "Жени -69кг", "Жени -75кг", "Жени +75кг", "Юнощи 14-15 (отборно)", "Юнощи 16-17 (отборно)", "Мъже (отборно)", "Жени (отборно)"));
      categories.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {

      });


      /*showScoreBoard.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              try{
                  root = FXMLLoader.load(getClass().getResource("../views/visibleScoreBoard.fxml"));
                  Stage stage = new Stage();
                  stage.setScene(new Scene(root, 1680, 850));
                  stage.setMaximized(true);
                  stage.show();
              }catch (IOException e){
                  e.printStackTrace();
              }
          }
      });*/

      rightArrow.setOnAction(e -> {
          switch(round){
              case 1:
                  timer.stop();
                  roundsLabel.setText("Почивка 1");
                  visibleScoreBoardController.roundsLabel.setText("Почивка 1");
                  minutesProperty().setValue(1);
                  minutesTemp= 1;
                  secondsLabelProperty().setValue(String.format("%02d", 0));
                  secondsTemp = 59;
                  round = 2;
                  break;
              case 2:
                  timer.stop();
                  roundsLabel.setText("Рунд 2");
                  visibleScoreBoardController.roundsLabel.setText("Рунд 2");
                  minutesProperty().setValue(2);
                  minutesTemp=2;
                  secondsLabelProperty().setValue(String.format("%02d", 0));
                  secondsTemp = 59;
                  round = 3;
                  if(blueTimyo.getOpacity() != 1){
                      ChangeBlueLabels(bluePoint1Property().get()-2);
                  }else{
                      blueTimyo.setOpacity(0.1);
                      ChangeBlueLabels(bluePoint1Property().get()-2);
                  }
                  if(redTimyo.getOpacity() != 1){
                      ChangeRedLabels(redPoint1Property().get()-2);
                  }else{
                      redTimyo.setOpacity(0.1);
                      ChangeRedLabels(redPoint1Property().get()-2);
                  }
                  break;
              case 3:
                  timer.stop();
                  roundsLabel.setText("Почивка 2");
                  visibleScoreBoardController.roundsLabel.setText("Почивка 2");
                  minutesProperty().setValue(0);
                  minutesTemp=1;
                  secondsLabelProperty().setValue(String.format("%02d", 30));
                  secondsTemp = 30;
                  round = 4;
                  break;
              case 4:
                  timer.stop();
                  roundsLabel.setText("Рунд 3");
                  visibleScoreBoardController.roundsLabel.setText("Рунд 3");

                  minutesProperty().setValue(1);
                  minutesTemp = 1;
                  secondsLabelProperty().setValue(String.format("%02d", 0));
                  secondsTemp = 59;
                  round=5;
                  break;
              case 5:
                  refresh();
                  break;
          }
      });

      timer = new Timeline(new KeyFrame(Duration.millis(100), ae -> {
          String formatted = String.format("%02d", secondsTemp);
          secondsLabelProperty().setValue(formatted);
          minutesProperty().setValue(minutesTemp-1);
          if(secondsTemp == 0){
              minutesTemp--;
              minutesProperty().setValue(minutesTemp);
              secondsTemp = 59;
              secondsLabelProperty().setValue(Integer.toString(secondsTemp));
              if(minutesTemp == 0){
                      minutesProperty().setValue(minutesTemp);
                      minutesTemp = minutesProperty().get();
                      secondsTemp = 0;
                      formatted = String.format("%02d", secondsTemp);
                      secondsLabelProperty().setValue(formatted);
                      timer.stop();
              }
          }else {
              secondsTemp--;
          }}));
      timer.setCycleCount(Animation.INDEFINITE);

    timerPane.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
    if(MouseButton.PRIMARY.equals(mouseEvent.getButton())){
        timer.play();
    }else timer.stop();
});

      Judge socket1 = new Judge(8886, this, visibleScoreBoardController,redPoint1Property(), bluePoint1Property());
      Thread socketThread1 = new Thread(socket1);
      Judge socket2 = new Judge(8887, this, visibleScoreBoardController,redPoint2Property(), bluePoint2Property());
      Thread socketThread2 = new Thread(socket2);
      Judge socket3 = new Judge(8888, this, visibleScoreBoardController,redPoint3Property(), bluePoint3Property());
      Thread socketThread3 = new Thread(socket3);
      Judge socket4 = new Judge(8889, this, visibleScoreBoardController,redPoint4Property(), bluePoint4Property());
      Thread socketThread4 = new Thread(socket4);
      socketThread1.start();
      socketThread2.start();
      socketThread3.start();
      socketThread4.start();

  }

    private void ChangeBlueLabels(int point){
        bluePoint1Property().setValue(point);
        bluePoint2Property().setValue(point);
        bluePoint3Property().setValue(point);
        bluePoint4Property().setValue(point);
    }

    private void ChangeRedLabels(int point){
        redPoint1Property().setValue(point);
        redPoint2Property().setValue(point);
        redPoint3Property().setValue(point);
        redPoint4Property().setValue(point);
    }

    public void refresh(){
        bluePoints1 =-2;
        redPoints1 =-2;
        redKCh=0;
        blueKCh=0;
        redChui=0;
        blueChui=0;
        secondsLabelProperty().setValue("00");
        //String formatted = String.format("%02d", secondsProperty().get());
        minutesProperty().setValue(2);
        round = 1;
        ChangeBlueLabels(bluePoints1);
        ChangeRedLabels(redPoints1);
        rKChLabel.setText("0");
        bKChLabel.setText("0");
        rChLbl.setText("0");
        bChLbl.setText("0");
        rPLbl1.setText("0");
        bPLbl1.setText("0");
        roundsLabel.setText("Рунд 1");
        visibleScoreBoardController.roundsLabel.setText("Рунд 1");
        blueTimyo.setOpacity(0.1);
        visibleScoreBoardController.setBlueTimyoIm(0.1);
        redTimyo.setOpacity(0.1);
        visibleScoreBoardController.setRedTimyoIm(0.1);
        bOpacity = false;
        rOpacity = false;
        timer.stop();
        visibleScoreBoardController.bChuiCirc1.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc2.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc3.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc4.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc5.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc6.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc7.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc8.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc9.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc10.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc11.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc12.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc1.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc2.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc3.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc4.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc5.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc6.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc7.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc8.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc9.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc10.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc11.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.rChuiCirc12.setFill(Color.web("#d1d1d1"));
        visibleScoreBoardController.bChuiCirc1.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc2.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc3.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc4.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc5.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc6.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc7.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc8.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc9.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc10.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc11.setOpacity(0.2);
        visibleScoreBoardController.bChuiCirc12.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc1.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc2.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc3.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc4.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc5.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc6.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc7.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc8.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc9.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc10.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc11.setOpacity(0.2);
        visibleScoreBoardController.rChuiCirc12.setOpacity(0.2);
        visibleScoreBoardController.rKamChum1.setOpacity(0);
        visibleScoreBoardController.bKamChum1.setOpacity(0);
        visibleScoreBoardController.rKamChum2.setOpacity(0);
        visibleScoreBoardController.bKamChum2.setOpacity(0);
        visibleScoreBoardController.redChuiBackground.setVisible(false);
        visibleScoreBoardController.blueChuiBackground.setVisible(false);
        visibleScoreBoardController.manyBChLabel.setVisible(false);
        visibleScoreBoardController.manyRChLabel.setVisible(false);

    }

    public class AutoCompleteComboBoxListener implements EventHandler<KeyEvent> {

        private ComboBox comboBox;
        private StringBuilder sb;
        private int lastLength;

        public AutoCompleteComboBoxListener(ComboBox comboBox) {
            this.comboBox = comboBox;
            sb = new StringBuilder();

            this.comboBox.setEditable(true);
            this.comboBox.setOnKeyReleased(AutoCompleteComboBoxListener.this);

            // add a focus listener such that if not in focus, reset the filtered typed keys
            this.comboBox.getEditor().focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        // in focus
                    }
                    else {
                        lastLength = 0;
                        sb.delete(0, sb.length());
                        selectClosestResultBasedOnTextFieldValue(false, false);
                    }
                }
            });

            this.comboBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectClosestResultBasedOnTextFieldValue(true, true);
                }
            });
        }

        @Override
        public void handle(KeyEvent event) {
            // this variable is used to bypass the auto complete process if the length is the same.
            // this occurs if user types fast, the length of textfield will record after the user
            // has typed after a certain delay.
            if (lastLength != (comboBox.getEditor().getLength() - comboBox.getEditor().getSelectedText().length()))
                lastLength = comboBox.getEditor().getLength() - comboBox.getEditor().getSelectedText().length();

            if (event.isControlDown() || event.getCode() == KeyCode.BACK_SPACE ||
                    event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT ||
                    event.getCode() == KeyCode.DELETE || event.getCode() == KeyCode.HOME ||
                    event.getCode() == KeyCode.END || event.getCode() == KeyCode.TAB
                    )
                return;

            IndexRange ir = comboBox.getEditor().getSelection();
            sb.delete(0, sb.length());
            sb.append(comboBox.getEditor().getText());
            // remove selected string index until end so only unselected text will be recorded
            try {
                sb.delete(ir.getStart(), sb.length());
            } catch (Exception e) { }

            ObservableList items = comboBox.getItems();
            for (int i=0; i<items.size(); i++) {
                if (items.get(i).toString().toLowerCase().startsWith(comboBox.getEditor().getText().toLowerCase())
                        )
                {
                    try {
                        comboBox.getEditor().setText(sb.toString() + items.get(i).toString().substring(sb.toString().length()));
                    } catch (Exception e) {
                        comboBox.getEditor().setText(sb.toString());
                    }
                    comboBox.getEditor().positionCaret(sb.toString().length());
                    comboBox.getEditor().selectEnd();
                    break;
                }
            }
        }

        /*
         * selectClosestResultBasedOnTextFieldValue() - selects the item and scrolls to it when
         * the popup is shown.
         *
         * parameters:
         *  affect - true if combobox is clicked to show popup so text and caret position will be readjusted.
         *  inFocus - true if combobox has focus. If not, programmatically press enter key to add new entry to list.
         *
         */
        private void selectClosestResultBasedOnTextFieldValue(boolean affect, boolean inFocus) {
            ObservableList items = AutoCompleteComboBoxListener.this.comboBox.getItems();
            boolean found = false;
            for (int i=0; i<items.size(); i++) {
                if (AutoCompleteComboBoxListener.this.comboBox.getEditor().getText().toLowerCase().equals(items.get(i).toString().toLowerCase())) {
                    try {
                        ListView lv = ((ComboBoxListViewSkin) AutoCompleteComboBoxListener.this.comboBox.getSkin()).getListView();
                        lv.getSelectionModel().clearAndSelect(i);
                        lv.scrollTo(lv.getSelectionModel().getSelectedIndex());
                        found = true;
                        break;
                    } catch (Exception e) { }
                }
            }

            String s = comboBox.getEditor().getText();
            if (!found && affect) {
                comboBox.getSelectionModel().clearSelection();
                comboBox.getEditor().setText(s);
                comboBox.getEditor().end();
            }
        }

    }

    public void evaluate(){
        int blue = Integer.parseInt(bPLbl1.getText());
        int red = Integer.parseInt(rPLbl1.getText());
        if(bluePoints1 > redPoints1){
            blue=+2;
            bPLbl1.setText(Integer.toString(blue));
        }else if(bluePoints1 < redPoints1){
            red++;
            rPLbl1.setText(Integer.toString(red));
        }

        if(blue == red){
            result.setText("Резултатът е равен");
        }else if(blue > red && blue >= 2){
            result.setText("Синият е победител");
        }else if(blue < red && red >= 2){
            result.setText("Червеният е победител");
        }
    }
}
