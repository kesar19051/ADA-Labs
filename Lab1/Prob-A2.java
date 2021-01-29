import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
}

public class Assign3 {
    private static long mergeAndCount(int[] arr, int[] temp, int[] arr2, int l, int m, int r) {

        int i, j, k;
        long count = 0;
        i = l;
        j = m;
        k = l;
        while ((i <= m - 1) && (j <= r)) {
            if (arr2[arr[i]] <= arr2[arr[j]])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                count += (m - i);
            }
        }

        while (i <= m - 1)
            temp[k++] = arr[i++];

        while (j <= r)
            temp[k++] = arr[j++];

        for (i = l; i <= r; i++)
            arr[i] = temp[i];

        return count;
    }

    private static long mergeSortAndCount(int[] arr, int[] temp,int[] arr2,
                                         int l, int r) {
        long count = 0;
        int m;
        if (l < r) {
            m = (r-l)/2+l;
            count += mergeSortAndCount(arr, temp,arr2, l, m);
            count += mergeSortAndCount(arr, temp,arr2, m + 1, r);
            count += mergeAndCount(arr, temp, arr2, l, m + 1, r);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int t = Reader.nextInt();
        for (int i = 0; i < t; i++) {
            int n = Reader.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int j = 0; j < n; j++) {
                arr1[j] = Reader.nextInt() - 1;
                arr2[arr1[j]] = j;
            }
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Reader.nextInt() - 1;
            }
            int[] temp = new int[arr.length];
            System.out.println(mergeSortAndCount(arr, temp, arr2,0, arr.length - 1));
        }
    }
}

//Referred GFG for number of inversions algorithm



