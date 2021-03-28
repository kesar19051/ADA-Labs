//package com.company;

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

public class Main
{
    public static void main(String args[]) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        long B = Reader.nextInt();
        long B1 = B;
        Stock[] ref = new Stock[n];
        PriorityQueue<Stock> stocks = new PriorityQueue<>(n, new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return Long.compare(o2.g, o1.g);
            }
        });
        for(int i = 0; i<n; i++){
            long x = Reader.nextInt();
            long y = Reader.nextInt();
            Stock stock = new Stock(x, y);
            stocks.add(stock);
            ref[i] =stock;
        }
        long profit = 0;
        while(B1>0){
            Stock stock = stocks.poll();
            if (stock.g < 0) break;
            stock.invested += 1;
            stock.update();
            B1 -=1;
            stocks.add(stock);
        }
        for (int i = 0; i < n; i++){
            long s = ref[i].invested;
            long k = (ref[i].a*s*s) + (ref[i].b*s);
            profit += k;
        }
        System.out.println(profit);
    }
}

class Stock{
    long a;
    long b;
    long invested = 0;
    long g = 0;
    Stock(long a, long b){
        this.a = a;
        this.b = b;

        this.g = a + b ;
    }
    public void update(){
        this.g = (a*(invested + 1)*(invested + 1)) + (b*(invested + 1)) - (a*invested*invested) - (b*invested);

        //System.out.println("UPDATED: " + g);
    }
}

class comparator implements Comparator<Stock>{
    @Override
    public int compare(Stock o1, Stock o2) {
        int u =  Long.compare(o2.g, o1.g);
        if (u != 0)return u;
        return Long.compare(o2.a + o2.b, o1.a + o1.b);
    }
}

