package dsproject;

import java.util.Random;
import java.util.Scanner;

public class Player {
    // name, specific ID ,position, goal score
    
    String name;
    String surname;
    int playerID;
    int position;
    int goalScore;
    

    Scanner scanner = new Scanner(System.in);
    // Player Addition
    public Player(String nameString,String surnameString,int position){
        this.name = name.substring(0,1).toUpperCase() + name.substring(1);
        this.surname = surname.substring(0,1).toUpperCase() + surname.substring(1);
        while (position < 0 || position >= 4 ){
            System.out.println("Geçersiz Pozisyon");
            System.out.println("Geçerli pozisyon Giriniz:\n0: Kaleci\n1: Defans\n2: Orta Saha\n3: Forvet");
            position =  scanner.nextInt();
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
        System.out.println("Adı: " + player.name);
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
    }
    
    
    
    
}
