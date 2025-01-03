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
    StackMatchHistory stackMatchHistory;
    QueueMatches queueMatches;              //****Bunları her takımı oluşturduğumuzda takımlar için teker teker atamak daha mantıklı    
    TeamLinkedList teams= new TeamLinkedList();

    int teamCountOnLeague=0;
    
    HeapTreeForTeams heapTeams = new HeapTreeForTeams(teamCountOnLeague);
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
       
       heapTeams = new HeapTreeForTeams(teamCountOnLeague);
       heapPlayers = new HeapTreeForPlayers(playerHashMap.size);
       
       TeamNode current=teams.head;
       while(current!=null){
           heapTeams.insert(current.team);
           current=current.next;
           PlayerNode currentPlayer= current.team.players.head;
           while(currentPlayer!=null){
               heapPlayers.insert(currentPlayer.player);
               currentPlayer=currentPlayer.next;
           }
       }
       
       
       
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
    
    
    
    
    
    public void CreateNewRandomTeam(int howManyMember){
        String[] RandomTeamsNames = {
        "Real Madrid", "Barcelona", "Manchester United", "Liverpool", "Bayern Munich", "Paris Saint-Germain", "Juventus", "Chelsea", "Arsenal", "Manchester City", 
        "AC Milan", "Inter Milan", "Tottenham Hotspur", "Atletico Madrid", "Borussia Dortmund", "Ajax", "Benfica", "Porto", "Roma", "Napoli", 
        "Boca Juniors", "River Plate", "Flamengo", "Palmeiras", "Santos", "Corinthians", "Internacional", "Gremio", "Atletico Mineiro", "São Paulo", 
        "Celtic", "Rangers", "Olympique Marseille", "Lyon", "Monaco", "Lille", "Sevilla", "Valencia", "Villarreal", "Real Betis", 
        "Schalke 04", "Bayer Leverkusen", "RB Leipzig", "Wolfsburg", "Eintracht Frankfurt", "Hertha Berlin", "Hamburg", "Werder Bremen", "Stuttgart", "Köln", 
        "Zenit Saint Petersburg", "CSKA Moscow", "Spartak Moscow", "Lokomotiv Moscow", "Shakhtar Donetsk", "Dynamo Kyiv", "Red Star Belgrade", "Partizan Belgrade", 
        "Galatasaray", "Fenerbahçe", "Besiktas", "Trabzonspor", "Al Ahly", "Zamalek", "Kaizer Chiefs", "Orlando Pirates", "Mamelodi Sundowns", "TP Mazembe", 
        "Urawa Red Diamonds", "Yokohama F. Marinos", "Kashima Antlers", "Guangzhou Evergrande", "Shanghai SIPG", "Beijing Guoan", "Al Hilal", "Al Nassr", 
        "Persepolis", "Esteghlal", "Sydney FC", "Melbourne Victory", "Auckland City", "Club America", "Chivas Guadalajara", "Cruz Azul", "Monterrey", "Tigres UANL", 
        "Barcelona SC", "Independiente del Valle", "Flamurtari", "Dinamo Tirana", "Rosenborg", "Molde", "Brondby", "FC Copenhagen", "Malmo FF", "AIK", 
        "Legia Warsaw", "Lech Poznan", "Slavia Prague", "Sparta Prague", "Red Bull Salzburg", "Rapid Vienna", "Basel", "Young Boys", "APOEL", "Olympiacos", 
        "Panathinaikos", "AEK Athens", "Anderlecht", "Club Brugge", "Standard Liege", "Dinamo Zagreb", "Hajduk Split", "Ferencvaros", "Maccabi Tel Aviv", "Hapoel Be'er Sheva"
        };
        TeamNode current=teams.head;
        String RandomNameResult= RandomTeamsNames[new Random().nextInt(RandomTeamsNames.length)];
        while(current!=null){
            if(current.team.name==RandomNameResult){
                //teams.Addteam(new Team(RandomTeamsNames[new Random().nextInt(RandomTeamsNames.length)]));
                current=teams.head;
                RandomNameResult= RandomTeamsNames[new Random().nextInt(RandomTeamsNames.length)];}
            current=current.next;
        }
        Team willAddedTeam=new Team(RandomNameResult);
        teams.Addteam(willAddedTeam);
        
        
        this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(0),willAddedTeam);
        this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(1),willAddedTeam);
        this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(2),willAddedTeam);
        this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(3),willAddedTeam);
        for(int i=0;i<howManyMember;i++){
            this.registerPlayerToHashMap(willAddedTeam.CreateNewRandomPlayer(new Random().nextInt(1,4)),willAddedTeam);
        }
        
        
        
        
    }
}
