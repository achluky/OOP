public class TheCode
{
    public static void all_q(int[] a, int n)
    {
        if (n == a.length)         
        {
            for (int i = 0; i < a.length; i++)            {              for (int j = 0; j < a.length; j++)              {                if (a[i] == j)                   System.out.print("Q ");                else                   System.out.print("+ ");              }              System.out.println();            }            System.out.println();            return;         } 
        for (int i = 0; i < a.length; i++)
        {
            boolean isAvail = true;
            for (int j = 0; j < n; j++)
            {
                if (a[j] == i)
                    isAvail = false;
                if (i-a[j] == n-j)
                    isAvail = false;
                if (a[j]-i == n-j)
                    isAvail = false;
            }
            if (isAvail)
            {
                a[n] = i;
                all_q(a, n+1);
            }
        } 
      } 
    public static void main(String[] s)
    {
        int[] a = new int[12];
        all_q(a, 0);
    }
} 