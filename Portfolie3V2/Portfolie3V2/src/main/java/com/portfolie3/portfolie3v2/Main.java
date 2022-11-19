package com.portfolie3.portfolie3v2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {

    private Model model=new Model(); //Måske skal den være final?
    private Controller con=new Controller(model,this); //Måske den skal være final?
    // The above two classes (Model and Controller) gets initiated, using the MVC pattern. View is Main class

   private ComboBox comboBoxFrom= new ComboBox(FXCollections
            .observableArrayList(model.port()));
    private ComboBox comboBoxTo = new ComboBox(FXCollections
            .observableArrayList(model.port()));
    //The above two ComboBoxes, comboBoxTo and comboBoxFrom, is the list of harbours to choose from
    private TextField field=new TextField(); //"Search field", where desired amount of cargo can be entered
   private TextField showVesselID = new TextField();
    private ComboBox<Integer> foundVessels = new ComboBox<>(); //Used for displaying list of vessels which can be used for transport


    void setFoundVessels(ObservableList<Integer> s){
        foundVessels.setItems(s);
    } //Function to set vessels
    void showVesselName(ObservableList<String> i){
    showVesselID.setText(i.toString());
    }
    void clearField(){field.setText("");} //Function to clear field.
    void clearListView(){
        foundVessels.getItems().clear();}
    void hideField(boolean displayOption){field.setDisable(displayOption);
      }



      void resetSearch(){ //Method that sets comboboxes to null, textfields to null, and enables field again. Aka a "reset", so user can search again/cancel search
        comboBoxFrom.setValue(null);
        comboBoxTo.setValue(null);
          foundVessels.setValue(null);
        hideField(false);
        field.setText(null);
        showVesselID.setText(null);

    }


    @Override
    public void start(Stage stage) throws IOException {



        Button search = new Button("Search"); //Search button
        Button updateFlow = new Button("Send containers"); //Button used for updating flow, is clicked when avaible vessel is selected
        Button selectedVessel = new Button("Select vessel");
        Button cancelSearch = new Button("Cancel search");
        showVesselID.setDisable(true);

        Label fromPort = new Label("From Port:");
        Label toPort = new Label("To Port:");
        Label containers = new Label("Amount of containers:");
        Label vesselResult = new Label("Available vessels found:");
        //model.initDB();

        //model.add("William");


            search.setOnAction(e-> {if (field.getText().isEmpty() != true) con.searchVessel((String) comboBoxFrom.getValue(), (String) comboBoxTo.getValue(), Integer.valueOf(field.getText()));});
            //When search is clicked, calls the method searchVessel in Controller class. Parses value from selected harbours (typecasted as String) and value from textfield, ie. amaount of containers, (typecasted as int)
        //Contains ifstatement, lambra expression only runs if field is not NULL


       updateFlow.setOnAction(e-> {if (foundVessels.getSelectionModel().isEmpty() != true && field.getText().isEmpty() != true) con.updateFlow(Integer.valueOf(foundVessels.getValue()), Integer.valueOf(field.getText()));});
       //When "Send containers" button is clicked, it calls the method updateFlow in Controller class. Parses value of selected vessel, and is typecasted using toString.
        //Contains ifstatement, lambra expression only runs if foundVessels and field is not NULL
        selectedVessel.setOnAction(e-> {if ( foundVessels.getSelectionModel().isEmpty() != true) con.selectedVessel(Integer.valueOf(Integer.valueOf(foundVessels.getValue())));});
        //Contains ifstatement, lambra expression only runs if foundVessels is not NULL

       cancelSearch.setOnAction(e-> resetSearch()); //Calls function resetSearch(), which "clears search"

        // Create horizontal view in FX
        VBox vBox = new VBox(15);
        vBox.getChildren().addAll(fromPort,comboBoxFrom, toPort, comboBoxTo, containers, field, search, vesselResult, foundVessels, selectedVessel, showVesselID,updateFlow, cancelSearch);

        Scene scene = new Scene(vBox, 400, 500);
        stage.setTitle("Not M0m0nd0");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}