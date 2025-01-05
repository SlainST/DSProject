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
    Team[] myHashArrayForID= new Team[size];
    Team[] myHashArrayForNames= new Team[size];
    
    public HashMapTeam(Team team){
        int a= ((int) Math.pow(team.teamIDtoInt,3))*17*11*13%size;
        int b;
        
        try {
             b= ((int) Math.pow((int)team.name.charAt(0)*(int)team.name.charAt(1)*(int)team.name.charAt(5),3)*17*11+(int)team.name.charAt(2)*13)%this.size;
            System.out.println("aaa");
        } catch (StringIndexOutOfBoundsException e) {
            b= ((int) Math.pow((int)team.name.charAt(0),3)*17*11+(int)team.name.charAt(0)*13)%this.size;
            System.out.println("bbbb");
        }        
        myHashArrayForID[a]=team;
        myHashArrayForNames[b]=team;

        //PlayerLinkedListWillBeAddedToResolveConflicts.
    }
    public void HashMapSizeChange(int HashMapSize){
        this.size=HashMapSize;
        Team[] newHashMap= new Team[HashMapSize];
        Team[] newwHashMap= new Team[HashMapSize];
        
        for(int i=0; i<myHashArrayForID.length; i++){
            
            int b;
            if(myHashArrayForID[i]!=null){
                int a= ((int) Math.pow(myHashArrayForID[i].teamIDtoInt,3))*17*11*13%HashMapSize;
                try {
                    b= ((int) Math.pow((int)myHashArrayForNames[i].name.charAt(0)*(int)myHashArrayForNames[i].name.charAt(1)*(int)myHashArrayForNames[i].name.charAt(5),3))*17*11+(int)myHashArrayForNames[i].name.charAt(2)*13%this.size;
                } catch (StringIndexOutOfBoundsException e) {
                    b= ((int) Math.pow((int)myHashArrayForNames[i].name.charAt(0),3)*17*11+(int)myHashArrayForNames[i].name.charAt(0)*13%this.size);
                }
                
                while(newHashMap[a]!=null){
                    a++;
                    if(a>=size)
                        a=0;
                }
                
                while(newHashMap[b]!=null){
                    b++;
                    if(b>=size)
                        b=0;
                }
                
                newHashMap[a]=myHashArrayForID[i];
                newwHashMap[b]=myHashArrayForNames[i];
            }
        }
        this.size=HashMapSize;
        this.myHashArrayForID=newHashMap;
        this.myHashArrayForNames=newwHashMap;
    }
    
    public Team findTeam(int TeamID){
        int a= ((int) Math.pow(TeamID,3))*17*11*13%this.size;
        int temp =a;
        while(myHashArrayForID[a].teamIDtoInt!=TeamID){
            a++;
            if(a>=size){
                a=0;
                if(a==temp){
                System.out.println("Player couldnt be found");
                return null;
                }
            }
            
        }
        return myHashArrayForID[a];
    }
    public Team findTeam(String teamName){
        int b;
        int temp;
        try {
            b= ((int) Math.pow((int)teamName.charAt(0)*(int)teamName.charAt(1)*(int)teamName.charAt(5),3)*17*11+(int)teamName.charAt(2)*13)%this.size;
            temp=b;
        } catch (StringIndexOutOfBoundsException e) {
            b= ((int) Math.pow((int)teamName.charAt(0),3)*17*11+(int)teamName.charAt(0)*13)%this.size;
            temp=b;
            System.out.println("dddd");
        }
        while(myHashArrayForNames[b].name!=teamName){
            b++;
            if(b>=size){
                b=0;
                if(b==temp){
                System.out.println("Player couldnt be found");
                return null;
                }
            }
            
        }
        
        return myHashArrayForNames[b];
    }
    
    
    public void addNewTeamToHashMap(Team team){
        int a= (((int) Math.pow(team.teamIDtoInt,3))*17*11*13)%size;
        int b;
        while(myHashArrayForID[a]!=null){
                    a++;
                    if(a>=size)
                        a=0;
                }
                 
        
        myHashArrayForID[a]=team;
        try {
            b= ((int) Math.pow((int)team.name.charAt(0)*(int)team.name.charAt(1)*(int)team.name.charAt(5),3)*17*11+(int)team.name.charAt(2)*13)%this.size;
        } catch (StringIndexOutOfBoundsException e) {
            b= ((int) Math.pow((int)team.name.charAt(0),3)*17*11+(int)team.name.charAt(0)*13)%this.size;
        }
       
        while(myHashArrayForNames[b]!=null){
            b++;
            if(b>=size)
                b=0;
        }
        
        myHashArrayForNames[b]=team;

        //PlayerLinkedListWillBeAddedToResolveConflicts.
    }

        

}
