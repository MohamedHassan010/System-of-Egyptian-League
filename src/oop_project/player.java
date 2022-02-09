package oop_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class player {

    private Connection connection;

    private Statement statement;

    private ResultSet resultSet;

    private Connect connect;

    public player() {
        try {
            connect= new Connect();
            connection = connect.connectt();
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void show_Players() {
        try {
            resultSet = statement.executeQuery("select * from player ");
            System.out.println("Player Name" + "   " + "Player Height" + "   " + "Player Weight" + "   " + "Teame Name" + "   " + "Player Number");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Player_name") + "           " + resultSet.getFloat("Player_height") + "           " + resultSet.getFloat("Player_weight") + "           " + resultSet.getNString("Teame_name") + "           " + resultSet.getInt("Player_num"));
            }
            System.out.println("********************************************************************************");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
