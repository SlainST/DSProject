package dsproject;

public class PlayerLinkedList {
    
    
    public PlayerNode head = null; 
    
    public void AddPlayer(Player player){
        PlayerNode temp = new PlayerNode(player);
        if (head == null)
            head = temp;
        else{
            PlayerNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = temp;
        }
    }
    public void DisplayPlayer(Player player){
        PlayerNode current = head;
        while (current != null){
            System.out.print(current.player + "__");
            current = current.next;
        }
        System.out.println("____Bitiş");
    }
}
