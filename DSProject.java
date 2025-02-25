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
        Team team1=new Team("CBU","CBUFK");
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
        
        
        System.out.println("-------------");
        
        
        System.out.println(""+league.teamHashMap.findTeam("CBUFK").teamID+ ", "+ league.teamHashMap.findTeam("CBUFK").TeamMemberCount+" "+league.teamHashMap.findTeam("CBUFK").teamIDtoInt);
        System.out.println(""+team7.name+"   "+ team7.TeamMemberCount+" --- ");
        league.ArrangeMatches();
        System.out.println("--------------------\n");
        //league.PlayMatch(league.queueMatches.Dequeue(),league.queueMatches.Dequeue());
        
        
        
        Team removeMax;
        int j=0;
        int t =1;
        for(int i=0;i<28;i++){
            if(j==0){
                if (t == 7 ){
                System.out.println("\n\nLast WEEK");
                }
                System.out.println("\nWEEK"+t+ " MATCHES");
                j=4;
                t++;
            }
            league.PlayMatch(league.queueMatches.Dequeue(),league.queueMatches.Dequeue());
            removeMax= league.heapTeams.removeMax();
        while(removeMax!= null){
            System.out.println(""+removeMax.name+ "\t"+removeMax.totalPoint +"\t"+removeMax.goalDifference);
            removeMax = league.heapTeams.removeMax();
            if(league.heapTeams.size == 0){
                System.out.println(""+removeMax.name+ "\t"+removeMax.totalPoint +"\t"+removeMax.goalDifference);
                break;}
        }
        j--;
        }
        
        league.queueMatches.fixtureArrange();
        System.out.println("next match:" +league.queueMatches.fixtureDequeue().name+" - "+league.queueMatches.fixtureDequeue().name );
        
        System.out.println("---------------------\n");
       
        
        System.out.println("-------");
        
        System.out.println("---------------\n");
        league.teams.head.team.thisTeamsBST.printInorder(league.teams.head.team.thisTeamsBST.root);
        System.out.println("--------------------------------------");
        team2.thisTeamsBST.printInorder(team2.thisTeamsBST.root); //alphabetic order team player names bst
        System.out.println("-----------------");

        
        System.out.println("-----------------------------\n");
        Player best=league.heapPlayers.removeMax(1);
        System.out.println(best.whichTeam.name +": ");
        best.WriteData(best);
         System.out.println("-----------------------------\n");
        best=league.heapPlayers.removeMax(1);
        System.out.println(best.whichTeam.name +": ");
        best.WriteData(best);
 System.out.println("-----------------------------\n");
        best=league.heapPlayers.removeMax(1);
        System.out.println(best.whichTeam.name +": ");
        best.WriteData(best);

         System.out.println("-----------------------------\n");
        
        System.out.println("-------------------------");
        league.stackMatchHistory.PopTheMatch().MatchResult();  //last 3 Matches
        league.stackMatchHistory.PopTheMatch().MatchResult();
        league.stackMatchHistory.PopTheMatch().MatchResult();
        league.stackMatchHistory.PopTheMatch().MatchResult();

        System.out.println(league.playerHashMap.findPlayer(Taskin.playerID).name);
    } 

}
