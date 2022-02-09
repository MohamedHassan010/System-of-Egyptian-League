/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class League extends SuperFunction{
     private Connection connection;

    private Statement statement;

    private Connect connect;

    private ResultSet resultSet;

  //  private String query2;

    private String query;
    
    private Scanner input;

    public League() 
    {
         try 
         {
             input= new Scanner(System.in);
             connect= new Connect();
            connection = connect.connectt();
            statement = connection.createStatement();
        }
         catch (SQLException e) 
         {
            System.out.println(e.getMessage());
        }
    }
    
        void show_league()
    {
        try{
           query="select * from league";
            resultSet = statement.executeQuery(query);
            System.out.println("Start date"+'\t'+"End date"+'\t'+"League Number");
            while (resultSet.next())
            {           
                System.out.println(resultSet.getString("Start_date")+"\t"+resultSet.getString("End_date")+"\t"+resultSet.getString("LeagueNumber"));
            }
        }
        catch (SQLException e)
        {
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

    @Override
    public void GetTeams() {
        try {
            System.out.println("Enter League Number");
            int num_league=input.nextInt();
            query = "select* from team where LeagueNumber ='" + num_league+ "'";
            resultSet = statement.executeQuery(query);
            System.out.println("Team Name");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Team_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
