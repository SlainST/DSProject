
package dsproject;

public class BinarySearchTree {
    
    BSTNode root;
    
    public BinarySearchTree(){
        root = null;
    }
    
    public void insert(int data){
        if(root == null){
            root = new BSTNode(data);
            return;
        }
        else{
            BSTNode current = root;
            BSTNode parent  = null;
            
            while(true){
                parent = current;
                if(current.data > data){
                    current = current.left;
                    if(current == null){
                      parent.left = new BSTNode(data);
                      return;
                    }
                }else if(current.data < data){
                    current = current.right;
                    if(current == null){
                        parent.right = new BSTNode(data);
                        return;
                    }
                } else{
                    return;
                }
                
            }
            
            
        }
    }
    public void insertRecursive(int newData){
        root = insertRecursive(root, newData);
    }
    public BSTNode insertRecursive(BSTNode root, int newData){
        if(root == null){
            return new BSTNode(newData);
        }else{
            if(root.data > newData){
                root.left = insertRecursive(root.left, newData);
            }else if(root.data < newData){
                root.right = insertRecursive(root.right, newData);
            }
            return root;
        }
    }

    


    public void deleteRecursive(int key){
        root = deleteRecursive(root, key);
    }
    public BSTNode deleteRecursive(BSTNode root,int key){
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
    public int minValue(BSTNode root){
        int min = root.data;
        
        while(root.left != null){
            root = root.left;
            min = root.data;
        }
        return min;
    }
    
    
    public void printInorder(BSTNode root){
        
        if(root != null){
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);    
        }
        
    }
    public void printPreorder(BSTNode root){
        
        if(root != null){
            System.out.print(root.data + " ");
            printInorder(root.left);
            printInorder(root.right);    
        }
        
    }
    public void printPostorder(BSTNode root){
        
        if(root != null){
            printInorder(root.left);
            printInorder(root.right);
            System.out.print(root.data + " ");
        }
        
    }
    
}