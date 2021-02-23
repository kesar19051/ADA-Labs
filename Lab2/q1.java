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
        HashMap<String, Integer> hash = new HashMap();
//        for (int i = 0; i <= 1000; i++){
//            for (int j = 0; j <= 1000; j++){
//                int u = fun(hash, i, j);
//            }
//        }
        int test  = reader.nextInt();
        for (int o = 0; o < test; o++) {
            int A = reader.nextInt();
            int B = reader.nextInt();
            int s = fun(hash, A, B);

            if (s == 0) System.out.println("NO");
            else System.out.println("YES");
        }
    }
    public static int fun(HashMap<String, Integer> hash, int A, int B) {
        int y = 1;
      //  System.out.println(A + " " + B);
        if (hash.containsKey(A + "_" + B)) {
           // System.out.println("YAYYYYYYYY");
            return hash.get(A + "_" + B);
        }
        if (A == 1 && B == 2){return 0;}
        if (A + 1 == B){return 1; }
        if (B + 1 == A) {return 1; }
        if (A == 0 && B == 0) {
            hash.put(0 + "_" + 0, 0); return 0;
        }
        if (A == B){
            hash.put(A + "_" + B, 1); return 1;
        }
        if (A == 0) {
            hash.put(A + "_" + B, 1);
            return 1;
        }
        if (B == 0){hash.put(A + "_" + B, 1); return 1;}
        for (int i = (int) Math.min(A, B); i > 0; i--) {
            int u = fun(hash, A - i, B - i);
            if (u == 0) {
                hash.put(A + "_" + B, y);
                return 1;
            }
        }
        for (int i = A - 1; i >= 0; i--) {
            //for (int j = B; j = B; j++){
            int u = fun(hash, i, B);
            if (u == 0) {
                hash.put(A + "_" + B, y);
                return  1;
                //  }
            }
        }
        for (int i = B - 1; i >= 0; i--) {
            //for (int j = B; j = B; j++){
            int u = fun(hash, A, i);
            if (u == 0) {
                hash.put(A + "_" + B, y);
                return 1 ;
                //  }
            }
        }

        hash.put(A + "_" + B, 0);
        return 0;
    }
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