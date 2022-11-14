package com.portfolie3.portfolie3v2;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    Model model;
    Main view;

    DBHandler dbHandler;
    Controller(Model model, Main view){
        this.model=model; this.view=view;
    }
/*
    void initArea(){
        String toarea="";
        for(String t:model.fromport())toarea+=t+"\n";
        view.setArea(toarea);
    }
    void enterText(String s){
        model.add(s);
        view.clearField();
        String toarea="";
        for(String t:model.toport())toarea+=t+"\n";
        view.setArea(toarea);
    }

    void searchVessel (String from, String to, Integer flow){

        view.clearField();
        String result="";

        for (String toFind: model.availableVessels(from, to, flow)){
            result+=toFind+"\n";
        }
        view.setArea(result);

    }
*/
    void searchVessel (String from, String to, Integer flow){ //Takes a from and to port (string) and flow (Integer)

        view.hideField(true);
        //view.clearField(); //Clears textfield when searchVessel method is called.
        ObservableList <String> result= FXCollections.observableArrayList(); //Makes an Observable List, which stores result (the vessels to be shown)

        for (String toFind: model.availableVessels(from, to, flow)){ //Calls method avaibleVessels in Model class, for earch avaible vessel
            result.add(toFind); //Adds string value to result list
        }
        view.setListView(result); //Adds final result to listView (and avaible vessels are now shown

    }

    void printSelected (ObservableList<String> vessel){ //Dummy method. Can be used to print names of avable vessels to console.
        System.out.println(vessel);
    }

    void updateFlow (String vessel, Integer flow){ // Method to update amount of containers of a given vessel.
        model.sendCargo("mads", flow); //Method curently doesn't work, is "hardbaged" to always update flow with 1500
        //Also parameter "vessel" doesn't currently work.
        view.clearField();
        view.clearListView();
        view.hideField(false);
    }



}