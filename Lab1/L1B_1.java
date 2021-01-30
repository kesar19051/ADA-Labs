import java.io.BufferedReader;
import java.io.InputStream;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static Integer[][] tokens;
    static int n;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        Integer[][] list_of_points = new Integer[n][2];
        for (int o = 0; o < n; o++) {
            list_of_points[o][0] = reader.nextInt();
            list_of_points[o][1] = reader.nextInt();
        }
        Arrays.sort(list_of_points, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        System.out.println(sort2(list_of_points, 0, n - 1 , Double.MAX_VALUE));
    }
    static int merge(int arr[], int[] arr3, int[] temp, int l, int m, int r)
    {
       // System.out.println(l + " " + m + " " + r);
        int ans = 0;
        if (r - l == 1){
            if (arr3[arr[l]] > arr3[arr[r]]){
                int u = arr[l];
                arr[l] = arr[r];
                arr[r] = u;
                ans += 1;
            }
        //    System.out.println(Arrays.toString(arr) + " " + Arrays.toString(arr));
            return ans;
        }
        int i = l, j = m;
        int k = l;

        while (i < m &&  j <= r){
            if (arr3[arr[i]] > arr3[arr[j]]){
                temp[k] = arr[j];
                j += 1;k += 1;
                ans += (m - i);
            }
            else if (arr3[arr[i]] <= arr3[arr[j]]){
                temp[k] =arr[i];
                i += 1; k += 1;

            }
        }
        while (i < m){
            temp[k] =arr[i];
            i += 1; k += 1;
        }
        while (j <= r){
            temp[k] = arr[j];
            j += 1; k += 1;
        }
        //System.out.println(Arrays.toString(arr) + " " + Arrays.toString(temp));
        for (int kk = l; kk <= r; kk++){arr[kk] = temp[kk];}
        return ans;
    }
    static double merge2(int arr[][], int l, int m, int r)
    {
return 0;
    }
    static int sort(int arr[], int[] arr3, int[] temp, int l, int r)
    {
        if (l < r) {
            int m = ((r - l) / 2) + l;
             int j1 = sort(arr, arr3, temp, l, m);
            int j2 = sort(arr,arr3, temp, m + 1, r);

            int j3 = merge(arr, arr3, temp,l, m + 1, r);
            return j1 + j2 + j3;
        }
        return 0;
    }
    static double sort2(Integer[][] array, int l, int r, double d){
        if (l < r){
            int m = ((r - l)/2) + l;
            double a1 = sort2(array, l, m, d);
            double a2 = sort2(array, m + 1, r, Math.min(d, a1));
            d = Math.min(a1, a2);
            ArrayList<Integer[]> strip_of_points = new ArrayList<>();
            for (int i = l; i <= r; i++){
                if (Math.abs(array[i][0] - array[m][0]) <= Math.floor((Math.min(d, a2))/2)){
                    strip_of_points.add(array[i]);
                }
                else {
                    break;
                }
            }
            int u = strip_of_points.size();
            strip_of_points.sort(new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    return o1[1] - o2[1];
                }
            });
            for (int i = 0; i < u; i++){
                for (int j = i + 1; j < Math.min(i + 4, u); j++){
                    for (int k = j + 1; k < Math.min(j + 4, u); k++){

                        double tt = findPeri(strip_of_points.get(i), strip_of_points.get(j), strip_of_points.get(k));
                        d = Math.min(d, tt);
                    }
                }
            }
            return d;
        }
        return Double.MAX_VALUE;
    }
    static double findPeri(Integer[] a1, Integer[] a2, Integer[] a3){
        double f1 = findDist(a1, a2);
        double f2 = findDist(a2, a3);
        double f3 = findDist(a3, a1);
        return f1 + f2 + f3;
    }
    static double findDist(Integer[] a1, Integer[] a2){
        double g1 = Math.pow(a2[0] - a1[0], 2);
        double g2 = Math.pow(a2[1] - a1[1], 2);
        double g3 = Math.sqrt(g1 + g2);
        return g3;
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
            catch (IOException  e)
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
