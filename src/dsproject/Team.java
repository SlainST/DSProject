package dsproject;

import java.util.Random;

public class Team {
    String name;
    int teamID;
    PlayerLinkedList players;
    int totalPoint;
    int goalDifference;
    int PlayedGame = 0;
    int TeamMemberCount;
    
    boolean HasAKeeper;
    
    
    public Team(String name){
        
        this.name = name;
        this.teamID = teamID;
        this.players = new PlayerLinkedList(); 
        this.totalPoint = 0;
        this.goalDifference = 0;
        
        this.teamID=IDGenerator(this);
    }
    
    public void PlayerToTeam(Player player){
         players.AddPlayer(player);
         if(player.position==0){
             this.HasAKeeper=true;
         }
    }
    
    public void UpdateGoalDifference(int diff){
        goalDifference += diff; 
    }
    public void UpdatePoints(int points){
        totalPoint += points; 
    }
    
    public void GetTeamData(){
        System.out.println("TEAM: ");
        System.out.print(this.name);
        System.out.println("Team ID:     " + this.teamID);
        System.out.println("Team Point:  " + this.totalPoint);
        System.out.println("Average:   " + this.goalDifference);
    }
    
    public int IDGenerator(Team team){
        Random random = new Random();
        this.teamID = random.nextInt(0,1000000000);
        return teamID;
    }
}
