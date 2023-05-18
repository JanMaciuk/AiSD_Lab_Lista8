package Wersja2H;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int div = 1000;  // dzielenie z nanosekund: 100=mikrosekundy, 1000000=milisekundy.
        int arrayLength = 10000;
        System.out.println("Czasy w 1/10 mikrosekundy");
        System.out.println("dla ciągu o długości: "+arrayLength);

        runSorting(div, RandomArraysGenerator.getRandomArray(arrayLength),"Ciąg a:", RandomArraysGenerator.a(arrayLength));
        runSorting(div, RandomArraysGenerator.getRandomArray(arrayLength),"Ciąg b:", RandomArraysGenerator.b(arrayLength));
        runSorting(div, RandomArraysGenerator.getRandomArray(arrayLength),"Ciąg c:", RandomArraysGenerator.c(arrayLength));
        runSorting(div, RandomArraysGenerator.getRandomArray(arrayLength),"Ciąg d:", RandomArraysGenerator.d(arrayLength));
        runSorting(div, RandomArraysGenerator.getRandomArray(arrayLength),"Ciąg dodatkowy:", RandomArraysGenerator.dodatkowy(arrayLength));
    }

    public static void runSorting(int division, int[] array,String text, ArrayList<Integer> Hlist) {
        System.out.println("\n"+text);

        int [] arrayCopy = Arrays.copyOf(array, array.length); // Kopiuję pierwotny ciąg, aby każdy algorytm operował na tym samym.
        System.out.println(Sort.shellSort1Time(array,Hlist)/ division);

        array = Arrays.copyOf(arrayCopy, arrayCopy.length);
        System.out.println(Sort.shellSort2Time(array,Hlist)/ division);

        array = Arrays.copyOf(arrayCopy, arrayCopy.length);
        System.out.println(Sort.shellSort3Time(array,Hlist)/ division);


    }
}