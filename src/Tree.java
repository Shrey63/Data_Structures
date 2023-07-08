


import java.util.Scanner;
import java.util.Stack;

class Node
{
    int e;
    Node left;
    Node right;
    Node(int v)
    {
        left=null;
        right=null;
        e=v;
    }
}
public class Tree {
    static Node root;
    Tree()
    {
    }
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
    Tree t=new Tree();
    t.insert();
    System.out.println("Preorder");
    t.preorder(root);
    System.out.println("Inorder");
    t.inorder(root);
    System.out.println("Postorder");
    t.postorder(root);
        System.out.println("NOn recursive preorder");
        t.nonRecursivePreorder(root);

    }
public void insert()
{
    System.out.println("Enter the element to insert");
    int c,element=sc.nextInt();
    do{
        if(root==null)
        {
            root= new Node(element);
        }
        else {
            Node n=root;
            while(true) {
                System.out.println("Do you wanna insert at right or left?");
                char charr = sc.next().charAt(0);
                if (charr == 'l') {
                    if (n.left != null)
                        n = n.left;
                    else {
                        n.left = new Node(element);
                        break;
                    }
                } else {
                    if (n.right != null)
                        n = n.right;
                    else
                    {
                        n.right = new Node(element);
                        break;
                }
                }
            }
        }
        System.out.println("Do you wanna enter more(0/1)");
        c=sc.nextInt();
        if(c==1) {
            System.out.println("Enter the element to insert");
            element = sc.nextInt();
        }
    }while(c!=0);
}
void inorder(Node root)
{

    if(root!=null)
    {
        inorder(root.left);
        System.out.println(root.e);
        inorder(root.right);
    }
}
    void preorder(Node root)
    {
        if(root!=null)
        {
            System.out.println(root.e);
            preorder(root.left);
            preorder(root.right);
        }
    }
    void postorder(Node root)
    {
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.e);
        }
    }
    void nonRecursivePreorder(Node root)
    {
        if(!isEmpty()) {
            Node n = root;
            Stack<Node> s = new Stack<>();
            s.push(n);
            while(!s.isEmpty() )
            {
                    n=s.pop();
                    System.out.println(n.e);
                    if(n.right!=null)
                        s.push(n.right);
                    if(n.left!=null)
                        s.push(n.left);


//                System.out.println(s.toString());
            }
        }
        else {
            System.out.println("Tree is empty");
        }

    }
    boolean isEmpty()
    {
        return root==null;
    }
}








