package sample;

import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.event.ChangeEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
    public Label rChLbl1;
    public Label bPJ3Label1;
    public ComboBox categories;
    public Button showScoreBoard;
    public Label roundsLabel;
    public Button rightArrow;
    public Label secondLabel;
    public Label minutesLabel;
    public Button leftArrow;
    private int redChui;
    private int blueChui;
    private int redKCh;
    private int blueKCh;
    private int rPJ1;
    private int bPJ1;
    private int rPJ2;
    private int bPJ2;
    private int rPJ3;
    private int bPJ3;
    private int rPJ4;
    private int bPJ4;
    private int i;
    Socket clientSocket = null;
    ServerSocket serverSocket = null;
    Scanner in1;

  public void initialize(URL location, ResourceBundle resources){

      File file = new File("E:/Downloads/kick.jpg");
      Image image = new Image(file.toURI().toString());
      redTimyo.setImage(image);
      blueTimyo.setImage(image);

      //Red Timyo indicator
      redTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              redTimyo.setOpacity(1);

          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              redTimyo.setOpacity(0.1);
          }
      });

      //Blue Timyo indicator
      blueTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              blueTimyo.setOpacity(1);
          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              blueTimyo.setOpacity(0.1);
          }
      });


      //Red Chuis
      rChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              redChui++;
              rChLbl.setText(Integer.toString(redChui));
             {
              if(redChui % 3 == 0){
                  redDecreaseScore();
              }
          }}
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              redChui--;
              rChLbl.setText(Integer.toString(redChui));
              if (rChLbl.getText().equals("0")) {
                  rPJ1Label.setText("0");
                  rPJ2Label.setText("0");
                  rPJ3Label.setText("0");
                  rPJ4Label.setText("0");
                  redChui = 0;
              }
          }
      });

      //Blue Chuis
      bChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

          if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
              i++;
              bChLbl.setText(Integer.toString(i));

          }
          else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
              i--;
              bChLbl.setText(Integer.toString(i));

          }
      });

      bChLbl.textProperty().addListener(new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              blueChui = Integer.parseInt(bChLbl.getText());
              System.out.println(blueChui);
              if (bChLbl.getText().equals("0")) {
                 blueDecreaseScore();
              }else if (blueChui > 0 && blueChui % 3 == 0) {
                  blueDecreaseScore();
              }

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


      showScoreBoard.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              Parent root;
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
      });


      }

    /*     try{
             serverSocket = new ServerSocket(4444);
             clientSocket = serverSocket.accept();
             in1 = new Scanner(clientSocket.getInputStream());
         }catch (IOException e){}

         String mes;

         while(true){
             if(in1.hasNext()){
                 mes = in1.nextLine();
                 System.out.println("Client message: " + mes);
             }
         }*/
    public void redDecreaseScore(){

        rPJ1--;
        rPJ2--;
        rPJ3--;
        rPJ4--;
        rPJ1Label.setText(Integer.toString(rPJ1));
        rPJ2Label.setText(Integer.toString(rPJ2));
        rPJ3Label.setText(Integer.toString(rPJ3));
        rPJ4Label.setText(Integer.toString(rPJ4));
        //rSJ1Label.setText(Integer.toString(rPJ1));


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

    }

    public void blueDecreaseScore(){

        if (bChLbl.getText().equals("0")) {
            bPJ1 = 0;
            bPJ2 = 0;
            bPJ3 = 0;
            bPJ4 = 0;
            bPJ1Label.setText(Integer.toString(bPJ1));
            bPJ2Label.setText(Integer.toString(bPJ2));
            bPJ3Label.setText(Integer.toString(bPJ3));
            bPJ4Label.setText(Integer.toString(bPJ4));
        }else {
            bPJ1--;
            bPJ2--;
            bPJ3--;
            bPJ4--;
            bPJ1Label.setText(Integer.toString(bPJ1));
            bPJ2Label.setText(Integer.toString(bPJ2));
            bPJ3Label.setText(Integer.toString(bPJ3));
            bPJ4Label.setText(Integer.toString(bPJ4));
        }
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
}
