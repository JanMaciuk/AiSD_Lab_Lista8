import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int div = 1000;  // dzielenie z nanosekund: 100=mikrosekundy, 1000000=milisekundy.
        int arrayLength = 10000;
        System.out.println("Czasy w 1/10 mikrosekundy");
        System.out.println("dla ciągu o długości: "+arrayLength);

        runSorting(div, RandomArraysGenerator.a(arrayLength),"Ciąg a:");
        runSorting(div, RandomArraysGenerator.b(arrayLength),"Ciąg b:");
        runSorting(div, RandomArraysGenerator.c(arrayLength),"Ciąg c:");
        runSorting(div, RandomArraysGenerator.d(arrayLength),"Ciąg d:");
    }

    public static void runSorting(int division, int[] array,String text) {
        System.out.println("\n"+text);

        int [] arrayCopy = Arrays.copyOf(array, array.length); // Kopiuję pierwotny ciąg, aby każdy algorytm operował na tym samym.
        System.out.println(Sort.shellSort1Time(array)/ division);

        array = Arrays.copyOf(arrayCopy, arrayCopy.length);
        System.out.println(Sort.shellSort2Time(array)/ division);

        array = Arrays.copyOf(arrayCopy, arrayCopy.length);
        System.out.println(Sort.shellSort3Time(array)/ division);


    }
}