package algorithmn.sort.bubble_sort;

import java.util.Arrays;

public class BubbleTest {

    public static void main(String[] args) {
        /*
         * int[] array = {6,5,4,3,2,1};
         *
         * Integer继承了Comparable接口
         */
        Integer[] array = {6,5,4,3,2,1};
        Bubble.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
