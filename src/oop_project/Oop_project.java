package oop_project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Scanner;

public class Oop_project {

    static Connection c;

    static Statement st;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("***********************Welcome In Egyptian League************************\n");
        System.out.println("Enter User Name");
        String user_Name = input.nextLine();
        System.out.println("Enter Password");
        String pass = input.next();
        if (user_Name.equals("Admin") && pass.equals("Admin")) {
            while (true) {
                System.out.println("If You Want To Deal With");
                System.out.println("*************************************");
                System.out.println("Player        Enter 1");
                System.out.println("Match         Enter 2");
                System.out.println("Referee       Enter 3");
                System.out.println("Team          Enter 4");
                System.out.println("Stadium       Enter 5");
                System.out.println("League        Enter 6");
                System.out.println("*************************************");
                int answer = input.nextInt();
                Admin admin = new Admin();
                if (answer == 1) {
                    System.out.println("Add Player  Enter 1");
                    System.out.println("Edit Player  Enter 2");
                    System.out.println("Delete Player  Enter 3");
                    int answer2 = input.nextInt();
                    if (answer2 == 1) {
                        admin.add_player();
                    } else if (answer2 == 2) {
                        System.out.println("Enter The Name Of The column ");
                        String col = input.next();
                        col=col.toLowerCase();
                        if (col.charAt(0)=='n'&&col.charAt(0)=='a') {
                            System.out.println("Enter New Name ");
                            String New_Name = input.next();
                            System.out.println("Enter Team Name ");
                            String Team_Name = input.next();
                            System.out.println("Enter id of Player ");
                            int id = input.nextInt();
                            admin.update_Player(id, New_Name, Team_Name);
                        } else if (col.charAt(0)=='h') {
                            System.out.println("Enter New Height ");
                            float New_height = input.nextFloat();
                            System.out.println("Enter Team Name ");
                            String Team_Name = input.next();
                            System.out.println("Enter id of Player ");
                            int id = input.nextInt();
                            admin.update_Player(New_height, id, Team_Name);
                        } else if (col.charAt(0)=='w') {
                            System.out.println("Enter New weight ");
                            float New_weight = input.nextFloat();
                            System.out.println("Enter Team Name ");
                            String Team_Name = input.next();
                            System.out.println("Enter id of Player ");
                            int id = input.nextInt();
                            admin.update_Player(id, Team_Name, New_weight);
                        } else if (col.charAt(0)=='t') {
                            System.out.println("Enter New Team ");
                            String New_Team = input.next();
                            System.out.println("Enter old Team Name ");
                            String Team_Name = input.next();
                            System.out.println("Enter id of Player ");
                            int id = input.nextInt();
                            admin.update_Player(New_Team, id, Team_Name);
                        } else if (col.charAt(0)=='n') {
                            System.out.println("Enter New id ");
                            int New_id = input.nextInt();
                            System.out.println("Enter Team Name ");
                            String Team_Name = input.next();
                            System.out.println("Enter old  id of Player ");
                            int id = input.nextInt();
                            admin.update_Player(New_id, id, Team_Name);
                        }
                    } else if (answer2 == 3) {
                        admin.delete_Player();
                    }
                } else if (answer == 2) {
                    System.out.println("Add Match  Enter 1");
                    System.out.println("Edit Match  Enter 2");
                    System.out.println("Delete Match  Enter 3");
                    int answer2 = input.nextInt();
                    if (answer2 == 1) {
                        admin.add_list_of_matches();
                    } else if (answer2 == 2) {
                        admin.upDateMatch();
                    } else if (answer2 == 3) {
                        admin.delete_match();
                    }
                } else if (answer == 3) {
                    System.out.println("Add Referee  Enter 1");
                    System.out.println("Edit Referee  Enter 2");
                    System.out.println("Delete Referee  Enter 3");
                    int answer2 = input.nextInt();
                    if (answer2 == 1) {
                        admin.add_referee();
                        System.out.println("Do you want to Add List of Match to Referee(y/n)?");
                        char c = input.next().charAt(0);
                        if (c == 'y') {
                            admin.add_list_of_matches();
                        }
                    } else if (answer2 == 2) {
                        admin.update_Referee();
                    } else if (answer2 == 3) {
                        admin.delete_Referee();
                    }
                } else if (answer == 4) {
                    System.out.println("Add Team  Enter 1");
                    System.out.println("Edit Team  Enter 2");
                    System.out.println("Delete Team  Enter 3");
                    int answer2 = input.nextInt();
                    if (answer2 == 1) {
                        admin.Add_Team();
                        System.out.println("Do you want to Add List of Match to Team(y/n)?");
                        char c = input.next().charAt(0);
                        if (c == 'y') {
                            admin.add_list_of_matches();
                        }
                    } else if (answer2 == 2) {
                        admin.update_team();
                    } else if (answer2 == 3) {
                        System.out.println("Enter The Team Name ");
                        String team = input.next();
                        admin.delete_team(team);
                    }
                } else if (answer == 5) {
                    System.out.println("Add Stadium  Enter 1");
                    System.out.println("Edit Stadium  Enter 2");
                    System.out.println("Delete Stadium  Enter 3");
                    int answer2 = input.nextInt();
                    if (answer2 == 1) {
                        input.nextLine();
                        System.out.println("Enter Name Of stadium");
                        String name = input.nextLine();
                        System.out.println("Enter Capicty of Stadium");
                        int capicty = input.nextInt();
                        System.out.println("Enter Loction of The Stadium");
                        String loction = input.next();
                        admin.Add_stadium(name, loction, capicty);
                        System.out.println("Do you want to Add List of Match To Stadium(y/n)?");
                        char c = input.next().charAt(0);
                        if (c == 'y') {
                            admin.add_list_of_matches();
                        }
                    } else if (answer2 == 2) {
                        admin.Update_stadium();
                    } else if (answer2 == 3) {
                        admin.delete_Stadium();
                    }
                }
                
                else if (answer == 6) {
                    System.out.println("Add League      Enter 1");
                    System.out.println("Edit League     Enter 2");
                    System.out.println("Delete League   Enter 3");
                    int answer2 = input.nextInt();
                    if (answer2 == 1) 
                    {
                     admin.Add_league();                          
                    }
                    else if (answer2 == 2)
                    {
                        admin.update_league();
                    } else if (answer2 == 3) 
                    {
                        admin.delete_league();
                    }
                }
                System.out.println("Do you want to continue (y/n)?");
                char ans = input.next().charAt(0);
                if (ans == 'n')
                    break;
            }
        } else {
            System.out.println("If You want to ");
            System.out.println("show  All players Entre 1");
            System.out.println("show  Matches for specific Team Entre 2");
            System.out.println("show  All Referee Entre 3");
            System.out.println("show  All Stadiums Entre 4");
            System.out.println("Show  Matches That Play on specific Stadiums Entre 5");
            System.out.println("Show  Matches For specific Referee Entre 6");
            System.out.println("show  All Matches Entre 7");
            System.out.println("show  Matches for specific team Entre 8");
            System.out.println("show  All Teams Entre 9");
            System.out.println("show  Data for specific Stadium Entre 10");
            System.out.println("show  All Leagues details Entre 11");
            System.out.println("show  All Matches for specific League Entre 12");
            System.out.println("show  All Teams for specific League Entre 13");
            int choose = input.nextInt();
            Stadium stadium = new Stadium();
            Match match = new Match();
            referee refer = new referee();
            League league=new League();
             Team team = new Team();
            if (choose == 1) {
                player player = new player();
                player.show_Players();
            } else if (choose == 2) {
                match.Get_Specific_Matches();
            } else if (choose == 3) {
                refer.show_All_Referees_Data();
            } else if (choose == 4) {
                stadium.dataOfAllStadiums();
            } else if (choose == 5) {
                stadium.show_Matches_That_play_on_The_stadium();
            } else if (choose == 6) {
                refer.show_list_of_matches_of_Referee();
            } else if (choose == 7) {
                match.GetAllMatches();
            } else if (choose == 8) {
                match.Get_Specific_Matches();
            } else if (choose == 9) {
               
                team.GetTeams();
            } else if (choose == 10) {
                stadium.dataOfSpecificStadiums();
            }
            else if (choose == 11) {
                league.show_league();
            }
            else if (choose == 12) {
                league.GetAllMatches();
            }
            else if(choose==13)
            {
                league.GetTeams();
            }
        }
    }
}
