import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArraysGenerator {

    public static int[] getRandomArray(int lenght) {
        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1,lenght*2);
        }
        return array;
    }

    public static int[] getAscendingArray(int lenght) {
        int[] array = getRandomArray(lenght);
        Arrays.sort(array);
        return array;
    }


    public static int[] getDescendingArray(int lenght) {
        int[] array = getAscendingArray(lenght);
        for(int i = 0; i < array.length / 2; i++) { // odwracam array żeby z rosnącego uzyskać malejący
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
