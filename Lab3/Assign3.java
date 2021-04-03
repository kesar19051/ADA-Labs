import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    public static Object init;

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
}

public class Assign3 {
    static int check(int []arr, int mid, int n, int k, int[] sol) {
        int festival = 1;
        int currFestival = arr[0];
        int i = 1;
        int index = 1;
        while (i < n) {
            if (!(arr[i] - currFestival < mid)) {
                sol[index] = arr[i];
                index+=1;
                currFestival = arr[i];
                festival+=1;
                if (festival == k)
                    return 1;
            }
            i+=1;
        }
        return 0;
    }

    public static void main(String args[]) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        int k = Reader.nextInt();
        int []arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Reader.nextInt();
        }
        int ans = 0;
        int lo = 0;
        int hi = arr[n-1];
        int mid;
        int[] sol = new int[k];
        sol[0] = arr[0];
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (check(arr, mid, n, k, sol)==0)
                hi = mid - 1;
            else {
                ans = Math.max(ans, mid);
                lo = mid + 1;
        }
    }
        System.out.println(ans);
        for(int i: sol){
            System.out.print(i+" ");
        }
    }
}