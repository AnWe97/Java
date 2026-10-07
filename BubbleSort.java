package Aufgaben;
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main (String[] args) {

        Random random = new Random();

        int[] array = new int[10];
        boolean unsorted = true;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Pre sort");
        System.out.println(Arrays.toString(array));

        while (unsorted) {

            boolean swapped = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {

                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;

                    swapped = true;
                }
            }

            if (!swapped){
                unsorted = false;
            }

        }

        System.out.println("After sort");
        System.out.println(Arrays.toString(array));

    }

}
