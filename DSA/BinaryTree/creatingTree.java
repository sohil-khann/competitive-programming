// package DSA.BinaryTree;
package BinaryTree;

public class creatingTree {
    
   public class Node{
        int val;
        Node left;
        Node right;
      public  Node(int val){
this.val=val;
        }
    }
    
    public static void display(Node rooNode){

        System.out.print(rooNode.val+"-->");
       if (rooNode.left!=null) {
        System.out.print(rooNode.left.val+"-->");
       } 
       if (rooNode.right!=null) {
        System.out.print(rooNode.right.val+"-->");
       }
        
        System.out.println();
        display(rooNode.left);
        display(rooNode.right);
            
        
        
    }
public static void main(String[] args) {
    creatingTree tree = new creatingTree();
    Node rootNode = tree.new Node(2);
    Node a = tree.new Node(4);
    Node b = tree.new Node(10);
    rootNode.left=a;
    rootNode.right=b;
    
    Node al = tree.new Node(6);
    Node ar = tree.new Node(5);
    a.left=al;
    a.right=ar;
   
    Node br = tree.new Node(11);
    b.right=br;
display(rootNode);
}
}
