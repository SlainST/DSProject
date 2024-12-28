/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

/**
 *
 * @author slainst
 */
public class HashMapTeam {
    int size=512;
    Team[] myHashArray= new Team[size];
    public HashMapTeam(Team team){
        int a= ((int) Math.pow(team.teamID,3))*17*11*13%size;
        
        myHashArray[a]=team;

        //PlayerLinkedListWillBeAddedToResolveConflicts.
    }
    public void HashMapSizeChange(int HashMapSize){
        this.size=HashMapSize;
        Team[] newHashMap= new Team[HashMapSize];
        for(int i=0; i<myHashArray.length; i++){
            

            if(myHashArray[i]!=null){
                int a= ((int) Math.pow(myHashArray[i].teamID,3))*17*11*13%HashMapSize;

                newHashMap[a]=myHashArray[i];
            }
        }
        this.size=HashMapSize;
        this.myHashArray=newHashMap;
    }
    
    public Team findTeam(int playerId){
        int a= ((int) Math.pow(playerId,3))*17*11*13%this.size;
        
        return myHashArray[a];
    }
}
