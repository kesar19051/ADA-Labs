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

public class Assign3
{
    public static void main(String args[]) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        long B = Reader.nextInt();
        PriorityQueue<Stock> stocks = new PriorityQueue<>(n, new comparator());
        for(int i = 0; i<n; i++){
            long x = Reader.nextInt();
            long y = Reader.nextInt();
            Stock stock = new Stock(x, y);
            stocks.add(stock);
        }
        long profit = 0;
        while(B>0 && !stocks.isEmpty()){
            Stock stock = stocks.poll();
            long coinsInvested = (long) Math.floor(stock.x);
            if(B-coinsInvested>=0){
                profit += stock.a*(coinsInvested)*(coinsInvested)+stock.b*coinsInvested;
                B -= coinsInvested;
            }
            else{
                profit += stock.a*B*B+stock.b*B;
            }
        }
        System.out.println(profit);
    }
}

class Stock{
    long a;
    long b;
    double x;
    double y;

    Stock(long a, long b){
        this.a = a;
        this.b = b;
        this.x = -b/(2*a);
        this.y = a*x*x+b*x;
    }
}

class comparator implements Comparator<Stock>{
    @Override
    public int compare(Stock o1, Stock o2) {
        if(o1.y>o2.y)
            return -1;
        else if(o1.y<o2.y)
            return 1;
        return 0;
    }
}


