package BinaryTree;

public class BinaryTree
{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d)
        {
            data=d;
            left=null;
            right=null;
        }
    }
    static int index=-1;
    static Node builtTree(int[] nodes)
    {
        if(index==nodes.length-1)
        return null;
        index++;
        if(nodes[index]==-1)
        return null;
        
        Node newNode=new Node(nodes[index]);
        newNode.left=builtTree(nodes);
         newNode.right=builtTree(nodes);
        return newNode;
    }
    static int heightTree(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int l=heightTree(root.left);
         int r=heightTree(root.right);
         return Math.max(l,r)+1;
        
    }
    static void printparentNode(Node root)
    {
        if(root==null)
        {
            return;
        }
        if(root.left!=null ||root.right!=null)
        System.out.println(root.data);
        printparentNode(root.left);
        printparentNode(root.right);
    }
     static void siblingNode(Node root)
    { if(root==null)
        {
            return;
        }
        if(root.left!=null && root.right!=null)
        System.out.println(root.left.data+" "+root.right.data);
        siblingNode(root.left);
        siblingNode(root.right);
    }
     static void printleafNode(Node root)
    { if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        System.out.println(root.data);
        printleafNode(root.left);
        printleafNode(root.right);
    }
    
    static int countNode(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int l=countNode(root.left);
         int r=countNode(root.right);
         return l+r+1;
        
    }
     static int sumTree(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int l=sumTree(root.left);
         int r=sumTree(root.right);
         return l+r+root.data;
        
    }
  static boolean searchNode( Node root, int key) 
{ 
    if (root == null) 
        return false; 
 
    if (root.data == key) 
        return true; 
 
    boolean r1 = searchNode(root.left, key); 
   
     if(r1) return true; 
 
       boolean r2 = searchNode(root.right, key); 
 
    return r2; 
}  

    static void preorder(Node root)
    {
        if(root==null)
        return;
        System.out.print(root.data+" ");
        preorder(root.left); 
        preorder(root.right);
    }
     static void inorder(Node root)
    {
        if(root==null)
        return ;
       
        inorder(root.left);
         System.out.print(root.data+" ");
        inorder(root.right);
    }
    
     static void postorder(Node root)
    {
        if(root==null)
        return;
       
        postorder(root.left);
        postorder(root.right);
         System.out.print(root.data+" ");
    }
	public static void main(String[] args) {
	    BinaryTree tree=new BinaryTree();
	    int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
	    Node root=tree.builtTree(nodes);
	    System.out.println("preorder is");
	    preorder(root);
	    System.out.println();
	    System.out.println("inorder is");
	    inorder(root);
	    System.out.println();
	    System.out.println("postorder is");
	    postorder(root);
	    System.out.println();
	    System.out.println("Height is "+heightTree(root));
	    System.out.println();
	    System.out.println("sum is "+sumTree(root));
	    System.out.println();
	    System.out.println("total nodes is "+countNode(root));
	       System.out.println();
	    System.out.println("parents nodes are ");
	    printparentNode(root);
	        System.out.println();
	    System.out.println("leaf nodes are ");
	    printleafNode(root);
	     System.out.println();
	    System.out.println("Siblings nodes are ");
	    siblingNode(root);
                  System.out.println("search elements ");
	    boolean k=searchNode(root,30);
	    if(k)
	    System.out.println(" found");
	    else
	    System.out.println("element is  not found ");
	  }
}
