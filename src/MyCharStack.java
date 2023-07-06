import java.util.Scanner;

public class MyCharStack {
    char[] a=new char[20];
    int top=-1;
    int maxLen=20;
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        MyCharStack s = new MyCharStack();
        System.out.println("Stack Operations");
        System.out.println("\n1.Push\n2.Pop\nTraverse\n4.Reverse a string\n5.convert to postfix\n6.Conver to prefix\n7.Exit");
        int ch = sc.nextInt();
        do{
            switch (ch) {
                case 1:
                    System.out.println("Enter element to push");
                    char e=sc.next().charAt(0);
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
                    System.out.println("Enter String to reverse");
                    System.out.println(s.reverse(sc.next()));
                case 5:
                    System.out.println("Enter infix ex[ression to be converted to postfix exp");
                    System.out.println(s.convertInfixToPostfix(sc.next()));break;
                case 6:
                    System.out.println("Enter infix ex[ression to be converted to prefix exp");
                    System.out.println(s.convertInfixToPrefix(sc.next()));break;

                case 7:
                    System.out.println("Good bye");
                    break;
            }
            System.out.println("Stack Operations");
            System.out.println("\n1.Push\n2.Pop\nTraverse\n4.Reverse a string\n5.convert to postfix\n6.Conver to prefix\n7.Exit");
            ch = sc.nextInt();

        }while(ch!=7);
    }
    char pop()
    {
        return a[top--];
    }
   char peek()
    {
        return a[top];
    }
    void push(char n)
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
    String convertInfixToPostfix(String infix)
    {
        top=-1;
        String postfix="";
        char[] in=infix.toCharArray();
        for(char c:in)
        {
            if(Character.isDigit(c))
                postfix+=c;
            else {

                    while (!isEmpty() && getPriority(c) <= getPriority(peek()))
                        postfix += pop();
                push(c);
                }

            }
        while(!isEmpty())
            postfix+=pop();

        return postfix;
    }
    String convertInfixToPrefix(String infix)
    {
        top=-1;
        String prefix="";
        char[] in=infix.toCharArray();
        for(int i=in.length-1;i>=0;i--)
        {
            if(Character.isDigit(in[i]))
                prefix=in[i]+prefix;
            else {

                while (!isEmpty() && getPriority(in[i]) <= getPriority(peek()))
                    prefix =pop()+prefix;
                push(in[i]);
            }

        }
        while(!isEmpty())
            prefix =pop()+prefix;

        return prefix;
    }
    int getPriority(char p)
    {
        switch (p)
        {
            case '^':return -1;
            case '%':
            case '!':
            case '*':
            case '/':return -2;
            case '+':
            case '-':return -3;

        }
        return -5;
    }
    String reverse (String c)
    {
        top=-1;
        if(c.length()<=maxLen)
        {
            for (int i = 0; i < c.length(); i++)
            {
                    push(c.charAt(i));
            }
            String mystr="";
            for (int i = 0; i < c.length(); i++)
            {
                mystr+=pop();
            }
            return mystr;
    }
    else {
            System.out.println("Stack error");
            return "";
        }
    }


}
