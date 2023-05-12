public class Sort {
    //TODO: implement ShellSort using BubbleSort
    //Diagram działania algorytmu: https://eduinf.waw.pl/inf/alg/003_sort/0012.php
    public static void ShellSort1(int[] array) {
        //Sortowanie do końca InsertSortem
        for (int h = array.length / 2; h > 0; h /= 2){
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

    public static void ShellSort2(int[] array) {
        // Sortuje przy użyciu InsertSort, aż dojdę do h = 1, następnie sortuje całość poprzez BubbleSort
        for (int h = array.length / 2; h > 1; h /= 2){
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

    //TODO: implement ShellSort using BubbleSort
    public static void ShellSort3(int[] array) {
        //ShellSort implementation using BubbleSort

    }


    public static long shellSort1Time(int[] array) {
        System.out.print("ShellSort:  ");
        long startTime = System.nanoTime();
        ShellSort1(array);
        //printArray(array);
        return System.nanoTime() - startTime;
    }
    public static long shellSort2Time(int[] array) {
        System.out.print("ShellSort:  ");
        long startTime = System.nanoTime();
        ShellSort2(array);
        //printArray(array);
        return System.nanoTime() - startTime;
    }
    public static long shellSort3Time(int[] array) {
        System.out.print("ShellSort:  ");
        long startTime = System.nanoTime();
        ShellSort3(array);
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
