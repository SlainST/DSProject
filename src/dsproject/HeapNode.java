package dsproject;

/**
 *
 * @author HASAN_WIN11
 */
public class HeapNode {
    HeapNode left;
    HeapNode right;
    Team team;

    public HeapNode(Team team){
        this.team = team;
        left = null;
        right = null;
    }
}
