
import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter rows");
        int r=sc.nextInt();
        System.out.println("Enter cols");
        int c=sc.nextInt();
        int[][] a=new int[r][c];
        for (int i=0;i<3;i++)
        {
            for (int j = 0; j < 3; j++) {

                a[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<r;i++)
            System.out.println(Arrays.toString(a[i]));
        System.out.println(isSquareMatrix(r,c));
        add();
        //Operations
        System.out.println("calling transposed matrix");
        transpose(a);
        mul();
        System.out.println(checkUppertraingular(a));
    }
    public static boolean isSquareMatrix(int r, int c)
    {
        return r==c;
    }
    public static void add() {
        //dimension of first matrix
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dimension of 1st matrix");
        System.out.println("Enter rows");
        int r1 = sc.nextInt();
        System.out.println("Enter cols");
        int c1 = sc.nextInt();

        System.out.println("Enter Dimension of 2st matrix");
        System.out.println("Enter rows");
        int r2 = sc.nextInt();
        System.out.println("Enter cols");
        int c2 = sc.nextInt();

        if (r1 == c1 && r2 == c2) {
            System.out.println("Enter the 1st Matrix");
            int[][] a = new int[r1][c1];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int[][] b = new int[r2][c2];
            int[][] c=new int[r2][c2];
            System.out.println("Enter the 2nd Matrix");
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    b[i][j] = sc.nextInt();
                    c[i][j]=a[i][j]+b[i][j];
                }
            }
            System.out.println("Matrix A");
                printMat(a);
            System.out.println("Matrix B");
                printMat(b);
            System.out.println("Matrix C");
                printMat(c);
        }
        else
            System.out.println("Addition is not possible as there dimensions are not equal");
    }
    public static void printMat(int[][] a)
    {
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public static void transpose(int[][] a)
    {
        int[][] aa=new int[a[0].length][a.length];
        for(int i=0;i<a.length;i++)
        {
            for (int j = 0; j <a[i].length ; j++) {
                aa[j][i]=a[i][j];

            }
        }
        System.out.println("Original matrix");
        printMat(a);
        System.out.println("transposed matrix");
        printMat(aa);
    }
    //multiply two matrix
    public static void mul() {
        //dimension of first matrix
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dimension of 1st matrix");
        System.out.println("Enter rows");
        int r1 = sc.nextInt();
        System.out.println("Enter cols");
        int c1 = sc.nextInt();

        System.out.println("Enter Dimension of 2st matrix");
        System.out.println("Enter rows");
        int r2 = sc.nextInt();
        System.out.println("Enter cols");
        int c2 = sc.nextInt();

        if (c1==r2) {
            System.out.println("Enter the 1st Matrix");
            int[][] a = new int[r1][c1];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int[][] b = new int[r2][c2];

            int[][] c=new int[r1][c2];

            System.out.println("Enter the 2nd Matrix");
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    b[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    c[i][j]=0;
                    for (int k = 0; k < c1; k++) {
                        c[i][j]+=a[i][k]*b[k][j];
                    }
                }
            }

            System.out.println("Matrix A");
            printMat(a);
            System.out.println("Matrix B");
            printMat(b);
            System.out.println("Matrix C");
            printMat(c);
        }
        else
            System.out.println("Addition is not possible as there dimensions are not equal");
    }
    public static boolean checkUppertraingular(int[][] a)
    {
        int i;
        for (i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
             if(j<i && a[i][j]==0)
                 continue;
             else
                 break;
            }
        }
        return i == a.length;
    }
}
