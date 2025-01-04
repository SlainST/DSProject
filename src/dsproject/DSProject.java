package dsproject;

public class DSProject {
    
    public static void main(String[] args) {
        Player Taskin = new Player("taşkın","kuş",0);
        Taskin.WriteData(Taskin);
        Player Serhat = new Player("Serhat","tufan",1);
        Taskin.WriteData(Serhat);
        Player Hasan = new Player("Hasan","çelik",2);
        Taskin.WriteData(Hasan);
        
        
        //how will be used
        Team team1=new Team("CBU","CBU");
        HashMapTeam teamHashMap= new HashMapTeam(team1);
        HashMapPlayer playerHashMap= new HashMapPlayer(Taskin);
                
        FootballLeague league= new FootballLeague(playerHashMap, teamHashMap);
        league.teams.Addteam(team1);
        
        league.registerPlayerToHashMap(Hasan,team1);
        league.registerPlayerToHashMap(Serhat, team1);
        league.registerPlayerToHashMap(Taskin, team1);
        
        
        league.registerPlayerToHashMap(team1.CreateNewRandomPlayer(1),team1);
        league.registerPlayerToHashMap(team1.CreateNewRandomPlayer(1),team1);
        
        league.registerPlayerToHashMap(team1.CreateNewRandomPlayer(2),team1);
        league.registerPlayerToHashMap(team1.CreateNewRandomPlayer(2),team1);

        
        league.registerPlayerToHashMap(team1.CreateNewRandomPlayer(3),team1);
        league.registerPlayerToHashMap(team1.CreateNewRandomPlayer(3),team1);
        league.registerPlayerToHashMap(team1.CreateNewRandomPlayer(3),team1);
        league.registerPlayerToHashMap(team1.CreateNewRandomPlayer(0),team1);
        
        
        Team team2 = league.CreateNewRandomTeam("GS","Galatasaray",11);
        Team team3 =league.CreateNewRandomTeam("BJK","Beşiktaş",11);
        Team team4 =league.CreateNewRandomTeam("FB","Fenerbahçe",11);
        Team team5 =league.CreateNewRandomTeam("TS","Trabzonspor",11);
        Team team6 =league.CreateNewRandomTeam("GOZ","Göztepe",11);
        Team team7 =league.CreateNewRandomTeam("KON","Konyaspor",11);
        Team team8 =league.CreateNewRandomTeam("AFY","Afyonspor",11);
        
        
        System.out.println(""+league.teamHashMap.findTeam("CBU").teamID+ ", "+ league.teamHashMap.findTeam("CBU").TeamMemberCount);
        System.out.println(""+team7.name+"   "+ team7.TeamMemberCount+" --- "+league.teamHashMap.findTeam("CBU").teamIDtoInt);
        league.ArrangeMatches();
        System.out.println("--------------------");
        //league.PlayMatch(league.queueMatches.Dequeue(),league.queueMatches.Dequeue());
        for(int i=0;i<28;i++){
            league.PlayMatch(league.queueMatches.Dequeue(),league.queueMatches.Dequeue());
        } 
        System.out.println("-----------------------");
        Team deneme= league.heapTeams.removeMax();
        System.out.println(""+deneme.name+deneme.totalPoint);
        deneme= league.heapTeams.removeMax();
        System.out.println(""+deneme.name+deneme.totalPoint);
        deneme= league.heapTeams.removeMax();
        System.out.println(""+deneme.name+deneme.totalPoint);
        deneme= league.heapTeams.removeMax();
        System.out.println(""+deneme.name+deneme.totalPoint);
        deneme= league.heapTeams.removeMax();
        System.out.println(""+deneme.name+deneme.totalPoint);
        deneme= league.heapTeams.removeMax();
        System.out.println(""+deneme.name+deneme.totalPoint);
        deneme= league.heapTeams.removeMax();
        System.out.println(""+deneme.name+deneme.totalPoint);
        deneme= league.heapTeams.removeMax();
        System.out.println(""+deneme.name+deneme.totalPoint);
        
        
        league.teams.head.team.thisTeamsBST.printInorder(league.teams.head.team.thisTeamsBST.root);
        System.out.println("--------------------------------------");
        team2.thisTeamsBST.printInorder(team2.thisTeamsBST.root); //alphabetic order team player names
        System.out.println("-----------------");
        league.teams.bstTeams.printInorder(league.teams.bstTeams.root);//alphabeticOrder team names
        
        System.out.println("-----------------------------");
        Player best=league.heapPlayers.removeMax();
        System.out.println(best.name+ " total goal: "+ best.goalScore);
        
        best=league.heapPlayers.removeMax();
        System.out.println(best.name+ " total goal: "+ best.goalScore);
        
        best=league.heapPlayers.removeMax();
        System.out.println(best.name+ " total goal: "+ best.goalScore);
        
        System.out.println("-------------------------");
        
        league.stackMatchHistory.PopTheMatch().MatchResult();  //last 3 Matches
        league.stackMatchHistory.PopTheMatch().MatchResult();
        league.stackMatchHistory.PopTheMatch().MatchResult();
        
    } 

}
