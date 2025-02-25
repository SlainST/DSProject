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
         player.whichTeam=this;
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
        "Hasan","Serhat","Taşkın","Eymen","Mustafa","Yusuf","Berk","Hüseyin","Batuhan",
            "Egemen","Efe","Tuğrul","Tuna","Ali","Emre","Furkan","Barış","Soydan",
            "Muhammet","Ahmet","Hikmet","Abdülkerim","Ozan","Rasim","Burak","Ersin",
            "Mert","Göktuğ","Emir","Tayyip","Onur","Talha","Arda","Emirhan","Necip",
            "Salih","Fahri","Kerem","Kemal","Yakup","Serkan","Emre Can","Can","Semih",
            "Erhan","İrfan Can","Osman","Çağlar","Levent","Samet","Recep","Cengiz",
            "Hakan","Sedat","İsmail","Bartuğ","Cenk","Oğuz","Sercan","Hamit","Günay",
            "Atakan","Metehan","Kaan","Eyüp","Berkan","Esat","Oktay","Berke","Gökdeniz",
            "Yunus","Acun","Baturalp","Baturay","Alp","Aras","Bahadır","Barbaros","Rauf",
            "Bilgehan","Bora","Buğra","Ensar","Çağan","Bülent","Erdem","Ertem","Şener","Atıl"
            
            };

            String[] surnames = new String[] {
        "Çelik","Tufan","Kuş","Karahan","Yılmaz","Barış","Altay","Sade","Yangıncı",
                "Turan","Tosun","Kaan","Karagülle","Atay","Çıra","Bölükbaşı","Alper",
                "Zengin","Kökçür","Kökçü","Kumsavuran","Erdoğan","Yavaş","Alptekin",
                "Bardakçı","Kütahyalı","Öztürk","Türk","Bektaş","Şengül","Uysal","Ata",
                "Koru","Korutürk","Aktürkoğlu","ÖZtemel","Osmanoğlu","Cura","Ozan","Şen",
                "İpek","Ünder","Kahveci","Kızıl","Söğüncü","Ertuna","Lor","Bozca","Ergün",
                "Altun","Peker","Yılkı","Yasin","Torun","Kurul","Özyakup","Altıntop","Gök",
                "Özyurt","Hancı","Kazgan","Tuncer","Berkant","Yıdıran","Genç","Sağcan","Gül",
                "Akgün","Ilıcalı","Tekin","Anar","Sergü","Bulut","Akman","Kaptan","Faik",
                "Bilge","Emir","Kum","Sansar","Irmak","Ecevit","Güngör","Sıdan","Keser","Gün",
                "Burgu","Ataç","Deniz","Korkmaz","Gülmez","Sever","Samancıoğlu"
        };
        Player newPlayer = new Player(names[new Random().nextInt(names.length)],surnames[new Random().nextInt(surnames.length)],position);
        players.AddPlayer(newPlayer);
        return newPlayer;
    }
    
}
