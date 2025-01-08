package DSA.BinaryTree;
public class sumMaxSumheight  {
   public static int size=0;

    public class Node{
         int val;
         Node left;
         Node right;
       public  Node(int val){
 this.val=val;
         }
     }


     public static void preorder(Node rootNode){

       if(rootNode==null) return;
       
       System.out.print(rootNode.val+"-->");
     
        
        System.out.println();
        preorder(rootNode.left);
        preorder(rootNode.right);
            
        
        
    }
    public static int size(Node rootNode){
        if (rootNode==null) {
            return 0;
        }
        return 1+size(rootNode.left)+size(rootNode.right);
    }

public static void main(String[] args) {
    sumMaxSumheight tree = new sumMaxSumheight();
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
preorder(rootNode);
System.out.println("size : "+size(rootNode));

    
}


}
