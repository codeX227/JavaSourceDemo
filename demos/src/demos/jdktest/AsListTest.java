package demos.jdktest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsListTest {
    public static void main(String[] args) {
        int[] myArray = { 1, 2, 3 };
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//数组地址值
        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int [] array=(int[]) myList.get(0);
        System.out.println(array[0]);//1

        Integer[] myArray2 = { 1, 2, 3 };
        List myList2 = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//1
        System.out.println(myList.get(1));//2
        int [] array2=(int[]) myList.get(0);
        System.out.println(array[0]);//1

        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
    }
}
