package dsproject;


public class TeamLinkedList {
    
    public int totalTeamNumber = 0;
    
    public TeamNode head = null; 
    
    public BinarySearchTreeForTeams bstTeams= new BinarySearchTreeForTeams();
    
    public void Addteam(Team team){
        TeamNode temp = new TeamNode(team);
        if (head == null)
            head = temp;
        else{
            TeamNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = temp;
        }
        bstTeams.insertRecursive(team);
        
        totalTeamNumber++;
    }
    public void Displayteam(Team team){
        TeamNode current = head;
        while (current != null){
            System.out.print(current.team + "__");
            current = current.next;
        }
        
    }
    public Team getTeam(int teamsPlace) {
        if (teamsPlace < 0 || teamsPlace >= totalTeamNumber) {
            System.out.println("There is not that much teams : " + teamsPlace);
            return null;
        }
    TeamNode current = head;
        int index = 0;
        while (current != null) {
            if (index == teamsPlace) {
                return current.team;
            }
            current = current.next;
            index++;
        }
        
        return null; 
    }
    
    
    public TeamNode removeLast() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
           
            TeamNode temp = head;
            head = null;
            totalTeamNumber--;
            return temp;
        }

        TeamNode current = head;
        while (current.next.next != null) {
            current = current.next; 
        }

        TeamNode temp = current.next; 
        current.next = null; 
        totalTeamNumber--;
        return temp; 
    }
    
    
    
    
        public void addAt(int index, TeamNode node) {
        if (index < 0 || index > totalTeamNumber) {
            return;
        }

        if (index == 0) {
   
            node.next = head;
            head = node;
        } else {
       
            TeamNode current = head;
            int currentIndex = 0;
            while (currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }
      
            node.next = current.next;
            current.next = node;
        }
        totalTeamNumber++;
    }
}
