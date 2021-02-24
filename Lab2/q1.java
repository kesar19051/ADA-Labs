//Avoid division by decimal digits :). Always try to multiply with whole numbers or fractions instead.
//if getting wrong answer then use long/double instead of int/float
//e + e = o; o + o = e; e + o = o;
//see stuff in a jugaad way... if you are being complicated you are doing it wrong baby girl :)
//If a=b+1 and b is even, then a∧b=1
//Be confident in Maths you are not that bad at it.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        FastReader reader = new FastReader();
        boolean[][] grid = new boolean[1001][1001];
        Integer[][] dp = new Integer[1001][1001];  dp[0][0] = 0; grid[0][0] = false;
        ArrayList<int[]> list = new ArrayList<>(); //list.add(new int[]{1, 2}); list.add(new int[]{2, 1});
        for (int i = 0; i <= 1000; i++){grid[i][0] = true; dp[i][0]= 1;}
        for (int j = 0; j <= 1000; j++){grid[0][j] = true; dp[0][j] = 1;}
        grid[0][0] = false;
        for (int i = 1; i <= 1000; i++){
            for (int j = i; j <= 1000; j++){
                if (i == j){grid[i][j] = true; grid[j][i] = true; dp[i][j] = 1;}
                else{
               //     System.out.println(i + " " + j);
                if (list.size() == 0 && dp[i][j] == null){grid[i][j] = false; grid[j][i] = false; dp[i][j] = 0; dp[j][i] = 0; list.add(new int[]{i, j}); list.add(new int[] {j, i});}
                else {boolean f = false;
                    for (int[] arr: list){
                        int s1 = arr[0] -i;
                        int s2 = arr[1] - j;
                        if (s1 == s2 || s1 == 0 || s2 == 0){
                            grid[i][j] = true; grid[j][i] = true;dp[i][j] = 1; dp[j][i] = 1; f = true;break;
                        }

                    }
                    if (!f){
                        grid[i][j] = false; list.add(new int[]{i, j}); list.add(new int[]{j, i}); dp[i][j] = 0; grid[j][i] = false;
                    }
                }
            }
            }
        }
//        for (int[] kl : list){
//            System.out.println(Arrays.toString(kl));
//        }
        int test = reader.nextInt();
        for (int o = 0; o < test; o++) {
            int A = reader.nextInt();
            int B = reader.nextInt();
            boolean k = grid[A][B];
            if (k) System.out.println("YES");
            else System.out.println("NO");
        }
    }

        // }
}


class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}