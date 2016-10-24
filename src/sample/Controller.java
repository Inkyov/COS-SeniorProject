package sample;

import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
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

    public ImageView redTimyo;
    public ImageView blueTimyo;
    public Label rChLbl;
    public Label bChLbl;
    public Label rPJ2Label;
    public Label bPJ2Label;
    public Label rPJ1Label;
    public Label bPJ1Label;
    public Label rPJ3Label;
    public Label bPJ3Label;
    public Label rPJ4Label;
    public Label bPJ4Label;
    public Label rKChLabel;
    public Label bKChLabel;
    public Label rPLbl1;
    public Label bPLbl1;
    public Label result;
    public ComboBox categories;
    public Button showScoreBoard;
    public Label roundsLabel;
    public Button leftArrow;
    public Button rightArrow;
    public Label secondLabel;
    public Label minutesLabel;
    public Pane timerPane;
    private int redChui;
    private int blueChui;
    private int redKCh;
    private int blueKCh;
    public int rPJ1 = -4;
    public int bPJ1 = -4;
    public int rPJ2 = -4;
    public int bPJ2 = -4;
    public int rPJ3 = -4;
    public int bPJ3 = -4;
    public int rPJ4 = -4;
    public int bPJ4 = -4;
    private boolean rOpacity = false;
    private boolean bOpacity = false;
    private int round = 1;
    private int minutes = 2;
    private int seconds = 59;
    private Timeline timer;
    Parent root;
    visibleScoreBoardController visibleScoreBoardController;

    public void initialize(URL location, ResourceBundle resources){

      File file = new File("E:/Downloads/kick.jpg");
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
      //Red Timyo indicator
      redTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton()) && !rOpacity) {
              redTimyo.setOpacity(1);
              try {
                  visibleScoreBoardController.setRedTimyoIm(1);
              }catch (NullPointerException e){
                  e.printStackTrace();
              }
              rPJ1+= 4;
              rPJ2+= 4;
              rPJ3+= 4;
              rPJ4+= 4;
              rPJ1Label.setText(Integer.toString(rPJ1));
              rPJ2Label.setText(Integer.toString(rPJ2));
              rPJ3Label.setText(Integer.toString(rPJ3));
              rPJ4Label.setText(Integer.toString(rPJ4));
              visibleScoreBoardController.rSJ1Label.setText(Integer.toString(rPJ1));
              visibleScoreBoardController.rSJ2Label.setText(Integer.toString(rPJ2));
              visibleScoreBoardController.rSJ3Label.setText(Integer.toString(rPJ3));
              visibleScoreBoardController.rSJ4Label.setText(Integer.toString(rPJ4));
              rOpacity = true;

          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton()) && rOpacity) {
              redTimyo.setOpacity(0.1);
              try {
                  visibleScoreBoardController.setRedTimyoIm(0.1);
              }catch (NullPointerException e){
                  e.printStackTrace();
              }
              rPJ1-= 4;
              rPJ2-= 4;
              rPJ3-= 4;
              rPJ4-= 4;
              rPJ1Label.setText(Integer.toString(rPJ1));
              rPJ2Label.setText(Integer.toString(rPJ2));
              rPJ3Label.setText(Integer.toString(rPJ3));
              rPJ4Label.setText(Integer.toString(rPJ4));
              visibleScoreBoardController.rSJ1Label.setText(Integer.toString(rPJ1));
              visibleScoreBoardController.rSJ2Label.setText(Integer.toString(rPJ2));
              visibleScoreBoardController.rSJ3Label.setText(Integer.toString(rPJ3));
              visibleScoreBoardController.rSJ4Label.setText(Integer.toString(rPJ4));
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
              bPJ1+= 4;
              bPJ2+= 4;
              bPJ3+= 4;
              bPJ4+= 4;
              bPJ1Label.setText(Integer.toString(bPJ1));
              bPJ2Label.setText(Integer.toString(bPJ2));
              bPJ3Label.setText(Integer.toString(bPJ3));
              bPJ4Label.setText(Integer.toString(bPJ4));
              visibleScoreBoardController.bSJ1Label.setText(Integer.toString(bPJ1));
              visibleScoreBoardController.bSJ2Label.setText(Integer.toString(bPJ2));
              visibleScoreBoardController.bSJ3Label.setText(Integer.toString(bPJ3));
              visibleScoreBoardController.bSJ4Label.setText(Integer.toString(bPJ4));
              bOpacity = true;
          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton()) && bOpacity) {
              blueTimyo.setOpacity(0.1);
              try {
                  visibleScoreBoardController.setBlueTimyoIm(0.1);
              }catch (NullPointerException e){
                  e.printStackTrace();
              }
              bPJ1-= 4;
              bPJ2-= 4;
              bPJ3-= 4;
              bPJ4-= 4;
              bPJ1Label.setText(Integer.toString(bPJ1));
              bPJ2Label.setText(Integer.toString(bPJ2));
              bPJ3Label.setText(Integer.toString(bPJ3));
              bPJ4Label.setText(Integer.toString(bPJ4));
              visibleScoreBoardController.bSJ1Label.setText(Integer.toString(bPJ1));
              visibleScoreBoardController.bSJ2Label.setText(Integer.toString(bPJ2));
              visibleScoreBoardController.bSJ3Label.setText(Integer.toString(bPJ3));
              visibleScoreBoardController.bSJ4Label.setText(Integer.toString(bPJ4));
              bOpacity = false;

          }
      });

      //Red Chuis
      rChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              redChui++;
              rChLbl.setText(Integer.toString(redChui));
              visibleScoreBoardController.rChuiCirc1.setFill(Color.RED);
              visibleScoreBoardController.rChuiCirc1.setOpacity(1);
              evaluate();
              if(redChui % 3 == 0){
                  redDecreaseScore();
              }
          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              redChui--;
              rChLbl.setText(Integer.toString(redChui));
              if(redChui % 3 == 0){
                  redIncreaseScore();
                  if (rChLbl.getText().equals("0") && !rOpacity) {
                      rPJ1Label.setText("-4");
                      rPJ2Label.setText("-4");
                      rPJ3Label.setText("-4");
                      rPJ4Label.setText("-4");
                      visibleScoreBoardController.rSJ1Label.setText("-4");
                      visibleScoreBoardController.rSJ2Label.setText("-4");
                      visibleScoreBoardController.rSJ3Label.setText("-4");
                      visibleScoreBoardController.rSJ4Label.setText("-4");
                      redChui = 0;
                      rPJ1=-4;
                      rPJ2=-4;
                      rPJ3=-4;
                      rPJ4=-4;
                  }
              }
          }
      });

      //Blue Chuis
      bChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              blueChui++;
              bChLbl.setText(Integer.toString(blueChui));
                  if(blueChui % 3 == 0){
                      blueDecreaseScore();
                  }
          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              blueChui--;
              bChLbl.setText(Integer.toString(blueChui));
              if(blueChui % 3 == 0){
                  blueIncreaseScore();
                  if(bChLbl.getText().equals("0") && !bOpacity){
                      bPJ1Label.setText("-4");
                      bPJ2Label.setText("-4");
                      bPJ3Label.setText("-4");
                      bPJ4Label.setText("-4");
                      visibleScoreBoardController.bSJ1Label.setText("-4");
                      visibleScoreBoardController.bSJ2Label.setText("-4");
                      visibleScoreBoardController.bSJ3Label.setText("-4");
                      visibleScoreBoardController.bSJ4Label.setText("-4");
                      blueChui = 0;
                      bPJ1=-4;
                      bPJ2=-4;
                      bPJ3=-4;
                      bPJ4=-4;
                  }
              }

          }
      });

      bChLbl.textProperty().addListener((observable, oldValue, newValue) -> {
          blueChui = Integer.parseInt(bChLbl.getText());
          if (bChLbl.getText().equals("0")) {
             blueDecreaseScore();
          }else if (blueChui > 0 && blueChui % 3 == 0) {
              blueDecreaseScore();
          }
      });


      //Blue Kam Chum
      bKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              blueKCh++;
              bKChLabel.setText(Integer.toString(blueKCh));
              blueDecreaseScore();

          } else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              blueKCh--;
              bKChLabel.setText(Integer.toString(blueKCh));
              blueIncreaseScore();
          }
      });

      //Red Kam Chum
      rKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              redKCh++;
              rKChLabel.setText(Integer.toString(redKCh));
              redDecreaseScore();

          } else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              redKCh--;
              rKChLabel.setText(Integer.toString(redKCh));
              redIncreaseScore();
          }
      });

      //ComboBox
      AutoCompleteComboBoxListener comboBox = new AutoCompleteComboBoxListener(categories);
      categories.setItems(FXCollections.observableArrayList("Юноши(14-15) -45кг", "Юноши(14-15) -51кг", "Юноши(14-15) -57кг", "Юноши(14-15) -63кг", "Юноши(14-15) -69кг", "Юноши(14-15) -75кг", "Юноши(14-15) +75кг", "Юноши(16-17) -45кг", "Юноши(16-17) -51кг", "Юноши(16-17) -57кг", "Юноши(16-17) -63кг", "Юноши(16-17) -69кг", "Юноши(16-17) -75кг", "Юноши(16-17) +75кг", "Мъже -51кг", "Мъже -57кг", "Мъже -64кг", "Мъже -71кг", "Мъже -78кг", "Мъже -85кг", "Мъже +85кг", "Жени -45кг", "Жени -51кг", "Жени -57кг", "Жени -63кг", "Жени -69кг", "Жени -75кг", "Жени +75кг"));
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
                  roundsLabel.setText("Почивка 1");
                  visibleScoreBoardController.roundsLabel.setText("Почивка 1");
                  round = 2;
                  break;
              case 2:
                  roundsLabel.setText("Рунд 2");
                  visibleScoreBoardController.roundsLabel.setText("Рунд 2");
                  round = 3;
                  break;
              case 3:
                  roundsLabel.setText("Почивка 2");
                  visibleScoreBoardController.roundsLabel.setText("Почивка 2");
                  round = 4;
                  break;
              case 4:
                  roundsLabel.setText("Рунд 3");
                  visibleScoreBoardController.roundsLabel.setText("Рунд 3");
                  round=5;
                  break;
              case 5:
                  refresh();
                  break;
          }
      });

      timer = new Timeline(new KeyFrame(Duration.millis(1000), ae -> {
          String formatted = String.format("%02d", seconds);
          secondLabel.setText(formatted);
          visibleScoreBoardController.secondLabel.setText(formatted);
          minutesLabel.setText(Integer.toString(minutes-1));
          visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutes-1));
          if(seconds == 0){
              minutes--;
              minutesLabel.setText(Integer.toString(minutes-1));
              visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutes-1));
              seconds = 59;
              if(minutes == 0){
                  minutesLabel.setText(Integer.toString(minutes));
                  visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutes));
                  timer.stop();
              }
          }
          seconds--;
      }));
      timer.setCycleCount(Animation.INDEFINITE);

