/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

/**
 *
 * @author slainst
 */
public class FootballLeague {
    HashMapPlayer playerHashMap;
    HashMapTeam teamHashMap;
    StackMatchHistory stackMatchHistory;
    QueueMatches queueMatches;
    
    TeamLinkedList teams;
    public FootballLeague(HashMapPlayer playerHashmap, HashMapTeam teamHashmap){
        this.playerHashMap=playerHashmap;
        this.teamHashMap=teamHashmap;
        
    }
    public void AddTeamToLeague(Team newteam){
        teams.Addteam(newteam);
        teamHashMap.addNewTeamToHashMap(newteam);
    }
    public void registerPlayerToHashMap(Player player, Team whichTeamToRegister){
        TeamNode current = teams.head;
        boolean teamfound=false;
        while(current.next!=null){
            if(whichTeamToRegister==current.team){
                teamfound=true;
                playerHashMap.addNewPlayerToHashMap(player);
                current.team.PlayerToTeam(player);
            }
            current=current.next;
        }
        if(teamfound=false){
            System.out.println("couldnt find team to add");
        }
    }
}
