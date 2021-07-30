
import java.util.*;

class Magic
{
    public static void main(String args[])
    {
        Scanner in = new Scanner (System.in);
        System.out.print("Vvedite: N = ");
        int n = in.nextInt();
        int[][] a = new int[n][n];

            System.out.println("Ishodniy massiv: ");
            Magic.GenerateArray(a);
            Magic.PrintArray(a);
            System.out.println("Magicheskiy kvadrat: ");
            Magic.ReverseArray1(a);
            Magic.ReverseArray2(a);
            Magic.PrintArray(a);

    }

    public static void PrintArray(int a[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void GenerateArray(int a[][])
    {
        int k = 1;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                a[i][j] = k;
                k++;
            }
        }
    }

    public static void ReverseArray1(int a[][])
    {
        int t;
        for (int i = 0; i < a.length / 2; i++)
        {
            for (int j = 0; j < a.length / 2; j++)
            {
                if (i == j)
                {
                    t = a[i][j];
                    a[i][j] = a[a.length - 1 - i][a.length - 1 - j];
                    a[a.length - 1 - i][a.length - 1 - j] = t;
                }
            }
        }
    }

    public static void ReverseArray2(int a[][])
    {
        int t;
        for (int i = 0; i < a.length / 2 - 1; i++)
        {
            for (int j = a.length - 1; j > 2; j--)
            {
                t = a[i][j];
                a[i][j] = a[a.length - 1 - i][a.length - 1 - j];
                a[a.length - 1 - i][a.length - 1 - j] = t;
            }
        }
    }
}