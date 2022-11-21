package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
    static String url = "jdbc:mysql://127.0.0.1:3306/pokemons?useTimezone=true&serverTimezone=UTC";
	static String username = "root";
	static String password = "13579Rock";

    public static Connection getConnection(){

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);

        } catch(SQLException e){
            e.printStackTrace();
        }

        return conn;
    }
}
