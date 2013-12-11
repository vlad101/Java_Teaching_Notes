/**
 * The Binary Search Tree Implementation.
 * @author: Vladimir Efros
 * This program implements a Binary Search Tree.
 */

/**
 * A tree node representation.
 */
class Node
{
    public int value;
    public Node left;
    public Node right;
    
    /**
     * The constructor method initializes a node.
     * @param val Initializes the integer value of the tree.
     * @param l Initializes the left node.
     * @param r Initializes the right node.
     */
    public Node(int val, Node l, Node r)
    {
        value = val;
        left = l;
        right = r;
    }
    
     /**
     * The constructor method initializes a node.
     * @param val Initializes the integer value of the tree.
     */
    public Node(int val)
    {
        this(val, null, null);
    }
}

/**
 * A Binary Search Tree representation.
 */
class BinaryTree
{
    private Node root = null;
    
    /**
     * An inOrder method performs an inorder tree transversal.
     */
    public void inOrder()
    {
        inOrder(root);
    }
    
    /**
    * The inOrder method performs an inorder tree transversal.
    * @param bTree The nodes of the tree.
    */
    private void inOrder(Node bTree)
    {
        if(bTree != null)
        {
            inOrder(bTree.left);
            System.out.print(bTree.value + " ");
            inOrder(bTree.right);
        }
    }
    
    /**
     * The contains method searches Binary Search Tree.
     * @param val The value that is searched for.
     * @return true if the value is found, otherwise returns false.
     */
    public boolean contains(int val)
    {
        return contains(val, root);
    }
    
    /**
     * The contains method searches Binary Search Tree.
     * @param x The value that is searched for.
     * @param bTree The Nodes where the value will be searched.
     * @return true if the value is found, otherwise returns false.
     */
    private boolean contains(int x, Node bTree)
    {
        boolean temp = false;
        if(bTree == null)
            temp = false;
        else if(bTree.value == x)
            temp = true;
        else if(x < bTree.value)
            temp = contains(x, bTree.left);
        else
            temp = contains(x, bTree.right);
        return temp;
    }
    
    /**
     * The add method adds the value to the tree.
     * @param val The value that is to be added to the tree.
     * @return true when the value is added.
     */
    public boolean add(int val)
    {
        root = add(val, root);
        return true;
    }
    
    /**
     * The add method adds the value to the tree.
     * @param x The value that is to be added to the tree.
     * @param bTree The node where the value is added.
     * @return true if the value is added, otherwise return false.
     */
    private Node add(int x, Node bTree)
    {
        if(bTree == null)
            return new Node(x);
        else if(x < bTree.value)
            bTree.left = add(x, bTree.left);
        else
            bTree.right = add(x, bTree.right);
        return bTree;
    }
    
    public int find_height()
    {
        return find_height(root);
    }
    
    private int find_height(Node bTree)
    {
        if(bTree == null)
            return 0;
        else
            return 1 + Math.max(find_height(bTree.left), find_height(bTree.right));
    }
}

/**
 * Test Driver of the program.
 */
public class BinarySearchTreeImplementation 
{
    public static void main(String[] args)
    {
        // Create a new Binary Tree object.
        BinaryTree tree = new BinaryTree();
        
        // Add 3 values.
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(4);
        tree.add(0);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        
        // Display binary tree using inorder transversal
        tree.inOrder();
        System.out.println();
        
        System.out.println(tree.find_height());
    }
}