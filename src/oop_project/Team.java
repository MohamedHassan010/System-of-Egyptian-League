package oop_project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Team extends SuperFunction{

    private Connection connect;

    private Statement statement;

    private String Query;

    private Connect con;

    private ResultSet resultSet;
    
    private Scanner input;

    public Team() {
        try {
            input= new Scanner(System.in);
            con= new Connect();
            connect = con.connectt();
            statement = connect.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void GetTeams() {
        try {
           
            Query = "select* from team ";
            resultSet = statement.executeQuery(Query);
            System.out.println("Team Name");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Team_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void GetAllMatches() {
          try {
            System.out.println("Enter League Number");
            int num_league=input.nextInt();
            String Query = "select* from matche where LeagueNumber='" + num_league+ "'";
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
