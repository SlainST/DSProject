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
    }
}
