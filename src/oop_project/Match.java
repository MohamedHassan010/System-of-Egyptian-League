package oop_project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Match {

    private Connect connect;

    private Scanner Input;

    private Connection connection;

    private ResultSet resultSet;

    private Statement statement;

    public Match() {
        try {
            Input= new Scanner(System.in);
            connect= new Connect();
            connection = connect.connectt();
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Get_Specific_Matches() {
        System.out.println("Enter Name of The Team");
        String nameteam = Input.next();
        try {
            String Query = "select* from matche where Frist_Team='" + nameteam + "'";
            Query += "or Second_Team='" + nameteam + "' ";
            resultSet = statement.executeQuery(Query);
            System.out.println("Frist Teame\t Second Team \tResult\t Match Id\t Match Date \t Match Time\t ");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("Frist_Team"));
                System.out.print("\t \t" + resultSet.getString("Second_Team"));
                System.out.print("\t\t" + resultSet.getString("Result"));
                System.out.print("\t\t" + resultSet.getString("Match_id"));
                System.out.print("\t\t" + resultSet.getInt("Match_date"));
                System.out.print("\t\t" + resultSet.getString("Time"));
                System.out.println();
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }

    public void GetAllMatches() {
        try {
           
            String Query = "select* from matche ";
            resultSet = statement.executeQuery(Query);
            System.out.println("Frist Teame\t Second Team \tResult\t Match Id\t Match Date \t Match Time\t ");
            while (resultSet.next()) {
                System.out.println("");
                System.out.print(resultSet.getString("Frist_Team"));
                System.out.print("\t \t" + resultSet.getString("Second_Team"));
                System.out.print("\t\t" + resultSet.getString("Result"));
                System.out.print("\t\t" + resultSet.getString("Match_id"));
                System.out.print("\t\t" + resultSet.getInt("Match_date"));
                System.out.print("\t\t" + resultSet.getString("Time"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
