package com.steam.demosite;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class veriIslem {
    private String userName="root";
    private String password="";
    private String host="127.0.0.1";
    private String dataBase="stok";
    private int port=3306;

    public Connection con=null;
    private Statement ifade;

    public Connection initialize() {

        String url="jdbc:mysql://"+this.host+":"+this.port+"/"+this.dataBase;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException exc) {
            System.out.println(exc.toString());
        }

        try {
            this.con=DriverManager.getConnection(url, userName, password);
        }catch(SQLException exc) {
            System.out.println(exc.toString());
        }

        if(con!=null){
            System.out.println("Succesfull Connection...");
            return con;
        }
        else {
            System.out.println("Connection Failed...");
            return null;
        }
    }

}
