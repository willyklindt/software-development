package com.portfolie3.portfolie3v2;



import java.util.ArrayList;

public class Controller {
    Model model;
    Main view;

    DBHandler dbHandler;
    Controller(Model model, Main view){
        this.model=model; this.view=view;
    }

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


}