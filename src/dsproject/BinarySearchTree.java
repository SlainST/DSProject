/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

/**
 *
 * @author slainst
 */
public class BinarySearchTree {
    
    Node root;
    
    public BinarySearchTree(){
        root = null;
    }
    
    public void insert(int data){
        if(root == null){
            root = new Node(data);
            return;
        }
        else{
            Node current = root;
            Node parent  = null;
            
            while(true){
                parent = current;
                if(current.data > data){
                    current = current.left;
                    if(current == null){
                      parent.left = new Node(data);
                      return;
                    }
                }else if(current.data < data){
                    current = current.right;
                    if(current == null){
                        parent.right = new Node(data);
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
    public Node insertRecursive(Node root, int newData){
        if(root == null){
            return new Node(newData);
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
    public Node deleteRecursive(Node root,int key){
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
    public int minValue(Node root){
        int min = root.data;
        
        while(root.left != null){
            root = root.left;
            min = root.data;
        }
        return min;
    }
    
    
    public void printInorder(Node root){
        
        if(root != null){
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);    
        }
        
    }
    public void printPreorder(Node root){
        
        if(root != null){
            System.out.print(root.data + " ");
            printInorder(root.left);
            printInorder(root.right);    
        }
        
    }
    public void printPostorder(Node root){
        
        if(root != null){
            printInorder(root.left);
            printInorder(root.right);
            System.out.print(root.data + " ");
        }
        
    }
    
}