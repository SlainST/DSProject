package dsproject;


public class TeamLinkedList {
    
    public int totalTeamNumber = 0;
    
    public TeamNode head = null; 
    
    public BinarySearchTree bstTeams= new BinarySearchTree();
    
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
        bstTeams.insert(team.teamIDtoInt);
        
        totalTeamNumber++;
    }
    public void Displayteam(Team team){
        TeamNode current = head;
        while (current != null){
            System.out.print(current.team + "__");
            current = current.next;
        }
        System.out.println("____Bitiş");
    }
}
