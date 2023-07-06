import java.util.Scanner;

class Book
{
    int isbn_no;
    String book_name;
    String auth_name;
    static Scanner sc=new Scanner(System.in);
    void getbook()
    {
        System.out.println("Enter book no");
        isbn_no=sc.nextInt();
        System.out.println("Enter book name");
        book_name=sc.next();
        System.out.println("Enter book author");
        auth_name=sc.next();
    }
    void printbook()
    {
        System.out.println("Book details");
        System.out.println(isbn_no);
        System.out.println(book_name);
        System.out.println(auth_name);
    }
}
class MyLib
{
    Book[] b=new Book[50];
    int n;
    static Scanner sc=new Scanner(System.in);
    void acceptbooks()
    {
        System.out.println("Enter the number of books");
        n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            b[i]=new Book();
            b[i].getbook();
        }
    }
    void displaybook()
    {
        for (int i = 0; i < n; i++) {
            b[i].printbook();
        }
    }
    void search_ISBN()
    {
        System.out.println("Enter the isbm number");
        int no=sc.nextInt();
        int i;
        for (i = 0; i < n; i++) {
            if(b[i].isbn_no==no)
            {
                System.out.println("Book found ");
                b[i].printbook();
                break;
            }
        }
        if(i==n)
            System.out.println("Book not found");

    }
    void search_Author()
    {
        System.out.println("Enter the isbm number");
        String name=sc.next();
        int i;
        for (i = 0; i < n; i++) {
            if(b[i].auth_name.equals(name))
            {
                System.out.println("Book found ");
                b[i].printbook();
                break;
            }
        }
        if(i==n)
            System.out.println("Author not found");

    }

    void sort_books()
    {
        System.out.println("Books in unsorted order ");
        displaybook();
        for(int i=0;i<n;i++)
        {
            for (int j = 0; j < (n-1)-i; j++) {
                if(b[j].isbn_no>b[j+1].isbn_no)
                {
                    Book tb=b[j];
                    b[j]=b[j+1];
                    b[j+1]=tb;
                }

            }
        }
        displaybook();
    }
}
public class Library {
static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MyLib l = new MyLib();
        System.out.println("1.Accept books\n2.print books\n3.search by Author\n4.search by isbn\n 5.sort books\n6.Exit");
        System.out.println("Enter your choice");
        int ch = sc.nextInt();
        do {
            switch (ch) {
                case 1:
                    l.acceptbooks();
                    break;
                case 2:
                    l.displaybook();
                    break;
                case 3:
                    l.search_Author();
                    break;
                case 4:
                    l.search_ISBN();
                    break;
                case 5:
                    l.sort_books();
                    break;
                case 6:
                    System.out.println("Thank you");
                    break;
            }
            System.out.println("1.Accept books\n2.print books\n3.search by Author\n4.search by isbn\n 5.sort books\n6.Exit");
            System.out.println("Enter your choice");
            ch = sc.nextInt();
        } while (ch != 6);
    }
}
