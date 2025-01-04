/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

/**
 *
 * @author slainst
 */
public class QueueMatches {
    Team[] ScheduleMatch;
    int size;
    int front;
    int rear;
    public QueueMatches(int size){
        this.size = size;
        ScheduleMatch = new Team[size];
        front = 0;
        rear = -1;
    }
    
    public boolean isFull(){
        return (rear == size -1);
    }
    
    public boolean isEmpty(){
        return rear == -1;
    }
    
    public void EnQueue(Team willPlay){
        if (isFull() == true){
            System.out.println("Maç Takvimi Dolu...");
        }else{
            rear++;
            ScheduleMatch[rear] = willPlay;
        }
        
    }
    public Team Dequeue(){
        Team newPlayedMatch;
        if(rear==-1){
            System.out.println("Oynanacak Maç Yok...");
        }
        
             newPlayedMatch= ScheduleMatch[front];
            for (int i = 1;i<=rear; i++){
                ScheduleMatch[i-1] = ScheduleMatch[i];
            
            
        }
            rear--;
            System.out.println(newPlayedMatch.name + " maçı oynandı...");
        return newPlayedMatch;
        
    }
    
}
