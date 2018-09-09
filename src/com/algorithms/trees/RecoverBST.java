package com.algorithms.trees;

public class RecoverBST
{
   static class TreeNode
   {
        TreeNode left;
        TreeNode right;
        int val;
         
        public TreeNode(int x)
        {
            this.val = x;
        }
   }
 
    TreeNode firstStartPoint, lastEndPoint;
    TreeNode prevNode;
 
    public void findSegments(TreeNode root) 
    {
        if (root == null) return;
         
        findSegments (root.left);
         
        if (prevNode != null) 
        {
            if (prevNode.val   >  root.val) 
            {
                if (firstStartPoint == null)
                {
                    firstStartPoint = prevNode;
                }
                lastEndPoint = root;
             }
        }
        prevNode = root;
         
        findSegments (root.right);   
   }
     
   public void recoverTree(TreeNode root) 
   {
       findSegments(root);
       int x = firstStartPoint.val;
       firstStartPoint.val = lastEndPoint.val;
       lastEndPoint.val = x;
   }
 
   public void printInOrder(TreeNode root)
   {
       if (root == null) return;
            
       printInOrder(root.left);
       System.out.println(root.val);
       printInOrder(root.right);
   }
    
   public static void main(String[] args)
   {
       TreeNode root = new TreeNode(10);
       TreeNode n15   = new TreeNode(15);
       TreeNode n25   = new TreeNode(25);
       TreeNode n4   = new TreeNode(4);
       TreeNode n8   = new TreeNode(8);
       TreeNode n30   = new TreeNode(30);
       TreeNode n6   = new TreeNode(6);
        
       root.left  = n15;
       root.right = n25;
        
       n15.left  = n4;
       n15.right = n8;
        
       n25.left  = n6;
       n25.right = n30;
        
       RecoverBST solution = new RecoverBST();
        
       System.out.println("In-Order traversal of BST before recovery: ");
       solution.printInOrder(root);
 
       solution.recoverTree(root);
        
       System.out.println("In-Order traversal of BST after recovery: ");
       solution.printInOrder(root);
   }
}
        