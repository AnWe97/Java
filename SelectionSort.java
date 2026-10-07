package Aufgaben;

import java.util.Random;
import java.util.ArrayList;

public class SelectionSort {
    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> sorted_array = new ArrayList<>();
        boolean unsorted = true;

        for (int i = 0; i < 10; i++) {
            array.add(random.nextInt(100));
        }

        System.out.println("Pre sort");
        System.out.println(array);

        while (unsorted) {

            int smallest_element_index = 0;

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < array.get(smallest_element_index)){
                    smallest_element_index = i;
                }
            }

            sorted_array.add(array.get(smallest_element_index));
            array.remove(array.get(smallest_element_index));

            if (array.isEmpty()) {unsorted = false;}

        }

        System.out.println("After sort");
        System.out.println(sorted_array);

    }
}
