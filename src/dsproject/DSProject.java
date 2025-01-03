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
        Team CBUS=new Team("CBU");
        HashMapTeam teamHashMap= new HashMapTeam(CBUS);
        HashMapPlayer playerHashMap= new HashMapPlayer(Taskin);
                
        FootballLeague league= new FootballLeague(playerHashMap, teamHashMap);
        league.teams.Addteam(CBUS);
        
        league.registerPlayerToHashMap(Hasan,CBUS);
        league.registerPlayerToHashMap(Serhat, CBUS);
        
        league.registerPlayerToHashMap(CBUS.CreateNewRandomPlayer(1),CBUS);
        league.registerPlayerToHashMap(CBUS.CreateNewRandomPlayer(1),CBUS);
        
        league.registerPlayerToHashMap(CBUS.CreateNewRandomPlayer(2),CBUS);
        league.registerPlayerToHashMap(CBUS.CreateNewRandomPlayer(2),CBUS);
        league.registerPlayerToHashMap(CBUS.CreateNewRandomPlayer(2),CBUS);
        
        league.registerPlayerToHashMap(CBUS.CreateNewRandomPlayer(3),CBUS);
        league.registerPlayerToHashMap(CBUS.CreateNewRandomPlayer(3),CBUS);
        league.registerPlayerToHashMap(CBUS.CreateNewRandomPlayer(3),CBUS);
        
        
        league.CreateNewRandomTeam(14);
        System.out.println(""+league.teamHashMap.findTeam("CBU").teamID+ ", "+ league.teamHashMap.findTeam("CBU").TeamMemberCount);
        
        
    }
    
}
