package dsproject;

import java.util.Random;

class Team extends TeamLinkedList {
    
    String name;
    String teamID;
    PlayerLinkedList players= new PlayerLinkedList();
    int totalPoint;
    int goalDifference;
    int PlayedGame = 0;
    int TeamMemberCount;
    int teamIDtoInt;
    
    
    //PlayerLinkedList playersMain= new PlayerLinkedList();
    
    public BinarySearchTreeForPlayers thisTeamsBST= new BinarySearchTreeForPlayers();
    
    boolean HasAKeeper;
    
    
    public Team(String teamID,String name){
        
        this.name = name;
        this.teamID = teamID;
        this.players = new PlayerLinkedList(); 
        this.totalPoint = 0;
        this.goalDifference = 0;
        this.teamIDtoInt = IDConverterToInt(teamID);
    }
    
    public void PlayerToTeam(Player player){
         players.AddPlayer(player);
         if(player.position==0){
             this.HasAKeeper=true;
         }
         thisTeamsBST.insertRecursive(player);
         TeamMemberCount++;
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
    
    public final int IDConverterToInt(String teamID){
        String convert = (int) teamID.charAt(0) + "" + (int) teamID.charAt(1);
        this.teamIDtoInt = Integer.parseInt(convert);
        return teamIDtoInt;
    }
    
    //how many will be added
    public Player CreateNewRandomPlayer(int position){
        String[] names = new String[] {
        "Alexander", "Benjamin", "William", "James", "Henry", "Daniel", "Matthew", "Ethan", "Michael", 
        "Jacob", "David", "Samuel", "Joseph", "Elijah", "Lucas", "Oliver", "Caleb", "Jackson", "Logan", 
        "Nathan", "Thomas", "Liam", "Gabriel", "Leo", "Daniel", "Jack", "Isaac", "Samuel", "Andrew", "Ryan", 
        "Joshua", "Matthew", "David", "Henry", "Sebastian", "Owen", "Daniel", "Christopher", "Landon", 
        "Isaiah", "Benjamin", "Caleb", "Jack", "Nolan", "Gabriel", "Adam", "Christian", "Matthew", "Nicholas", 
        "Levi", "Eli", "Finn", "Miles", "Jaxon", "Samuel", "Cameron", "Oliver", "Evan", "Elijah", "Ronan", 
        "Asher", "Jace", "Mason", "Xander", "Zachary", "Luke", "Joshua", "Blake", "Eli", "Aaron", "Leo", 
        "Toby", "Joshua", "Zane", "Jasper", "Maxwell", "Victor", "Carter", "Reed", "Dominic", "Charlie", 
        "Theo", "Arthur", "Miles", "Seth", "Cole", "Harrison", "Graham", "Bennett", "Felix", "Grant", 
        "Sawyer", "Jude", "Wesley", "Hudson", "Brock", "Dean", "Hunter", "Wyatt", "Jude", "Everett", 
        "Blaise", "Sullivan", "Riley", "Gage", "Dylan", "Ryder", "Brady", "Colton", "Chance", "Aidan", 
        "Gavin", "Milo", "Jeremiah"
        };

            String[] surnames = new String[] {
        "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", 
        "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", 
        "Martinez", "Roberts", "Clark", "Rodriguez", "Lewis", "Walker", "Allen", "Young", "Hernandez", 
        "King", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", 
        "Robinson", "Turner", "Evans", "Torres", "Wright", "Sanchez", "Hill", "Collins", "Stewart", 
        "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey", "Rivera", "Cooper", 
        "Richardson", "Howard", "Ward", "Flores", "Gomez", "James", "Bryant", "Alexander", "Hamilton", 
        "Graham", "Sullivan", "Wallace", "Wood", "Cole", "West", "Jordan", "Coleman", "Kelly", "Jenkins", 
        "Perry", "Powell", "Long", "Patterson", "Hughes", "Foster", "Sanders", "Bryan", "Ross", "Peterson", 
        "Gray", "Jameson", "Bennett", "Woodward", "Bowman", "Chavez", "Daniels", "Kelley", "Simmons", 
        "Fisher", "Wagner", "Arnold", "Carroll", "Strickland", "Curtis", "Snyder", "Cameron", "Craig", 
        "Patton", "Mendoza", "Barnes", "Henderson", "Bryan", "Holmes", "Gibson", "Duncan", "Spencer", 
        "Daniels", "Morales", "Fowler", "Bishop", "Schmidt", "Lynch", "Bates", "Ferguson", "Wells", 
        "Carlson", "Webb", "Schneider", "Page", "Davidson", "Harrison", "Griffin", "Richards", "Brock", 
        "Wolf", "Sandoval", "Barker", "Holland", "Stanley", "Mason", "Cameron", "Curtis", "Davis", "Vasquez"
        };
        Player newPlayer = new Player(names[new Random().nextInt(names.length)],surnames[new Random().nextInt(surnames.length)],position);
        players.AddPlayer(newPlayer);
        return newPlayer;
    }
    
}
