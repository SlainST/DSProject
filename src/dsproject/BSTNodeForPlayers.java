/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

public class BSTNodeForPlayers {
    
    int data;
    Player player;
    BSTNodeForPlayers left;
    BSTNodeForPlayers right;
    
    public BSTNodeForPlayers(Player playerr){
        this.data = (int) playerr.name.charAt(0);
        this.player =playerr;
    }
    
}