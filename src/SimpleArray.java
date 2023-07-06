import java.util.Arrays;
import java.util.Scanner;

public class SimpleArray {
    int[] a=new int[10];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        SimpleArray s=new SimpleArray();
        System.out.println("0.Exit\n1.Display\n2.Insert\n3.Delete\n4.Update");
        System.out.println("Enter your choice");
        int n = sc.nextInt();

        do {
            switch (n) {
                case 0:
                    System.exit(0);
                case 1:
                    s.printarray();break;

                case 2:
                    s.insert();
                    break;
                case 3:
                    s.delete();
                    break;
                case 4:
                    s.update();
                    break;
            }
            System.out.println("0.Exit\n1.Display\n2.Insert\n3.Delete\n4.Update");
            System.out.println("Enter your choice");
            n = sc.nextInt();
        }while(n!=0);
    }
    public void insert() {
        System.out.println("Enter the position to insert");
        int pos=sc.nextInt();
        System.out.println("Enter the element to insert");
        int ele=sc.nextInt();
        if(pos<=a.length)
        {
//            a[a.length]=0;
            for (int i = a.length-2; i >=pos; i--) {
                a[i+1]=a[i];

            }
            a[pos]=ele;
        }
        else
            System.out.println("Invalid position to insert element");
        System.out.println(Arrays.toString(a));
    }

    public void delete()
    {
        System.out.println("Enter the element to delete");
        int ele=sc.nextInt();
        int i,pos=0;
        for (i = 0; i < a.length; i++) {
            if(a[i]==ele)
            {
                System.out.println("element found");
                pos=i;
                break;
            }
        }
        if(i==a.length)
            System.out.println("Element not found");
        else {
            for(int j = pos; j <a.length-1; j++) {
                a[j]=a[j+1];
            }
        }
    printarray();
    }
    public void printarray()
    {
        System.out.println(Arrays.toString(a));
    }
    public void update()
    {
        System.out.println("Enter the element to update");
        int oldup=sc.nextInt();

        System.out.println("Enter the new element");
        int newup=sc.nextInt();


        int i;
        for (i = 0; i < a.length; i++) {
            if(a[i]==oldup)
            {
                System.out.println("element updated");
                a[i]=newup;
                printarray();
                break;
            }
        }
        if(i==a.length)
            System.out.println("Element not found");

        }
}