timerPane.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
    if(MouseButton.SECONDARY.equals(mouseEvent.getButton())){
        timer.pause();
    }else timer.play();
});

      PointsSocket socket1 = new PointsSocket(8888);
      Thread socketThread1 = new Thread(socket1);
      PointsSocket socket2 = new PointsSocket(8889);
      Thread socketThread2 = new Thread(socket2);
      PointsSocket socket3 = new PointsSocket(8887);
      Thread socketThread3 = new Thread(socket3);
      PointsSocket socket4 = new PointsSocket(8886);
      Thread socketThread4 = new Thread(socket4);
      socketThread1.start();
      socketThread2.start();
      socketThread3.start();
      socketThread4.start();

  }


    public void redDecreaseScore(){

        rPJ1--;
        rPJ2--;
        rPJ3--;
        rPJ4--;
        rPJ1Label.setText(Integer.toString(rPJ1));
        rPJ2Label.setText(Integer.toString(rPJ2));
        rPJ3Label.setText(Integer.toString(rPJ3));
        rPJ4Label.setText(Integer.toString(rPJ4));
        visibleScoreBoardController.rSJ1Label.setText(Integer.toString(rPJ1));
        visibleScoreBoardController.rSJ2Label.setText(Integer.toString(rPJ2));
        visibleScoreBoardController.rSJ3Label.setText(Integer.toString(rPJ3));
        visibleScoreBoardController.rSJ4Label.setText(Integer.toString(rPJ4));

    }

    public void redIncreaseScore(){

        rPJ1++;
        rPJ2++;
        rPJ3++;
        rPJ4++;
        rPJ1Label.setText(Integer.toString(rPJ1));
        rPJ2Label.setText(Integer.toString(rPJ2));
        rPJ3Label.setText(Integer.toString(rPJ3));
        rPJ4Label.setText(Integer.toString(rPJ4));
        visibleScoreBoardController.rSJ1Label.setText(Integer.toString(rPJ1));
        visibleScoreBoardController.rSJ2Label.setText(Integer.toString(rPJ2));
        visibleScoreBoardController.rSJ3Label.setText(Integer.toString(rPJ3));
        visibleScoreBoardController.rSJ4Label.setText(Integer.toString(rPJ4));

    }

    public void blueDecreaseScore(){

        bPJ1--;
        bPJ2--;
        bPJ3--;
        bPJ4--;
        bPJ1Label.setText(Integer.toString(bPJ1));
        bPJ2Label.setText(Integer.toString(bPJ2));
        bPJ3Label.setText(Integer.toString(bPJ3));
        bPJ4Label.setText(Integer.toString(bPJ4));
        visibleScoreBoardController.bSJ1Label.setText(Integer.toString(bPJ1));
        visibleScoreBoardController.bSJ2Label.setText(Integer.toString(bPJ2));
        visibleScoreBoardController.bSJ3Label.setText(Integer.toString(bPJ3));
        visibleScoreBoardController.bSJ4Label.setText(Integer.toString(bPJ4));

    }

    public void blueIncreaseScore(){

        bPJ1++;
        bPJ2++;
        bPJ3++;
        bPJ4++;
        bPJ1Label.setText(Integer.toString(bPJ1));
        bPJ2Label.setText(Integer.toString(bPJ2));
        bPJ3Label.setText(Integer.toString(bPJ3));
        bPJ4Label.setText(Integer.toString(bPJ4));
        visibleScoreBoardController.bSJ1Label.setText(Integer.toString(bPJ1));
        visibleScoreBoardController.bSJ2Label.setText(Integer.toString(bPJ2));
        visibleScoreBoardController.bSJ3Label.setText(Integer.toString(bPJ3));
        visibleScoreBoardController.bSJ4Label.setText(Integer.toString(bPJ4));

    }

    public void refresh(){
        bPJ1=-4;
        bPJ2=-4;
        bPJ3=-4;
        bPJ4=-4;
        rPJ1=-4;
        rPJ2=-4;
        rPJ3=-4;
        rPJ4=-4;
        redKCh=0;
        blueKCh=0;
        redChui=0;
        blueChui=0;
        seconds = 59;
        minutes = 2;
        round = 1;
        rPJ1Label.setText("-4");
        rPJ2Label.setText("-4");
        rPJ3Label.setText("-4");
        rPJ4Label.setText("-4");
        visibleScoreBoardController.rSJ1Label.setText("-4");
        visibleScoreBoardController.rSJ2Label.setText("-4");
        visibleScoreBoardController.rSJ3Label.setText("-4");
        visibleScoreBoardController.rSJ4Label.setText("-4");
        bPJ1Label.setText("-4");
        bPJ2Label.setText("-4");
        bPJ3Label.setText("-4");
        bPJ4Label.setText("-4");
        visibleScoreBoardController.bSJ1Label.setText("-4");
        visibleScoreBoardController.bSJ2Label.setText("-4");
        visibleScoreBoardController.bSJ3Label.setText("-4");
        visibleScoreBoardController.bSJ4Label.setText("-4");
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
        minutesLabel.setText(Integer.toString(minutes));
        visibleScoreBoardController.minutesLabel.setText(Integer.toString(minutes));
        secondLabel.setText(Integer.toString(seconds));
        visibleScoreBoardController.secondLabel.setText(Integer.toString(seconds));
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
        if(bPJ1 > rPJ1){
            blue=+2;
            bPLbl1.setText(Integer.toString(blue));
        }else if(bPJ1 < rPJ1){
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
