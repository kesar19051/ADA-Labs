import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

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


public class Prob-A1 {
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int t = Reader.nextInt();
        for(int i = 0; i<t; i++){
            int n = Reader.nextInt();
            int ans = 0;
            ArrayList<Integer> list = new ArrayList<>();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for(int j = 0; j<n; j++){
                arr1[j] = Reader.nextInt()-1;
                arr2[arr1[j]] = j;
            }
            int[] arr = new int[n];
            for(int j = 0; j<n; j++){
                arr[j] = Reader.nextInt()-1;
            }
            for(int k = 0; k<n-1; k++){
                for(int l = k+1; l<n; l++){
                    if(arr2[arr[k]]>arr2[arr[l]])
                        ans++;
                }
            }
            System.out.println(ans);
        }
    }
}


