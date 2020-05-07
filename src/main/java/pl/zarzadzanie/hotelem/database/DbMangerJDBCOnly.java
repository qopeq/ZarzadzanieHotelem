package pl.zarzadzanie.hotelem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbMangerJDBCOnly {

    public void polacz(){
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        String dbURL = "";//!!!!!!!!!!!!!!!!!
        String username = "";//!!!!!!!!!!!!!!
        String password = "";//!!!!!!!!!!!!!!

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        if(connection != null){
            System.out.println("Connected");
            Statement statement = null;
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //try {
                //statement.execute("INSERT INTO Personel (imie, nazwisko, telofon, login, haslo, admin) VALUES ('Ala', 'kot','999 999 999','kot', 'ali', '0')");
            //} catch (SQLException e) {
               // e.printStackTrace();
            //}
        }
    }
}
