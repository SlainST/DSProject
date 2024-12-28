/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

/**
 *
 * @author slainst
 */
public class StackMatchHistory {
    Match PlayedGamesHistory[];
    int size;
    int indis;
    public StackMatchHistory(int size){
        this.size = size;
        PlayedGamesHistory = new Match[size];
        indis = -1;
    }
    public boolean isEmpty(){
        return indis == -1;
    }
    public boolean isFull(){
        return (indis == size - 1);
    }
    public void PushToMatchHistory(Match match){
        if (isFull() == true){
            System.out.println("Daha fazla maç oynanamaz...");
        }
        else{
        indis ++;
        PlayedGamesHistory[indis] = match;
        System.out.println("Push(): " + PlayedGamesHistory[indis]);
        }
    }
    public void PopTheMatch(){
        if (isEmpty() == true){
            System.out.println("Bu takım daha önce maç oynamamış...");
        }
        else{
            System.out.println(PlayedGamesHistory[indis]);
            indis--;
        }
    }
}
