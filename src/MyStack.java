import java.util.Scanner;

public class MyStack {
    int[] a=new int[20];
    int top=-1;
    int maxLen=20;
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        MyStack s = new MyStack();
        System.out.println("Stack Operations");
        System.out.println("\n1.Push\n2.Pop\nTraverse\n4.Evaluate Postfix\n5.evaluate prefix\n6.Exit");
        int ch = sc.nextInt();
        do{
        switch (ch) {
            case 1:
                System.out.println("Enter element to push");
                int e=sc.nextInt();
                if(s.isFull())
                    System.out.println("Stack is full");
                else
                    s.push(e);
                break;
            case 2:
                if(s.isEmpty())
                    System.out.println("Stack is Empty");
                else
                    System.out.println("The element popped is "+s.pop());
                break;
            case 3:
                if(s.isEmpty())
                    System.out.println("Stack is Empty");
                else
                    s.traverse();
                break;
            case 4:
                System.out.println(s.evaluatePostfix(sc.next()));break;
            case 5:
                System.out.println(s.evaluatePrefix(sc.next()));break;
            case 6:
                System.out.println("Good bye");
                break;
        }
            System.out.println("Stack Operations");
            System.out.println("\n1.Push\n2.Pop\nTraverse\n4.Evaluate Postfix\n5.evaluate prefix\n6.Exit");
            ch = sc.nextInt();

        }while(ch!=5);
    }
    int pop()
    {
        return a[top--];
    }
    void push(int n)
    {
        a[++top]=n;
    }
    boolean isEmpty()
    {
        return top==-1;
    }
    boolean isFull()
    {
        return top==maxLen-1;
    }
    void traverse()
    {
        for(int i=top;i>=0;i--)
            System.out.println(a[i]);
    }
    public int evaluatePostfix(String exp)
    {
        top=-1;
        char[] c=exp.toCharArray();
        for(char ch:c)
        {
            if(Character.isDigit(ch))
                push(Integer.parseInt(""+ch));
            else
            {
                int y=pop();
                int x=pop();
                switch (ch)
                {
                    case '+':push(x+y);break;
                    case '-':push(x-y);break;
                    case '/':push(x/y);break;
                    case '*': push(x*y);break;
//                    case '^':
                }
            }

        }
        return pop();
    }
    public int evaluatePrefix(String exp)
    {
        top=-1;
        char[] c=exp.toCharArray();
        for(int i=c.length-1;i>=0;i--)
        {
            if(Character.isDigit(c[i]))
                push(Integer.parseInt(""+c[i]));
            else
            {
                int x=pop();
                int y=pop();
                switch (c[i])
                {
                    case '+':push(x+y);break;
                    case '-':push(x-y);break;
                    case '/':push(x/y);break;
                    case '*': push(x*y);break;
//                    case '^':
                }
            }

        }
        return pop();
    }

}
