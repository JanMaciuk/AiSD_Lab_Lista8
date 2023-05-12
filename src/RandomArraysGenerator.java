import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArraysGenerator {

    public static int[] getRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1,length*2);
        }
        return array;
    }

    public static int[] a(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = getSequenceNumber(i+1);
        }

        return array;
    }
    public static int getSequenceNumber(int n) {
        if (n == 1) return 1;
        return 3*getSequenceNumber(n-1) + 1;

    }


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

    public static int getFibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 1;
        return getFibonacci(n-1) + getFibonacci(n-2);
    }


}
