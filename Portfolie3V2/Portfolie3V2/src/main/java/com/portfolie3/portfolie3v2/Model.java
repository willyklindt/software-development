package com.portfolie3.portfolie3v2;

import java.util.ArrayList;

public class Model {
    DBHandler db =new DBHandler();


    Model(){
        db.cmd("PRAGMA foreign_keys = ON;" +
                "CREATE TABLE IF NOT EXISTS habour (id INTEGER PRIMARY KEY, name TEXT);" +
                "CREATE TABLE IF NOT EXISTS vessel (id INTEGER PRIMARY KEY, name TEXT, capacity INTEGER);" +
                "CREATE TABLE IF NOT EXISTS transport (id INTEGER PRIMARY KEY, vessel INTEGER UNIQUE REFERENCES vessel(id), fromhabour INTEGER REFERENCES habour(id), tohabour INTEGER REFERENCES habour(id));" +
                "CREATE TABLE IF NOT EXISTS flow (id INTEGER PRIMARY KEY AUTOINCREMENT, transport INTEGER REFERENCES transport(id), containers INTEGER CHECK (typeof(containers) = 'integer'));" +

                "INSERT OR IGNORE INTO habour VALUES(1,'Jawaharlal Nehru');\n" +
                "INSERT OR IGNORE INTO habour VALUES(2,'Tanjung Pelepas');\n" +
                "INSERT OR IGNORE INTO habour VALUES(3,'Dar Es Salaam');\n" +
                "INSERT OR IGNORE INTO habour VALUES(4,'Mombasa');\n" +
                "INSERT OR IGNORE INTO habour VALUES(5,'Zanzibar');\n" +
                "INSERT OR IGNORE INTO habour VALUES(6,'Jebel Ali Dubai');\n" +
                "INSERT OR IGNORE INTO habour VALUES(7,'Salalah');" +

                "INSERT OR IGNORE INTO vessel VALUES(1,'Maren',12000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(2,'Misse',5000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(3,'Mette',8000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(4,'Musse',10000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(5,'Mugge',8000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(6,'Marle',10000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(7,'Minne',10000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(8,'Maryk',10000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(9,'Melle',10000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(10,'Manna',10000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(11,'Mynte',10000);\n" +
                "INSERT OR IGNORE INTO vessel VALUES(12,'Munja',10000);" +

                "INSERT OR IGNORE INTO transport VALUES (1,1,1,4);\n" +
                "INSERT OR IGNORE INTO transport VALUES (2,2,1,3);\n" +
                "INSERT OR IGNORE INTO transport VALUES (3,3,2,4);\n" +
                "INSERT OR IGNORE INTO transport VALUES (4,4,2,3);\n" +
                "INSERT OR IGNORE INTO transport VALUES (5,5,2,5);\n" +
                "INSERT OR IGNORE INTO transport VALUES (6,6,2,6);\n" +
                "INSERT OR IGNORE INTO transport VALUES (7,7,2,7);\n" +
                "INSERT OR IGNORE INTO transport VALUES (8,8,3,2);\n" +
                "INSERT OR IGNORE INTO transport VALUES (9,9,3,1);\n" +
                "INSERT OR IGNORE INTO transport VALUES (10,10,3,6);\n" +
                "INSERT OR IGNORE INTO transport VALUES (11,11,4,7);\n" +
                "INSERT OR IGNORE INTO transport VALUES (12,12,4,6);");
    }



    public ArrayList<String> port(){
        return db.query("SELECT name FROM habour;", "name");
    }



    public ArrayList<String> availableVessels(String from, String to, Integer flow){
    return db.query("SELECT t.id AS id, h1.name AS fromport, h2.name AS toport, v.id AS vessel, TOTAL(f.containers) AS flow, v.capacity" +
            " FROM transport t " +
            "INNER JOIN vessel v ON t.vessel = v.id " +
            "INNER JOIN habour h1 ON t.fromhabour = h1.id " +
            "INNER JOIN habour h2 ON t.tohabour = h2.id " +
            "LEFT OUTER JOIN flow f ON t.id = f.transport " +
            "WHERE fromport  = '"+ from + "' AND toport  = '"+ to+"' " + //WHERE, only choses selected from and toport
            "GROUP BY t.id " +
            "HAVING flow +"+  flow + "<= v.capacity AND " + flow +" >0;", "vessel"); //having flow... ensures that only vessels with enough left space gets selected
    }


    void sendCargo(Integer vesselID, Integer flow){
        db.cmd("INSERT INTO flow(transport,containers) VALUES ("+vesselID+","+flow+");");
    }


    public ArrayList<String> getVesselID(Integer vesselID) {
    return db.query("SELECT name " +
            "FROM vessel " +
            "WHERE id = " + vesselID + ";", "name");
    }
}
