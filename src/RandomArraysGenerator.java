import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArraysGenerator {
    static double inverseSqrt5 = 1 / Math.sqrt(5);  //Do obliczania liczb fibonacciego
    static double phi = (1 + Math.sqrt(5)) / 2; //Do obliczania liczb fibonacciego

    public static int[] getRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1,length*2);
        }
        return array;
    }

    public static int[] a(int length) {
        int[] array = new int[length];
        array[0] = 1;
        for (int i = 1; i < length; i++) {
            array[i] = 3*array[i-1] + 1;
        }

        return array;
    }

    //Realizacja tego rekurencyjnie może doprowadzić do StackOverflow dla bardzo bardzo dużych n
//    public static int getSequenceNumber(int n) {
//        if (n == 1) return 1;
//        return 3*getSequenceNumber(n-1) + 1;
//
//    }


    public static int[] b(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) Math.pow(2,i)-1;
        }
        return array;
    }

    public static int[] c(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) Math.pow(2,i)+1;
        }
        return array;
    }

    public static int[] d(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = getFibonacci(i+1);
        }
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

//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(getFibonacci(i+1));
//        }
//    }
}
