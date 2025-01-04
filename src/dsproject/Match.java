package dsproject; 

import java.util.Random;

public class Match {
    Team team1;
    Team team2;
    int teamScore1;
    int teamScore2;
    
    public Match(Team team1,Team team2){
        this.team1 = team1;
        this.team2 = team2;
        this.teamScore1 = 0;
        this.teamScore2 = 0;
    }
    
    public void MatchSimulate(){
        
        //maç yapacak takımlardan birisinin kalecisi yoksa ya da takım 11 kişiden az oyuncuya sahipse maç oynatma
       
        
        if(team1.TeamMemberCount>10||team2.TeamMemberCount>10){
            boolean team1hasAkeeper=false;
            boolean team2hasAkeeper=false;
            PlayerNode current=team1.players.head;
            while(current.next!=null|| team1hasAkeeper==false){
                if(current.player.position==0){
                    team1hasAkeeper=true;
                }
                current=current.next;
            }
            
            current=team2.players.head;
            while(current.next!=null|| team2hasAkeeper==false){
                if(current.player.position==0){
                    team2hasAkeeper=true;
                }
                current=current.next;
            }
            if(!team1hasAkeeper&&!team2hasAkeeper){
                team1.UpdatePoints(-1);
                team2.UpdatePoints(-1);
            }
            else if(!team1hasAkeeper){
                team1.UpdatePoints(-1);
                team2.UpdatePoints(3);
            }
            else if(!team2hasAkeeper){
                team1.UpdatePoints(3);
                team2.UpdatePoints(-1);}
            else{
                Random random = new Random();
                
                int HowManyShotsTeam1Tried= random.nextInt(0,20);
                int HowManyShotsTeam2Tried= random.nextInt(0,20);
                
                for (int i = 0; i < HowManyShotsTeam1Tried; i++) {
                    int WhichPlayerInTeam1WillTry= random.nextInt(1,12);
                    PlayerNode currentPlayer= team1.players.head;
                    for (int j = 0; j < WhichPlayerInTeam1WillTry; j++) {
                        currentPlayer= currentPlayer.next;
                    }
                    int didScored= random.nextInt(0,2);
                    
                    if(didScored==1){
                        currentPlayer.player.goalScore++;
                        teamScore1++;
                    }
                }
                
                //////////
                ///
                for (int i = 0; i < HowManyShotsTeam2Tried; i++) {
                    int WhichPlayerInTeam2WillTry= random.nextInt(1,12);
                    PlayerNode currentPlayer= team2.players.head;
                    for (int j = 0; j < WhichPlayerInTeam2WillTry; j++) {
                        currentPlayer= currentPlayer.next;
                    }
                    int didScored= random.nextInt(0,2);
                    
                    if(didScored==1){
                        currentPlayer.player.goalScore++;
                        teamScore2++;
                    }
                }   
                
                
                //teamScore1 = random.nextInt(6);
                //teamScore2 = random.nextInt(6);
                
                MatchResult();
                UpdateTeamStates();
            }
       
        }else{
            if(team1.TeamMemberCount<11&&team2.TeamMemberCount<11){
                team1.UpdatePoints(-1);
                team2.UpdatePoints(-1);
            }
            else if(team1.TeamMemberCount<11){
                team1.UpdatePoints(-1);
                team2.UpdatePoints(3);
            }
            else if(team2.TeamMemberCount<11){
                team1.UpdatePoints(3);
                team2.UpdatePoints(-1);
            }
        }
    }
    public void UpdateTeamStates(){
        if(teamScore1 > teamScore2){
            team1.UpdatePoints(3);
            team2.UpdatePoints(0);
        }
        else if(teamScore1 < teamScore2){
            team2.UpdatePoints(3);
            team1.UpdatePoints(0);
        }
        else if(teamScore1==teamScore2){
            team2.UpdatePoints(1);
            team1.UpdatePoints(1);
        }
        team1.UpdateGoalDifference(teamScore1 - teamScore2);
        team2.UpdateGoalDifference(teamScore2 - teamScore1);
        
        team1.PlayedGame++;
        team2.PlayedGame++;
    }
    public void MatchResult(){
        System.out.println(team1.name +"  " + teamScore1+" : " + teamScore2 + "  " + team2.name);
    }
}


