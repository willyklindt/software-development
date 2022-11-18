package com.portfolie3.portfolie3v2;

import java.util.ArrayList;

public class Model {
    DBHandler db =new DBHandler(); //Creates instance of DBHandler class

    Model(){
        db.cmd("pragma foreign_keys = ON;" +
                "create table if not exists habour (id Integer primary key, name Text);" +
                "create table if not exists vessel (id Integer primary key, name Text, capacity integer);" +
                "create table if not exists transport (id Integer primary key, vessel Integer UNIQUE references vessel(id), fromhabour Integer references habour(id), tohabour Integer references habour(id));" +
                "create table if not exists flow (id Integer primary key autoincrement, transport Integer references transport(id), containers integer check (typeof(containers) = 'integer'));" +

                "insert or ignore into habour values(1,'Jawaharlal Nehru');\n" +
                "insert or ignore into habour values(2,'Tanjung Pelepas');\n" +
                "insert or ignore into habour values(3,'Dar Es Salaam');\n" +
                "insert or ignore into habour values(4,'Mombasa');\n" +
                "insert or ignore into habour values(5,'Zanzibar');\n" +
                "insert or ignore into habour values(6,'Jebel Ali Dubai');\n" +
                "insert or ignore into habour values(7,'Salalah');" +

                "insert or ignore into vessel values(1,'Maren',12000);\n" +
                "insert or ignore into vessel values(2,'Misse',5000);\n" +
                "insert or ignore into vessel values(3,'Mette',8000);\n" +
                "insert or ignore into vessel values(4,'Musse',10000);\n" +
                "insert or ignore into vessel values(5,'Mugge',8000);\n" +
                "insert or ignore into vessel values(6,'Marle',10000);\n" +
                "insert or ignore into vessel values(7,'Minne',10000);\n" +
                "insert or ignore into vessel values(8,'Maryk',10000);\n" +
                "insert or ignore into vessel values(9,'Melle',10000);\n" +
                "insert or ignore into vessel values(10,'Manna',10000);\n" +
                "insert or ignore into vessel values(11,'Mynte',10000);\n" +
                "insert or ignore into vessel values(12,'Munja',10000);" +

                "insert or ignore into transport values (1,1,1,4);\n" +
                "insert or ignore into transport values (2,2,1,3);\n" +
                "insert or ignore into transport values (3,3,2,4);\n" +
                "insert or ignore into transport values (4,4,2,3);\n" +
                "insert or ignore into transport values (5,5,2,5);\n" +
                "insert or ignore into transport values (6,6,2,6);\n" +
                "insert or ignore into transport values (7,7,2,7);\n" +
                "insert or ignore into transport values (8,8,3,2);\n" +
                "insert or ignore into transport values (9,9,3,1);\n" +
                "insert or ignore into transport values (10,10,3,6);\n" +
                "insert or ignore into transport values (11,11,4,7);\n" +
                "insert or ignore into transport values (12,12,4,6);");
    }



    void add(String s){ // remember to sanitize your data!
        db.cmd("insert into flow (transport, containers) values (1," + s+");");
    } //Denne klasse bruger vi ikke pt, men at sanitize data, skal vi kigge på.

    public ArrayList<String> port(){
        return db.query("SELECT name FROM habour;", "name");
    }
    //Metode til at vise "fromports" i vores combobox. DISTINT gør at havn kun vises 1 gang i liste. Men man kan stade vælge samme havn i hhv. "from" og toport


    public ArrayList<String> availableVessels(String from, String to, Integer flow){ //Method that return list of avaible vessels
    return db.query("select t.id as id, h1.name as fromport, h2.name as toport, v.id as vessel, TOTAL(f.containers) as flow, v.capacity" +
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
