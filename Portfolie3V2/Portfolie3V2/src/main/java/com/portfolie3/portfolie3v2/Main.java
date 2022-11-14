package com.portfolie3.portfolie3v2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.IOException;

public class Main extends Application {

    private Model model=new Model(); //Måske skal den være final?
    private Controller con=new Controller(model,this); //Måske den skal være final?
    // The above two classes (Model and Controller) gets initiated, using the MVC pattern. View is Main class

   private ComboBox comboBoxFrom= new ComboBox(FXCollections
            .observableArrayList(model.fromport()));
    private ComboBox comboBoxTo = new ComboBox(FXCollections
            .observableArrayList(model.toport()));
    //The above two ComboBoxes, comboBoxTo and comboBoxFrom, is the list of harbours to choose from
    private TextField field=new TextField(); //"Search field", where desired amount of cargo can be entered
    private ListView<String> listView =new ListView<String>(); //Used for displaying list of vessels which can be used for transport

    //private TextArea area=new TextArea();

   //void setArea(String s){area.setText(s);}

    void setListView(ObservableList<String> s){listView.setItems(s);} //Function to set vessels
    void clearField(){field.setText("");} //Function to clear field.
    void clearListView(){listView.getItems().clear();}
    void hideField(boolean displayOption){field.setDisable(displayOption);
      }

    @Override
    public void start(Stage stage) throws IOException {

      //  con.initArea();
       // field.setOnAction(e->con.enterText(field.getText()));
       // listView.setOnMouseClicked(e->con.enterText(field.getText()));
       // TextArea text = new TextArea();

        Button search = new Button("Search"); //Search button
        Button updateFlow = new Button("Send containers"); //Button used for updating flow, is clicked when avaible vessel is selected

        search.setOnAction(e-> con.searchVessel((String) comboBoxFrom.getValue(), (String) comboBoxTo.getValue(), Integer.valueOf(field.getText())));
        //When search is clicked, calls the method searchVessel in Controller class. Parses value from selected harbours (typecasted as String) and value from textfield, ie. amaount of containers, (typecasted as int)

       updateFlow.setOnAction(e-> con.updateFlow(listView.getSelectionModel().getSelectedItems().toString(), Integer.valueOf(field.getText())));
       //When "Send containers" button is clicked, it calls the method updateFlow in Controller class. Parses value of selected vessel, and is typecasted using toString.

        // Create horizontal view in FX
        TilePane tile_pane = new TilePane();
        tile_pane.getChildren().addAll(comboBoxFrom, comboBoxTo, field, listView, search, updateFlow);

        Scene scene = new Scene(tile_pane, 800, 900);
        stage.setTitle("JavaFX Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}