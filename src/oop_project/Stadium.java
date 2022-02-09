package oop_project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import static oop_project.Oop_project.c;

public class Stadium {

    Scanner input;

    private Connection connection;

    private Statement statement;

    private Connect connect;

    private ResultSet resultSet;

    public Stadium() {
        try {
            input= new Scanner(System.in);
            connect= new Connect();
            connection = connect.connectt();
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void dataOfAllStadiums() {
        try {
            String query = "select * from stadium";
            resultSet = statement.executeQuery(query);
            System.out.print("Name of The Stadium\t");
            System.out.print("Capacity Of The Stadium        ");
            System.out.println("Location of The Stadium");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("Stadium_Name") + "\t" + "\t" + "\t");
                System.out.print(resultSet.getInt("Capacity") + "\t" + "\t" + "\t"+"\t");
                System.out.print(resultSet.getString("loctaion"));
                System.out.println('\n');
            }
            System.out.println("********************************************************************************************");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void dataOfSpecificStadiums() {
        try {
            System.out.println("Enter The Name of The Stadium ");
          
            String Answer = input.nextLine();
            String query = "select * from stadium where Stadium_Name='" + Answer + "'";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            System.out.print("Name of The Stadium" + "\t"+"\t");
            System.out.print("Capacity Of The Stadium" + "\t" + "\t");
            System.out.println("Location of The Stadium");
            System.out.print(resultSet.getString("Stadium_Name") + "\t" + "\t"+"\t"+"\t");
            System.out.print(resultSet.getInt("Capacity") + "\t" + "\t" + "\t" + "\t");
            System.out.println(resultSet.getString("loctaion") + "\t");
            System.out.println("********************************************************************************************");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void show_Matches_That_play_on_The_stadium() {
        try {
            System.out.println("Enter The Name of The Stadium ");
           
            String Answer = input.nextLine();
            String query = "select Frist_Team,Second_Team from matche where stadename='" + Answer + "'";
            resultSet = statement.executeQuery(query);
            System.out.println("The Matches is");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("Frist_Team") + '\t');
                System.out.print(resultSet.getString("Second_Team") + '\t');
                System.out.println('\n');
            }
            System.out.println("********************************************************************************************");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
