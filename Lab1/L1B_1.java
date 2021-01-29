//package com.company;

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
    static int n;

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        n = reader.nextInt();

        //   int n = reader.nextInt();
        double[][] array = new double[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = reader.nextDouble();
            array[i][1] = reader.nextDouble();
        }
        Arrays.sort(array, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                double kk =  ( o1[1] - o2[1]);
                if (kk != 0) return (int) kk;
                return (int)(o1[0] - o2[0]);
            }
        });
//                for (int i = 0; i < n; i++){
//            System.out.println(Arrays.toString(array[i]));
//        }
        double ans = Merging(array, 0, n);
//        for (int i = 0; i < n; i++){
//            System.out.println(Arrays.toString(gridY[i]));
//        }
        System.out.println(ans);

    }

    public static double Merging(double[][] gridY, int s, int e) {
//        if (e > n) return Double.MAX_VALUE;
        int mid = (s + e) / 2;

      //  System.out.println(s + " " + e);
        if (e - s == 2) {
       //     System.out.println("AJJJJJJJJJJJ");
            return findPeri(gridY);
        }
        else if (e - s < 2 ) {
            //System.out.println("AYUSHIII ");
            return Double.MAX_VALUE;}
        double a1 = Merging(gridY, s, mid);
        double a2 = Merging(gridY, mid + 1, e);
//        int[][] refX = new int[gridX.length][2];
//        int i1 = 0; int j1 = 0; int k1 = 0;
//        while (i1 < mid - s && j1 < e - mid - 1){
//            if (gridX[i1][0] < gridX[j1][0]){
//                refX[k1][0] = gridX[i1][0];
//                refX[k1][1] = gridX[i1][1];
//                k1 += 1; i1 += 1;
//            }
//            else if (gridX[i1][0] > gridX[j1][0]){
//                refX[k1][0] = gridX[j1][0];
//                refX[k1][1] = gridX[j1][1];
//                k1 += 1; j1 += 1;
//            }
//        }
//        while (i1 < mid - s){
//            gridX[k1][0] = gridX[i1][0];
//            gridX[k1][1] = gridX[i1][1];
//            i1 += 1; k1 += 1;
//        }
//        while (j1 < e - mid - 1){
//            gridX[k1][0] = gridX[j1][0];
//            gridX[k1][1] = gridX[j1][1];
//            j1 += 1; k1 += 1;
//        }

        int i2 = 0;
        int j2 = 0;
        int k2 = 0;
//        double[][] refY = new double[n][2];
////        while (i2 < mid - s+ 1 && j2 < e - mid ) {
////       //     System.out.println("OOOO" + " " + i2 + " " + j2);
////            if (gridY[i2][0] < gridY[j2][0]) {
////                refY[k2][0] = gridY[i2][0];
////                refY[k2][1] = gridY[i2][1];
////                k2 += 1;
////                i2 += 1;
////            } else if (gridY[i2][0] > gridY[j2][0]) {
////                refY[k2][0] = gridY[j2][0];
////                refY[k2][1] = gridY[j2][1];
////                k2 += 1;
////                j2 += 1;
////            }
////            else{
////                refY[k2][0] = gridY[j2][0];
////                refY[k2][1] = gridY[j2][1];
////                k2 += 1;
////                j2 += 1;
////            }
////        }
////        while (i2 < mid - s) {
////            refY[k2][0] = gridY[i2][0];
////            refY[k2][1] = gridY[i2][1];
////            i2 += 1;
////            k2 += 1;
////        }
////        while (j2 < e - mid - 1) {
////            refY[k2][0] = gridY[j2][0];
////            refY[k2][1] = gridY[j2][1];
////            j2 += 1;
////            k2 += 1;
////        }
        double[] rr = gridY[mid]; double kk = Math.min(a1, a2);
        int u1 = s; int u2 = e;
        u1 = Good(gridY, rr, Math.ceil(kk/2), s, e);
//        while (u2 < e && u2 > s  && findDist(gridY[u2], rr) > kk){u2 -= 1;}
        if (u1 == -1) return kk;
        if ((u1 < mid &&80 + u1 < mid) || (u1 > mid  && 80 + u1 > mid)){return kk;}
            for (int i = u1; i < u2; i++) {
            for (int j = i + 1; j < Math.min(80 + u1, e); j++) {
                for (int k = j + 1; k < Math.min(80 + u1,e); k++) {
                    double[][] bb = new double[3][2];
                    bb[0] = gridY[i];
                    bb[1] = gridY[j];
                    bb[2] = gridY[k];
                    kk = Math.min(kk, findPeri(bb));
                }
            }
        }
     //   System.out.println("KK: " + kk);
        return kk;
    }
    public static int Good(double[][] grid, double[] ref, double kk , int s, int e){
        if (e < s) return -1;
        int mid = (s + e)/2;
        if (findDist(grid[mid], ref) < kk){
            int ub = Good(grid, ref, kk, s, mid - 1);
            if (ub != -1) return ub;
            return mid;
        }
        return Good(grid, ref, kk, mid + 1, e);
    }
//    public int[] splitMerge(int[][] grid, int s, int e, int mid){
//
//        double a1 = Merging(grid, s, mid);
//        double a2 = Merging(grid, mid + 1, e);
//
//    }

    public static double findPeri(double[][] array){
        int i = 0; int j = 1; int k = 2; double ans = Double.MAX_VALUE;
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
        return ans;

    }
    public static double findDist(double[] a1,double[] a2){
        double aj1_0 = Math.pow(a1[0] - a2[0], 2);
        double  aj1_1 = Math.pow(a1[1] - a2[1], 2);
        double aj1_f = Math.sqrt(aj1_0 + aj1_1);
        return aj1_f;
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
