
package dsproject;

public class BinarySearchTreeForTeams {
    
    BSTNodeForTeams root;
    
    public BinarySearchTreeForTeams(){
        root = null;
    }
    
    public void insert(Team team){
        if(root == null){
            root = new BSTNodeForTeams(team);
            return;
        }
        else{
            BSTNodeForTeams current = root;
            BSTNodeForTeams parent  = null;
            
            while(true){
                parent = current;
                if(current.data > team.teamIDtoInt){
                    current = current.left;
                    if(current == null){
                      parent.left = new BSTNodeForTeams(team);
                      return;
                    }
                }else if(current.data < team.teamIDtoInt){
                    current = current.right;
                    if(current == null){
                        parent.right = new BSTNodeForTeams(team);
                        return;
                    }
                } else{
                    return;
                }
                
            }
            
            
        }
    }
    public void insertRecursive(Team newData){
        root = insertRecursive(root, newData,0);
    }
    public BSTNodeForTeams insertRecursive(BSTNodeForTeams root, Team newData, int j){
        int i=j;
        if(root == null){
            return new BSTNodeForTeams(newData);
        }else{
            if(root.data > newData.teamIDtoInt){
                root.left = insertRecursive(root.left, newData,i);
            }else if(root.data < newData.teamIDtoInt){
                root.right = insertRecursive(root.right, newData,i);
            }
            else if(root.data > newData.teamIDtoInt){
                i++;
                root.left = insertRecursive(root.left, newData,i);
            
            }
            return root;
        }
    }
    


    public void deleteRecursive(int key){
        root = deleteRecursive(root, key);
    }
    public BSTNodeForTeams deleteRecursive(BSTNodeForTeams root,int key){
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
    public int minValue(BSTNodeForTeams root){
        int min = root.data;
        
        while(root.left != null){
            root = root.left;
            min = root.data;
        }
        return min;
    }
    
    
    public void printInorder(BSTNodeForTeams root){
        
        if(root != null){
            printInorder(root.left);
            System.out.println(root.team.name+" ");
            printInorder(root.right);    
        }
        
    }
    public void printPreorder(BSTNodeForTeams root){
        
        if(root != null){
            System.out.println(root.team.name+" ");
            printPreorder(root.left);
            printPreorder(root.right);    
        }
        
    }
    public void printPostorder(BSTNodeForTeams root){
        
        if(root != null){
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.println(root.team.name+" ");
        }
        
    }
    
}