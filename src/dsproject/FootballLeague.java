/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

import java.util.Random;

/**
 *
 * @author slainst
 */
public class FootballLeague {
    HashMapPlayer playerHashMap;
    HashMapTeam teamHashMap;
    StackMatchHistory stackMatchHistory=new StackMatchHistory(56);
    QueueMatches queueMatches= new QueueMatches(56);              //****Bunları her takımı oluşturduğumuzda takımlar için teker teker atamak daha mantıklı    
    TeamLinkedList teams= new TeamLinkedList();

    
    
    int teamCountOnLeague=0;
    
    HeapTreeForTeams heapTeams = new HeapTreeForTeams(512);
    HeapTreeForPlayers heapPlayers = new HeapTreeForPlayers(512);
    
    public FootballLeague(HashMapPlayer playerHashmap, HashMapTeam teamHashmap){
        this.playerHashMap=playerHashmap;
        this.teamHashMap=teamHashmap;
        
    }
    public void AddTeamToLeague(Team newteam){
        teams.Addteam(newteam);
        teamHashMap.addNewTeamToHashMap(newteam);
        
        teamCountOnLeague++;
        heapTeams = new HeapTreeForTeams(teamCountOnLeague);
        stackMatchHistoryChange();
    }
    
    public void PlayMatch(Team team1, Team team2){
       
        
        Match match= new Match(team1, team2);
        match.MatchSimulate();
        heapTeams = new HeapTreeForTeams(512);
        heapPlayers = new HeapTreeForPlayers(512);

       
       TeamNode current=teams.head;
       while(current!=null){
           heapTeams.insert(current.team);
           PlayerNode currentPlayer= current.team.players.head;
           while(currentPlayer!=null){
               heapPlayers.insert(currentPlayer.player);
               currentPlayer=currentPlayer.next;
           }
           current=current.next;
       }

        //System.out.println(team1.name+": "+match.teamScore1+" - "+team2.name+": "+match.teamScore2 );
       
    }
    
    public void stackMatchHistoryChange(){
        int n=teamCountOnLeague;
        int k=2;
        int result;
        if (k > n) {
            System.out.println("we need more than 2 teams to set a league");
        }
        k = Math.min(k, n - k);
        result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }
        
        stackMatchHistory= new StackMatchHistory(result);
        
    }
    public void registerPlayerToHashMap(Player player, Team whichTeamToRegister){
        TeamNode current =teams.head;
        boolean teamfound=false;
        while(current!=null){
            if(whichTeamToRegister.name.equals(current.team.name)){
                teamfound=true;
                playerHashMap.addNewPlayerToHashMap(player);
                current.team.PlayerToTeam(player);
            }
            current=current.next;
        }
        if(teamfound==false){
            System.out.println("couldnt find team to add");
        }
    }
    
    
    
    
    
    public Team CreateNewRandomTeam(String TeamID,String name,int howManyMember){
        
//        TeamNode current=teams.head;
//        String RandomNameResult= RandomTeamsNames[new Random().nextInt(RandomTeamsNames.length)];
//        while(current!=null){
//            if(current.team.name==RandomNameResult){
//                //teams.Addteam(new Team(RandomTeamsNames[new Random().nextInt(RandomTeamsNames.length)]));
//                current=teams.head;
//                RandomNameResult= RandomTeamsNames[new Random().nextInt(RandomTeamsNames.length)];}
//            current=current.next;
//        }
        Team willAddedTeam=new Team(TeamID,name);
        teams.Addteam(willAddedTeam);
        
        
        this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(0),willAddedTeam);
        this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(1),willAddedTeam);
        this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(2),willAddedTeam);
        this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(3),willAddedTeam);
        for(int i=0;i<howManyMember-4;i++){
            this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(new Random().nextInt(1,4)),willAddedTeam);
        }
        
        return willAddedTeam;
        
        
    }
    
    void ArrangeMatches(){
        TeamNode team1Current=teams.head;
        TeamNode team2Current=teams.head.next;
        
        while(team1Current!=null){
            
            team2Current=team1Current.next;
            while(team2Current!=null){
                if(team1Current.team.teamIDtoInt==team2Current.team.teamIDtoInt){
                    team2Current= team2Current.next;
                }else{
                    queueMatches.EnQueue(team1Current.team);
                    queueMatches.EnQueue(team2Current.team);
                    
                }
                
                
                
                team2Current= team2Current.next;
            }
            team1Current= team1Current.next;
        }
    }
    
}
