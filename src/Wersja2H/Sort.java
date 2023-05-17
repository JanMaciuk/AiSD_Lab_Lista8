package Wersja2H;

import java.util.ArrayList;

public class Sort {
    //Diagram działania algorytmu: https://eduinf.waw.pl/inf/alg/003_sort/0012.php
    public static void ShellSort1(int[] array, ArrayList<Integer> Hlist) {
        //Sortowanie do końca InsertSortem
        int h; // odstęp
        int iter = 1; // numer iteracji, używany do szukania indeksu nowego odstępu
        for (h = Hlist.get(Hlist.size()-iter); iter < Hlist.size(); iter++, h = Hlist.get(Hlist.size()-iter)){
            //System.out.println(h);
            for (int i = 0; i < array.length - h; i++) {
                int j = i + h;
                int currentElement = array[j];
                /*
                Jeżeli obecny element jest większy od poprzedniego (w odległości h),
                to zamieniam je miejscami, dopóki nie będzie na dobrym miejscu.
                 */
                while (j >= h && currentElement > array[j - h]) {
                    array[j] = array[j - h];
                    j -= h;
                }
                array[j] = currentElement;
            }
        }
    }

    public static void ShellSort2(int[] array, ArrayList<Integer> Hlist) {
        // Sortuje przy użyciu InsertSort, aż dojdę do h = 1, następnie sortuje całość poprzez BubbleSort
        int h; // odstęp
        int iter = 1; // numer iteracji, używany do szukania indeksu nowego odstępu
        for (h = Hlist.get(Hlist.size()-iter); iter < Hlist.size()-1; iter++, h = Hlist.get(Hlist.size()-iter)){
            for (int i = 0; i < array.length - h; i++) {
                int j = i + h;
                int currentElement = array[j];
                /*
                Jeżeli obecny element jest większy od poprzedniego (w odległości h),
                to zamieniam je miejscami, dopóki nie będzie na dobrym miejscu.
                 */
                while (j >= h && currentElement > array[j - h]) {
                    array[j] = array[j - h]; // Przenoszę prawy element na lewo
                    j -= h;
                }
                array[j] = currentElement; // Przenoszę element który wcześniej był po lewej na prawo (tak aby się zamieniły)
            }
        }
        //Array jest prawie posortowany, na koniec używam BubbleSorta:
        int end = array.length - 1;
        for (int i = 0; i < end; i++) {
            for (int j = end; j > i; j--) {

                if (array[j] > array[j - 1]) {

                    int replacedElement = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = replacedElement;
                }
            }
        }
    }


    public static void ShellSort3(int[] array, ArrayList<Integer> Hlist) {
        //Sortuje przy użyciu BubbleSort, aż dojdę do h = 1, następnie sortuje całość poprzez InsertSort
        int h; // odstęp
        int iter = 1; // numer iteracji, używany do szukania indeksu nowego odstępu
        for(h = Hlist.get(Hlist.size()-iter); iter < Hlist.size()-1; iter++, h = Hlist.get(Hlist.size()-iter)){

            for (int i = 0; i < array.length-1-h; i++) {

                for (int j = array.length-1; j >= h; j-=h) {

                    if (array[j] > array[j - h]) {

                        int replacedElement = array[j];
                        array[j] = array[j - h];
                        array[j - h] = replacedElement;
                    }
                }
            }
        }
        //Array prawie posortowany, ostatnie sortowanie wykonuje InsertSortem
        for(int i=0;i<array.length;++i){
            int j = i;
            while(j > 0 && array[j-1]<array[j]) { // Szukam odpowiedniego miejsca żeby wstawić następny element
                int currentElement = array[j];
                array[j] = array[j-1];
                array[j-1] = currentElement;
                j--;
            }
        }

    }


    public static long shellSort1Time(int[] array, ArrayList<Integer> Hlist) {
        System.out.print("Wersja 1:  ");
        long startTime = System.nanoTime();
        ShellSort1(array, Hlist);
        //printArray(array);
        return System.nanoTime() - startTime;
    }
    public static long shellSort2Time(int[] array, ArrayList<Integer> Hlist) {
        System.out.print("Wersja 2:  ");
        long startTime = System.nanoTime();
        ShellSort2(array, Hlist);
        //printArray(array);
        return System.nanoTime() - startTime;
    }
    public static long shellSort3Time(int[] array, ArrayList<Integer> Hlist) {
        System.out.print("Wersja 3:  ");
        long startTime = System.nanoTime();
        ShellSort3(array, Hlist);
        //printArray(array);
        return System.nanoTime() - startTime;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
