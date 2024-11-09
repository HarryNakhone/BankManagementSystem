package bank.manage.sys;

import java.sql.*;

public class Connec {

    Connection connection;

    Statement statement;

    public Connec(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "humyai12345");
            statement = connection.createStatement();
        }catch( Exception E){
            E.printStackTrace();
        }
    }
}
