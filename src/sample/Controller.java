package sample;

import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.beans.property.SimpleBooleanProperty;
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
import javafx.scene.control.ListView;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private int round = 1;
    //private Timeline timer;
    CustomTimeline customTimeline;
    Parent root;
    VisibleScoreBoardController visibleScoreBoardController;

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

    private SimpleStringProperty resultLabel = new SimpleStringProperty("The match is equal");
    public SimpleStringProperty resultLabelProperty() {return resultLabel;}

    private SimpleIntegerProperty redResult = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty redResultProperty() { return redResult; }

    private SimpleIntegerProperty  blueResult = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty blueResultProperty() { return blueResult; }

    private SimpleBooleanProperty pointGiven1 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty pointGiven1Property() { return pointGiven1; }
    private SimpleBooleanProperty redGiven1 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty redGiven1Property() { return redGiven1; }
    private SimpleBooleanProperty blueGiven1 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty blueGiven1Property() { return blueGiven1; }
    private SimpleBooleanProperty pointGiven2 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty pointGiven2Property() { return pointGiven2; }
    private SimpleBooleanProperty redGiven2 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty redGiven2Property() { return redGiven2; }
    private SimpleBooleanProperty blueGiven2 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty blueGiven2Property() { return blueGiven2; }
    private SimpleBooleanProperty pointGiven3 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty pointGiven3Property() { return pointGiven3; }
    private SimpleBooleanProperty redGiven3 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty redGiven3Property() { return redGiven3; }
    private SimpleBooleanProperty blueGiven3 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty blueGiven3Property() { return blueGiven3; }
    private SimpleBooleanProperty pointGiven4 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty pointGiven4Property() { return pointGiven4; }
    private SimpleBooleanProperty redGiven4 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty redGiven4Property() { return redGiven4; }
    private SimpleBooleanProperty blueGiven4 = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty blueGiven4Property() { return blueGiven4; }
    private SimpleBooleanProperty redOpacity = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty blueOpacity = new SimpleBooleanProperty(false);
    private SimpleIntegerProperty blueChui = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty blueChuiProperty() { return blueChui; }
    private SimpleIntegerProperty redChui = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty redChuiProperty() { return redChui; }
    private SimpleIntegerProperty redKamChum = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty redKamChumProperty() { return redKamChum; }
    private SimpleIntegerProperty blueKamChum = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty blueKamChumProperty() { return blueKamChum; }

    private SimpleStringProperty roundLabel = new SimpleStringProperty("Round 1");
    public SimpleStringProperty roundLabelProperty() { return roundLabel; }

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
      rPLbl1.textProperty().bind(redResultProperty().asString());
      bPLbl1.textProperty().bind(blueResultProperty().asString());
      result.textProperty().bind(resultLabelProperty());
      roundsLabel.textProperty().bind(roundLabelProperty());
      visibleScoreBoardController.roundsLabel.textProperty().bind(roundLabelProperty());
      bChLbl.textProperty().bind(blueChuiProperty().asString());
      rChLbl.textProperty().bind(redChuiProperty().asString());
      bKChLabel.textProperty().bind(blueKamChumProperty().asString());
      rKChLabel.textProperty().bind(redKamChumProperty().asString());
      redResultProperty().addListener((observable, oldValue, newValue) -> winner() );
      blueResultProperty().addListener((observable, oldValue, newValue) ->  winner() );
      redPoint1Property().addListener(new PointListener(redPoint1Property(),bluePoint1Property(), this, pointGiven1Property(), redGiven1Property(), blueGiven1Property(), visibleScoreBoardController.J1Rect));
      redPoint2Property().addListener(new PointListener(redPoint2Property(),bluePoint2Property(), this, pointGiven2Property(), redGiven2Property(), blueGiven2Property(), visibleScoreBoardController.J2Rect));
      redPoint3Property().addListener(new PointListener(redPoint3Property(),bluePoint3Property(), this, pointGiven3Property(), redGiven3Property(), blueGiven3Property(), visibleScoreBoardController.J3Rect));
      redPoint4Property().addListener(new PointListener(redPoint4Property(),bluePoint4Property(), this, pointGiven4Property(), redGiven4Property(), blueGiven4Property(), visibleScoreBoardController.J4Rect));
      bluePoint1Property().addListener(new PointListener(redPoint1Property(),bluePoint1Property(), this, pointGiven1Property(), redGiven1Property(), blueGiven1Property(), visibleScoreBoardController.J1Rect));
      bluePoint2Property().addListener(new PointListener(redPoint2Property(),bluePoint2Property(), this, pointGiven2Property(), redGiven2Property(), blueGiven2Property(), visibleScoreBoardController.J2Rect));
      bluePoint3Property().addListener(new PointListener(redPoint3Property(),bluePoint3Property(), this, pointGiven3Property(), redGiven3Property(), blueGiven3Property(), visibleScoreBoardController.J3Rect));
      bluePoint4Property().addListener(new PointListener(redPoint4Property(),bluePoint4Property(), this, pointGiven4Property(), redGiven4Property(), blueGiven4Property(), visibleScoreBoardController.J4Rect));

      //Red Timyo indicator
      redTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> timyoIndicator(mouseEvent, redOpacity, redTimyo, visibleScoreBoardController.redTimyoIm, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property()));

      //Blue Timyo indicator
      blueTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> timyoIndicator(mouseEvent, blueOpacity, blueTimyo, visibleScoreBoardController.blueTimyoIm, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(), bluePoint4Property()));

      //Red Chuis
      rChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setChuis(mouseEvent, redChui, redOpacity, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property(), 3, 4));

      //Blue Chuis
      bChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setChuis(mouseEvent, blueChui, blueOpacity, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(),bluePoint4Property(), 1, 2));

      //Blue Kam Chum
      bKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setKamChum(mouseEvent, blueKamChum, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(),bluePoint4Property(), visibleScoreBoardController.bKamChum1, visibleScoreBoardController.bKamChum2));

      //Red Kam Chum
      rKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent-> setKamChum(mouseEvent, redKamChum, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property(), visibleScoreBoardController.rKamChum1, visibleScoreBoardController.rKamChum2));


      participantsMenuItem.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              try{
                  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/ShowParticipants.fxml"));
                  root = fxmlLoader.load();
                  Stage stage = new Stage();
                  stage.setTitle("Participants");
                  stage.setScene(new Scene(root));
                  stage.show();
              }catch (Exception e){
                  e.printStackTrace();
              }
          }
      });
      //ComboBox
      AutoCompleteComboBoxListener comboBox = new AutoCompleteComboBoxListener(categories);
      categories.setItems(FXCollections.observableArrayList("Юноши(14-15) -45кг", "Юноши(14-15) -51кг", "Юноши(14-15) -57кг", "Юноши(14-15) -63кг", "Юноши(14-15) -69кг", "Юноши(14-15) -75кг", "Юноши(14-15) +75кг", "Юноши(16-17) -45кг", "Юноши(16-17) -51кг", "Юноши(16-17) -57кг", "Юноши(16-17) -63кг", "Юноши(16-17) -69кг", "Юноши(16-17) -75кг", "Юноши(16-17) +75кг", "Мъже -51кг", "Мъже -57кг", "Мъже -64кг", "Мъже -71кг", "Мъже -78кг", "Мъже -85кг", "Мъже +85кг", "Жени -45кг", "Жени -51кг", "Жени -57кг", "Жени -63кг", "Жени -69кг", "Жени -75кг", "Жени +75кг"));
      categories.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
          refresh();
      });

      customTimeline = new CustomTimeline(this, 2, 59);
      Thread timerThread = new Thread(customTimeline);
      timerThread.start();

      rightArrow.setOnAction(e -> {
          switch(round){
              case 1:
                      customTimeline.pause();
                      roundLabelProperty().setValue("Rest 1");
                      secondsLabelProperty().setValue(String.format("%02d", 0));
                      minutesProperty().setValue(1);
                      customTimeline = new CustomTimeline(this, 1, 59);
                      round = 2;
                  break;
              case 2:
                      customTimeline.pause();
                      roundLabelProperty().setValue("Round 2");
                      secondsLabelProperty().setValue(String.format("%02d", 0));
                      minutesProperty().setValue(2);
                      customTimeline = new CustomTimeline(this, 2, 59);
                      round = 3;
                      if(blueTimyo.getOpacity() != 1){
                          ChangeLabels(-2, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(), bluePoint4Property());
                      }else{
                          blueTimyo.setOpacity(0.1);
                          ChangeLabels(-2, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(), bluePoint4Property());
                      }
                      if(redTimyo.getOpacity() != 1){
                          ChangeLabels(-2, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property());
                      }else{
                          redTimyo.setOpacity(0.1);
                          ChangeLabels(-2, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property());
                      }
                  break;
              case 3:
                      customTimeline.pause();
                      roundLabelProperty().setValue("Rest 2");
                      minutesProperty().setValue(0);
                      secondsLabelProperty().setValue(String.format("%02d", 30));
                      customTimeline = new CustomTimeline(this, 1, 30);
                      round = 4;
                  break;
              case 4:
                      customTimeline.pause();
                      roundLabelProperty().setValue("Round 3");
                      minutesProperty().setValue(1);
                      secondsLabelProperty().setValue(String.format("%02d", 0));
                      customTimeline = new CustomTimeline(this, 1, 59);
                      round = 5;
                  break;
              case 5:
                  refresh();
                  break;
          }
      });

    timerPane.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
    if(MouseButton.PRIMARY.equals(mouseEvent.getButton())){
        customTimeline.play();
    }else customTimeline.pause();
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

    public void winner(){
        if (redResult.get() > blueResult.get() && redResult.get() >= 2){
            resultLabel.setValue("Red is winning");
        }else if(redResult.get() < blueResult.get() && blueResult.get() >= 2) {
            resultLabel.setValue("Blue is winning");
        }else if(redResult.get() == blueResult.get() || redResult.get() == 1 || blueResult.get() == 1){
            resultLabel.setValue("The match is equal");
        }
    }

    public void refresh(){
      redKamChum.setValue(0);
      blueKamChum.setValue(0);
      redChui.setValue(0);
      blueChui.setValue(0);
      round = 1;
      secondsLabelProperty().setValue("00");
      minutesProperty().setValue(2);
      bluePoint1Property().setValue(-2);
      bluePoint2Property().setValue(-2);
      bluePoint3Property().setValue(-2);
      bluePoint4Property().setValue(-2);
      redPoint1Property().setValue(-2);
      redPoint2Property().setValue(-2);
      redPoint3Property().setValue(-2);
      redPoint4Property().setValue(-2);
      redKamChum.setValue(0);
      blueKamChum.setValue(0);
      redChui.setValue(0);
      blueChui.setValue(0);
      redResultProperty().setValue(0);
      blueResultProperty().setValue(0);
      roundLabelProperty().setValue("Round 1");
      blueTimyo.setOpacity(0.1);
      visibleScoreBoardController.setTimyoIm(0.1, visibleScoreBoardController.blueTimyoIm);
      redTimyo.setOpacity(0.1);
      visibleScoreBoardController.setTimyoIm(0.1, visibleScoreBoardController.redTimyoIm);
      redOpacity.setValue(false);
      blueOpacity.setValue(false);
      visibleScoreBoardController.setColor();
      visibleScoreBoardController.setOpacity();
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

        private ComboBox<String> comboBox;
        private StringBuilder sb;
        private int lastLength;

        public AutoCompleteComboBoxListener(ComboBox<String> comboBox) {
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

            ObservableList<String> items = comboBox.getItems();
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
            ObservableList<String> items = AutoCompleteComboBoxListener.this.comboBox.getItems();
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

    private synchronized void ChangeLabels(int point, SimpleIntegerProperty sIntProp1, SimpleIntegerProperty sIntProp2, SimpleIntegerProperty sIntProp3, SimpleIntegerProperty sIntProp4 ){
        List<SimpleIntegerProperty> simpleIntegerProperties = new ArrayList<>(Arrays.asList(sIntProp1,sIntProp2, sIntProp3, sIntProp4));
        simpleIntegerProperties.forEach(e-> e.setValue(e.get() + point));
    }

    public void setKamChum(MouseEvent mouseEvent, SimpleIntegerProperty kamChum, SimpleIntegerProperty sIntP1, SimpleIntegerProperty sIntP2, SimpleIntegerProperty sIntP3, SimpleIntegerProperty sIntP4, Rectangle rectangle1, Rectangle rectangle2){
        if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
            kamChum.setValue(kamChum.get()+1);
            visibleScoreBoardController.setKamChum(kamChum.get(), 1, rectangle1, rectangle2);
            ChangeLabels(-1, sIntP1, sIntP2, sIntP3, sIntP4);
        } else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
            kamChum.setValue(kamChum.get()-1);
            visibleScoreBoardController.setKamChum(kamChum.get(), 0, rectangle1, rectangle2);
            ChangeLabels(1, sIntP1, sIntP2, sIntP3, sIntP4);
        }
    }

    public void timyoIndicator(MouseEvent e, SimpleBooleanProperty op, ImageView controllerImgView, ImageView visibleControllerImgView, SimpleIntegerProperty sIntP1, SimpleIntegerProperty sIntP2, SimpleIntegerProperty sIntP3, SimpleIntegerProperty sIntP4){
        if (MouseButton.PRIMARY.equals(e.getButton()) && !op.get()) {
            controllerImgView.setOpacity(1);
            try {
                visibleScoreBoardController.setTimyoIm(1, visibleControllerImgView);
            }catch (NullPointerException ex){
                ex.printStackTrace();
            }
            ChangeLabels(2, sIntP1, sIntP2, sIntP3, sIntP4);
            op.setValue(true);
        }
        else if (MouseButton.SECONDARY.equals(e.getButton()) && op.get()) {
            controllerImgView.setOpacity(0.1);
            try {
                visibleScoreBoardController.setTimyoIm(0.1, visibleControllerImgView);
            }catch (NullPointerException ex){
                ex.printStackTrace();
            }
            ChangeLabels(-2, sIntP1, sIntP2, sIntP3, sIntP4);
            op.setValue(false);

        }
    }

    public void setChuis(MouseEvent mouseEvent, SimpleIntegerProperty chuis, SimpleBooleanProperty op, SimpleIntegerProperty sIntProp1, SimpleIntegerProperty sIntProp2, SimpleIntegerProperty sIntProp3, SimpleIntegerProperty sIntProp4, int set, int unset){
        if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
            chuis.setValue(chuis.get()+1);
            visibleScoreBoardController.setChuiCircles(chuis.get(), set);
            if(chuis.get() % 3 == 0){
                ChangeLabels(-1, sIntProp1, sIntProp2, sIntProp3, sIntProp4);
            }
        }
        else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
            chuis.setValue(chuis.get()-1);
            visibleScoreBoardController.setChuiCircles(chuis.get(), unset);
            if(chuis.get() % 3 == 0){
                ChangeLabels(1, sIntProp1, sIntProp2, sIntProp3, sIntProp4);
                if  (chuis.get() == 0 && !op.get()){
                    blueChui.setValue(0);
                    ChangeLabels(0, sIntProp1, sIntProp2, sIntProp3, sIntProp4);
                }
            }
        }
    }
}
