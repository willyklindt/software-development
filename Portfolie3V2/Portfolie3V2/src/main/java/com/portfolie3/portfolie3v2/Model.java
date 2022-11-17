package com.portfolie3.portfolie3v2;

import java.util.ArrayList;

public class Model {
    DBHandler db =new DBHandler(); //Creates instance of DBHandler class
    Model(){

        db.cmd("create table if not exists lst1 "+
                "(fld1 integer primary key autoincrement, fld2 text);"); //Denne skal vi ændre til at slette alle vores tables, når program startes
    }

    void add(String s){ // remember to sanitize your data!
        db.cmd("insert into flow (transport, containers) values (1," + s+");");
    } //Denne klasse bruger vi ikke pt, men at sanitize data, skal vi kigge på.

    public ArrayList<String> port(){
        return db.query("SELECT name FROM habour;", "name");
    }
    //Metode til at vise "fromports" i vores combobox. DISTINT gør at havn kun vises 1 gang i liste. Men man kan stade vælge samme havn i hhv. "from" og toport


    public ArrayList<String> availableVessels(String from, String to, Integer flow){ //Method that return list of avaible vessels
    return db.query("select t.id as id, h1.name as fromport, h2.name as toport, v.id as vessel, Sum(f.containers) as flow, v.capacity" +
            " from transport t " +
            "inner join vessel v on t.vessel = v.id " +
            "inner join habour h1 on t.fromhabour = h1.id " +
            "inner join habour h2 on t.tohabour = h2.id " +
            "left outer join flow f on t.id = f.transport " +
            "where fromport  = '"+ from + "' and toport  = '"+ to+"' " + //WHERE, only choses selected from and toport
            "group by t.id " +
            "having flow +"+  flow + "<= v.capacity AND " + flow +" >0;", "vessel"); //having flow... ensures that only vessels with enough left space gets selected
    }

    void sendCargo(Integer vessel, Integer flow){ //Virker halvt. Ligenu kan den opdatere i database, men er pt. sat til at sætte flow til valgte, og kun på ID = 1.
        db.cmd("insert into flow(transport,containers) values ("+vessel+","+flow+");");
    }


    public ArrayList<String> getVesselID(Integer vesselID) {
    return db.query("select name " +
            "from vessel " +
            "where id = " + vesselID + ";", "name");
    }
}