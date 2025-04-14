package BinaryTree;

public class binary_tree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d)
        {
            data=d;
            this.left=null;  //target particular node
            this.right=null;
        }
    }
    static int index=-1;
    static Node createTree(int[]nodes)
    {
        index++;
        if(index==nodes.length-1)
            return null;
        if(nodes[index]==-1)
            return null;
        Node newnode=new Node(nodes[index]);
        System.out.println(newnode.data);
        newnode.left=createTree(nodes);
        newnode.right=createTree(nodes);
        return newnode;
        
        
    }
    public static void main(String[] args) {
        int[] nodes= {1,2,4,-1,5,-1,-1,3,-1,6};
        Node root=createTree(nodes);

    }

}