package dsproject;

import java.util.Random;

public class Player {
    // name, specific ID ,position, goal score
    
    String name;
    String surname;
    int playerID;
    int position;
    int goalScore;
    
    Team whichTeam;
    

    // Player Addition
    public Player(String nameString,String surnameString,int position){
        this.name = nameString.substring(0,1).toUpperCase() + nameString.substring(1);
        this.surname = surnameString.substring(0,1).toUpperCase() + surnameString.substring(1);
        while (position < 0 || position >= 4 ){
            System.out.println("Geçersiz Pozisyon");
            System.out.println("Geçerli pozisyon Giriniz:\n0: Kaleci\n1: Defans\n2: Orta Saha\n3: Forvet");
            this.position =  position;
        }
        this.playerID=IDGenerator(this);
        this.position = position;
        this.goalScore = 0;
    }
    // Taşkın yapacak
    public int IDGenerator(Player player){
        Random random = new Random();
        this.playerID = random.nextInt(0,1000000000);
        return playerID;
    }
    
    
    //
    
    
    public void UpdateGoals(int goals){
        this.goalScore += goals;
    }
    
    
     public void WriteData(Player player){
        System.out.println("Oyuncu bilgileri:");
        System.out.println("Adı: " + player.name +" "+ player.surname);
        System.out.println("ID: " + player.playerID);
        System.out.print("Pozisyon: ");
        switch (player.position){
            case 0:
                System.out.println("Kaleci");
                break;
            case 1:
                System.out.println("Defans");
                break;
            case 2:
                System.out.println("Orta Saha");
                break;
            case 3:
                System.out.println("Forvet");
                break;
            default:
                System.out.println("yanlış pozisyon");
                break;
        }
        System.out.println("Attığı Gol Sayısı: " + player.goalScore);
    }
    
    
    
    
    
}
