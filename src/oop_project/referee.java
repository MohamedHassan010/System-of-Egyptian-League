package oop_project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class referee {

    private Connection connection;

    private Statement statement;

    private ResultSet resultSet;

    private String query;

    private Connect connect;

    private Scanner input;

    public referee() {
        try {
            connect = new Connect();
            input= new Scanner(System.in);
            connection = connect.connectt();
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void show_All_Referees_Data() {
        try {
            resultSet = statement.executeQuery("select * from referee ");
            System.out.println("SSN  " + "First Name  " + "Last Name  " + "Height   " + "weight   ");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("SSN") + "   " + resultSet.getNString("Referee_firstName") + "       " + resultSet.getNString("Referee_lastName") + "     " + resultSet.getFloat("Referee_height") + "     " + resultSet.getFloat("Referee_weight"));
            }
            System.out.println("********************************************************************************************");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void show_list_of_matches_of_Referee() {
        try {
            System.out.println("Enter SSN Of The Referee");
            int ssn = input.nextInt();
            resultSet = statement.executeQuery("select * from matche where SSN= '" + ssn + "'");
            System.out.println("First Team    " + "Second Team");
            while (resultSet.next()) {
                System.out.println(resultSet.getNString("Frist_Team") + "      Vs    " + resultSet.getNString("Second_Team"));
            }
            System.out.println("********************************************************************************************");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
