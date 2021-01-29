package com.company;

import javax.swing.text.AttributeSet;
import java.io.BufferedReader;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;



public class Main {
    static Integer[][] tokens;
    public static void main(String[] args) throws IOException {
        FastReader reader=new FastReader();
        int n = reader.nextInt();

         //   int n = reader.nextInt();
            double[][] array = new double[n][2];
            for (int i = 0; i < n; i++){
                array[i][0] = reader.nextDouble();
                array[i][1] = reader.nextDouble();
            }
            double ans = Double.MAX_VALUE;
            for (int i = 0; i < n; i++){
                for (int j = i+1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        double aj1_0 = Math.pow(array[j][0] - array[k][0], 2);
                        double  aj1_1 = Math.pow(array[j][1] - array[k][1], 2);
                        double aj1_f = Math.sqrt(aj1_0 + aj1_1);
                        double aj2_0 = Math.pow(array[i][0] - array[j][0], 2);
                        double  aj2_1 = Math.pow(array[i][1] - array[j][1], 2);
                        double aj2_f = Math.sqrt(aj2_0 + aj2_1);
                        double aj3_0 = Math.pow(array[i][0] - array[k][0], 2);
                        double  aj3_1 = Math.pow(array[i][1] - array[k][1], 2);
                        double aj3_f = Math.sqrt(aj3_0 + aj3_1);
                        ans = Math.min(ans, aj1_f + aj2_f + aj3_f);
//                        ans = Math.min(ans, aj2_f);
//                        ans = Math.min(ans, aj3_f);
                    }
                }
            }
        System.out.println(ans);
    }
//    public static int fun(int a , HashMap<Integer, Integer> hash){
////        if (a < 0 ) return 0;
////        if (a == 0) return  1;
////        if (hash.containsKey(a)){ return hash.get(a);}
////        boolean f = false;
////        System.out.println("A: " + a);
////        for (int i = 1; i <= (a/7) + 1; i+= 7){
////            for (int j = 1; j < a; j*= 10){
////                int el = fun((int) (a - j*7*i), hash);
////                if (el == 1) {f = true; break;}
////                if (f) break;
////             }
////        }
////        if (f)hash.put(a, 1);
////        else hash.put(a, 0);
////        return hash.get(a);
//    }
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