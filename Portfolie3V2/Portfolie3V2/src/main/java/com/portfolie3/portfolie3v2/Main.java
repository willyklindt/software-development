package com.portfolie3.portfolie3v2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    private Model model=new Model();
    private Controller controller =new Controller(model,this);
    // The above two classes (Model and Controller) gets initiated. This is a part of the MVC pattern. View is Main class

    private ComboBox comboBoxFrom= new ComboBox(FXCollections
            .observableArrayList(model.port()));
    private ComboBox comboBoxTo = new ComboBox(FXCollections
            .observableArrayList(model.port()));
    //The above two ComboBoxes, comboBoxTo and comboBoxFrom, is the list of harbours to choose from
    private TextField searchField =new TextField(); //"Search field", where desired amount of cargo can be entered
    private TextField showVesselName = new TextField(); // Used to show the name of selected vessel
    private ComboBox<Integer> showVesselID = new ComboBox<>(); //Used for displaying list of vessels which can be used for transport


    void setShowVesselID(ObservableList<Integer> s){
        showVesselID.setItems(s);
    } //Function to set found vessels ID's
    void setShowVesselName(ObservableList<String> i){showVesselName.setText(i.toString());} //Function to set found Vessel name. Using to.String() to convert from ObservableList to string
    void clearField(){
        searchField.setText("");} //Function to clear field.
    void clearListView(){
        showVesselID.getItems().clear();} //Function to clear ComboBox of found vessel ID's
    void hideField(boolean displayOption){
        searchField.setDisable(displayOption); // Function to show/hide "search" field
      }

      void resetSearch(){ //Method that sets comboboxes to null, textfields to null, and enables field again. Aka a "reset", so user can search again/cancel search
        comboBoxFrom.setValue(null);
        comboBoxTo.setValue(null);
        showVesselID.setValue(null);
        hideField(false);
        searchField.setText(null);
        showVesselName.setText(null);
    }

    @Override
    public void start(Stage stage) {

        Button search = new Button("Search"); //Search button
        Button updateFlow = new Button("Send containers"); //Button used for updating flow, is clicked when avaible vessel is selected
        Button selectedVessel = new Button("Select vessel"); //Buttun used for selecting the vessel, whosen from the ComboBox of found vessels
        Button cancelSearch = new Button("Cancel search"); //Button used for cancelling search
        showVesselName.setDisable(true); // Set showVesselName as disables from start, as user should never be able to edit in this textfield

        Label fromPort = new Label("From Port:");
        Label toPort = new Label("To Port:");
        Label containers = new Label("Amount of containers:");
        Label vesselResult = new Label("Available vessels found:");

        search.setOnAction(e-> {if (searchField.getText().isEmpty() != true) controller.searchVessel((String) comboBoxFrom.getValue(), (String) comboBoxTo.getValue(), Integer.valueOf(searchField.getText()));});
        //When search is clicked, calls the method searchVessel in Controller class. Parses value from selected harbours (converted to String) and the value from textfield, ie. amount of containers, (converted to Integer value)
        //Contains ifstatement, lambra expression only runs if field is not NULL

        updateFlow.setOnAction(e-> {if (showVesselID.getSelectionModel().isEmpty() != true && searchField.getText().isEmpty() != true) controller.updateFlow(Integer.valueOf(showVesselID.getValue()), Integer.valueOf(searchField.getText()));});
        //When "Send containers" button is clicked, it calls the method updateFlow in Controller class. Parses value of selected vessel, and is converted to string using toString.
        //Contains ifstatement, lambra expression only runs if foundVessels and field is not NULL

        selectedVessel.setOnAction(e-> {if (showVesselID.getSelectionModel().isEmpty() != true) controller.selectedVessel(Integer.valueOf(Integer.valueOf(showVesselID.getValue())));});
        //Contains ifstatement, lambra expression only runs if foundVessels is not NULL

        cancelSearch.setOnAction(e-> resetSearch()); //Calls function resetSearch(), which "clears search"

        VBox vBox = new VBox(15);
        vBox.getChildren().addAll(fromPort,comboBoxFrom, toPort, comboBoxTo, containers, searchField, search, vesselResult, showVesselID, selectedVessel, showVesselName,updateFlow, cancelSearch); //Adds all elements to be displayed, to our vBox

        Scene scene = new Scene(vBox, 400, 500);
        stage.setTitle("Not M0m0nd0");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}