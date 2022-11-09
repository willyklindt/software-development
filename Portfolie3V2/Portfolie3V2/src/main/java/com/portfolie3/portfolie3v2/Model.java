package com.portfolie3.portfolie3v2;

import java.util.ArrayList;

public class Model {
    DBHandler db =new DBHandler();
    Model(){
        //db.cmd("drop table if exists lst1;");
        db.cmd("create table if not exists lst1 "+
                "(fld1 integer primary key autoincrement, fld2 text);");
    }

    void add(String s){ // remember to sanitize your data!
        db.cmd("insert into lst1 (fld2) values ('"+s+"');");
    }

    public ArrayList<String> get(){
        return db.query("SELECT name FROM habour;", "name");
    }


}
