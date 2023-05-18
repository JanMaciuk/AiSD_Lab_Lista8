package Wersja2H;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArraysGenerator {
    static double inverseSqrt5 = 1 / Math.sqrt(5);  //Do obliczania liczb fibonacciego
    static double phi = (1 + Math.sqrt(5)) / 2; //Do obliczania liczb fibonacciego

    public static int[] getRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1,length*2);
        }
        //reverse array using reverse method

        return array;
    }

    public static ArrayList<Integer> a(int length) {
        ArrayList<Integer> array = new ArrayList<>();
        int k = 1;
        while (k <= length) {
            array.add(k);
            k = 3*k + 1;
        }
        //System.out.println(array);
        return array;
    }
//  Realizacja tego rekurencyjnie może doprowadzić do StackOverflow dla bardzo bardzo dużych n
//    public static int getSequenceNumber(int n) {
//        if (n == 1) return 1;
//        return 3*getSequenceNumber(n-1) + 1;
//
//    }


    public static ArrayList<Integer> b(int length) {
        ArrayList<Integer> array = new ArrayList<>();
        int k = 1;
        for (int i = 2; i < length; i++) {
            if (k > length) break;
            array.add(k);
            k = (int) Math.pow(2,i)-1;
        }
        //System.out.println(array);
        return array;
    }

    public static ArrayList<Integer> c(int length) {
        ArrayList<Integer> array = new ArrayList<>();
        int k = 1;
        for (int i = 1; i < length; i++) {
            if (k > length) break;
            array.add(k);
            k = (int) Math.pow(2,i)+1;
        }
        //System.out.println(array);
        return array;
    }

    public static ArrayList<Integer> d(int length) {
        ArrayList<Integer> array = new ArrayList<>();
        int k = 1;
        for (int i = 2; i < length; i++) {
            if (k > length) break;
            array.add(k);
            k = getFibonacci(i+1);
        }
        //System.out.println(array);
        return array;
    }

    public static ArrayList<Integer> dodatkowy(int lenght) {
        ArrayList<Integer> array = new ArrayList<>();
        int h = lenght/2;
        for (int i = lenght; i > 0; i--) {
            if (h < 1) break;
            array.add(h);
            h = (int) (0.75*h);
        }
        Collections.reverse(array);
        return array;

    }



    //Ta metoda rekruencyjna jest strasznie złożona dla dużych długości.
//    public static int getFibonacci(int n) {
//        if (n == 1) return 0;
//        if (n == 2) return 1;
//        if (n == 3) return 1;
//        return getFibonacci(n-1) + getFibonacci(n-2);
//    }
    static int getFibonacci(int n) {
        return (int)Math.floor(Math.pow(phi, n) * inverseSqrt5 + 0.5);
    }

    public static void main(String[] args) {
        System.out.println((dodatkowy(100)));
    }
}
