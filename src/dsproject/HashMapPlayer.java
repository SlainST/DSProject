/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

/**
 *
 * @author slainst
 */
public class HashMapPlayer {
    int size=512;
    Player[] myHashArray= new Player[size];
    public HashMapPlayer(Player player){
        int a= ((int) Math.pow(player.playerID,3))*17*11*13%size;
        
        myHashArray[a]=player;

        //PlayerLinkedListWillBeAddedToResolveConflicts.
    }
    public void HashMapSizeChange(int HashMapSize){
        this.size=HashMapSize;
        Player[] newHashMap= new Player[HashMapSize];
        for(int i=0; i<myHashArray.length; i++){
            

            if(myHashArray[i]!=null){
                int a= ((int) Math.pow(myHashArray[i].playerID,3))*17*11*13%HashMapSize;
                while(newHashMap[a]!=null){
                    a++;
                    if(a>=size)
                        a=0;
                }   
                newHashMap[a]=myHashArray[i];
            }
        }
        this.size=HashMapSize;
        this.myHashArray=newHashMap;
    }
    
    public Player findPlayer(int playerId){
        int a= ((int) Math.pow(playerId,3))*17*11*13%this.size;
        int temp=a;
        while(myHashArray[a].playerID!=playerId){
            a++;
            if(a>=size){
                a=0;
                if(a==temp){
                System.out.println("Player couldnt be found");
                return null;
                }
            }
            
        }
        return myHashArray[a];
    }
    public void addNewPlayerToHashMap(Player player){
        int a= ((int) Math.pow(player.playerID,3))*17*11*13%size;
        while(myHashArray[a]!=null){
            a++;
            if(a>=size)
                a=0;
        }
        myHashArray[a]=player;

        //PlayerLinkedListWillBeAddedToResolveConflicts.
    }
}
