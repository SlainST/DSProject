
package dsproject;


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
            System.out.println("Cant play more games...");
        }
        else{
        indis ++;
        PlayedGamesHistory[indis] = match;
      
        }
    }
    public Match PopTheMatch(){
        Match match;
        
            match=PlayedGamesHistory[indis];
            
            indis--;
        
        return match;
    }
}
