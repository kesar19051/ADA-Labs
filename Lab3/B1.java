import java.io.*;
import java.util.*;
import java.util.StringTokenizer;


public class Main {
    //    static Integer[][] tokens;
//    static HashMap<String , Integer> hashMap;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
//        InputReader sc = new InputReader(System.in);
//        PrintWriter out = new PrintWriter(System.out);

        FastReader reader = new FastReader();
        int n= reader.nextInt(); int B = reader.nextInt();
        int[] arr1 = new int[n]; int[] arr2 = new int[n];
        for (int o = 0; o <n; o++) {
          arr1[o] = reader.nextInt();arr2[o] = reader.nextInt();
        }
        Integer[][] grid = new Integer[n][B + 1];
        System.out.println(dp(grid, 0, B, n, B, arr1, arr2));
//        for (int i = 0; i < n; i++){
//            System.out.println(Arrays.toString(grid[i]));
//        }
        System.out.close();
    }
    public static int dp(Integer[][] grid, int i, int j, int n, int B, int[] arr1, int[] arr2){
        if (i >= n || j < 0 || j > B) return 0;
        if (grid[i][j] != null) return grid[i][j];
        int k = 0; int u = -1;
            for (int q = 0; q <= j; q++) {
                if (dp(grid, i + 1, q, n, B, arr1, arr2) + (j - q)*(j -q)*arr1[i] + ( j - q)*arr2[i] >= k){u = q; k = (j - u)*(j -u)*arr1[i] + ( j - u)*arr2[i] + dp(grid, i + 1, q, n, B, arr1, arr2);}
            }


        grid[i][j] = k ;
        return grid[i][j];
    }

}








class Node {
    int a; int b; int d; int end_time; int starttime;
    public Node(int a, int b, int d){
        this.a = a; this.b = b;
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

/ Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    / call this method to initialize reader for InputStream */
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

 class InputReader {
    private final int BUFFER_SIZE = 32768;
    private InputStream stream;
    private byte[] buffer = new byte[BUFFER_SIZE + 1];
    private int pointer = 1;
    private int readLength = 0;
    private int lastWhiteSpace = '\n';

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private void fillBuffer() {
        try {
            readLength = stream.read(buffer, 1, BUFFER_SIZE);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

private byte get() {
        if (pointer > readLength) {
            pointer = 1;
            fillBuffer();
            if (readLength <= 0) return -1;
        }
        return buffer[pointer++];
    }

    private byte peek() {
        if (pointer > readLength) {
            pointer = 1;
            fillBuffer();
            if (readLength <= 0) return -1;
        }
        return buffer[pointer];
    }

    public boolean hasNext() {
        int c;
        while (isWhiteSpace(c = peek()) && c != -1) {
            get();
        }
        return c != -1;
    }

    public char nextChar() {
        int c = get();

        while (isWhiteSpace(c)) {
            c = get();
        }

        return (char) c;
    }

    public int nextInt() {
        int c = nextChar();
        int sign = 1;

        if (c == '-') {
            sign = -1;
            c = get();
        }

        int abs = 0;

        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            abs *= 10;
            abs += c - '0';
            c = get();
        } while (!isWhiteSpace(c));

        lastWhiteSpace = c;

        return abs * sign;
    }

    public long nextLong() {
        int c = nextChar();
        long sign = 1;

        if (c == '-') {
            sign = -1;
            c = get();
        }

        long abs = 0;

        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            abs *= 10;
            abs += c - '0';
            c = get();
        } while (!isWhiteSpace(c));

        lastWhiteSpace = c;

        return abs * sign;
    }

    public double nextDouble() {
        int c = nextChar();
        int sign = 1;

        if (c == '-') {
            sign = -1;
            c = get();
        }

        double abs = 0;

        do {
            abs = (c - '0') + abs * 10;
        } while (!isWhiteSpace(c) && c != '.');

        if (c == '.') {
            int m = 1;

            do {
                abs = abs + (c - '0') * m;
                m /= 10;
            } while (!isWhiteSpace(c));
        }

        return abs * sign;
    }

    public String nextString() {
        int c = nextChar();

        if (c == -1) return null;

        StringBuilder builder = new StringBuilder();

        do {
            builder.append((char) c);
            c = get();
        } while (!isWhiteSpace(c));

        return builder.toString();
    }

    public String next() {
        return nextString();
    }

    public String nextLine() {
        if (lastWhiteSpace != '\r' && lastWhiteSpace != '\n') throw new InputMismatchException();

        int c = get();

        if (lastWhiteSpace == '\r') {
            if (c == '\n') {
                lastWhiteSpace = '\n';
                c = get();
            }
            else {
                --pointer;
            }
        }

        if (c == -1 || c == '\r' || c == '\n') return null; // empty line

        StringBuilder builder = new StringBuilder();

        do {
            builder.append(c);
            c = get();
        } while (c != '\r' && c != '\n');

        return builder.toString();
    }

    public boolean isWhiteSpace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}