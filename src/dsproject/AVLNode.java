/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

class AVLNode {
    Team team;
    int height;
    AVLNode left, right;

    AVLNode(Team team) {
        this.team = team;
        height = 1;
    }
}