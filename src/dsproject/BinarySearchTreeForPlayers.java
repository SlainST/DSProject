
package dsproject;

public class BinarySearchTreeForPlayers {
    
    BSTNodeForPlayers root;
    
    public BinarySearchTreeForPlayers(){
        root = null;
    }
    
    public void insert(Player player){
        if(root == null){
            root = new BSTNodeForPlayers(player);
            return;
        }
        else{
            BSTNodeForPlayers current = root;
            BSTNodeForPlayers parent  = null;
            
            while(true){
                parent = current;
                if(current.data > (int) player.name.charAt(0)){
                    current = current.left;
                    if(current == null){
                      parent.left = new BSTNodeForPlayers(player);
                      return;
                    }
                }else if(current.data < (int) player.name.charAt(0)){
                    current = current.right;
                    if(current == null){
                        parent.right = new BSTNodeForPlayers(player);
                        return;
                    }
                }
                else{
                    return;
                }
                
            }
            
            
        }
    }
    public void insertRecursive(Player newData){
        root = insertRecursive(root, newData,0);
    }
    public BSTNodeForPlayers insertRecursive(BSTNodeForPlayers root, Player newData,int j){
        int i=j;
        if(root == null){
            return new BSTNodeForPlayers(newData);
        }else{
            if(root.data > (int) newData.name.charAt(i)){
                root.left = insertRecursive(root.left, newData,i);
            }else if(root.data < (int) newData.name.charAt(i)){
                root.right = insertRecursive(root.right, newData,i);
            }
            else if(root.data == (int) newData.name.charAt(i)){
                i++;
                root.left = insertRecursive(root.left, newData,i);
            }
            return root;
        }
    }

    


    public void deleteRecursive(int key){
        root = deleteRecursive(root, key);
    }
    public BSTNodeForPlayers deleteRecursive(BSTNodeForPlayers root,int key){
        if(root == null){
            return null;
        }else if(root.data > key){
            root.left = deleteRecursive(root.left, key);
        }else if(root.data < key){
            root.right = deleteRecursive(root.right, key);
        }else{
            if(root.left == null){
                root = root.right;
            }else if(root.right == null){
                root = root.left;
            }else{
                root.data = minValue(root.right);
                root.right = deleteRecursive(root.right, root.data);
            }
 
        }
        return root;
    }
    public int minValue(BSTNodeForPlayers root){
        int min = root.data;
        
        while(root.left != null){
            root = root.left;
            min = root.data;
        }
        return min;
    }
    
    
    public void printInorder(BSTNodeForPlayers root){
        
        if(root != null){
            printInorder(root.left);
            System.out.println(root.player.name+" "+root.player.surname);
            printInorder(root.right);    
        }
        
    }
    public void printPreorder(BSTNodeForPlayers root){
        
        if(root != null){
            System.out.println(root.player.name+" "+root.player.surname);
            printPreorder(root.left);
            printPreorder(root.right);    
        }
        
    }
    public void printPostorder(BSTNodeForPlayers root){
        
        if(root != null){
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.println(root.player.name+" "+root.player.surname);
        }
        
    }
    
}