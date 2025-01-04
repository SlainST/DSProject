/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

public class BSTNodeForTeams {
    
    Team team;
    int data;
    BSTNodeForTeams left;
    BSTNodeForTeams right;
    
    public BSTNodeForTeams(Team teamm){
        this.data = teamm.teamIDtoInt;
        team= teamm;
    }
    
}