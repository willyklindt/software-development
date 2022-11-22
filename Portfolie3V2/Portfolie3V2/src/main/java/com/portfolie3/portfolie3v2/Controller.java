package com.portfolie3.portfolie3v2;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    Model model; //Constructor parameter
    Main view; //Constructor parameter

    Controller(Model model, Main view){ //Constructor
        this.model=model; this.view=view;
    }

    void searchVessel (String from, String to, Integer flow){ //Takes a from and to port (string) and flow (Integer)

        view.hideField(true); //Disables search field

        ObservableList <Integer> result = FXCollections.observableArrayList(); //Makes an Observable List, which stores result (the vessels to be shown)

        for (String toFind: model.availableVessels(from, to, flow)){ //Calls method availableVessels in Model class, for each available vessel
            result.add(Integer.valueOf(toFind)); //Adds string value to result list
        }
        view.setShowVesselID(result); //Adds final result to listView (and available vessels are now shown

    }

    void selectedVessel(Integer vesselID){
        ObservableList <String> result = FXCollections.observableArrayList();

        for (String findID: model.getVesselID(vesselID)){ //Calls method availableVessels in Model class, for each available vessel
            result.add(String.valueOf(findID)); //Adds string value to result list
        }
        view.setShowVesselName(result);

    }

    void updateFlow (Integer vesselID, Integer flow){ // Method to update amount of sent containers of a given vessel.
        model.sendCargo(vesselID, flow);
        view.clearField();
        view.clearListView();
        view.hideField(false);
    }





}