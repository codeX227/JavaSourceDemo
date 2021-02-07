package algorithmn.sort;

import algorithmn.sort.shell_sort.Shell;

import java.io.*;
import java.util.ArrayList;

public class SortCompare {
    public static void main(String[] args) throws Exception {
        //arrayList保存读取出来的数
        ArrayList<Integer> arrayList = new ArrayList();
        //BufferedReader读取数据
        BufferedReader reader =  new BufferedReader(new InputStreamReader(
                SortCompare.class.getClassLoader().getResourceAsStream("reverse.txt")));
        //读取的数据保存到集合
         String line = null;
         while ((line = reader.readLine()) != null){
            int i = Integer.parseInt(line);
            arrayList.add(i);
         }
         reader.close();

         Integer[] a = new Integer[arrayList.size()];
         arrayList.toArray(a);
        testInsertion(a);
        testShell(a);

    }
    //测试希尔排序
    private static void testShell(Integer[] a){
        long startTime = System.currentTimeMillis();
        Shell.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序的时间为" + (endTime-startTime) + "毫秒");
    }
    //测试插入排序
    private static void testInsertion(Integer[] a){
        long startTime = System.currentTimeMillis();
        Shell.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序的时间为" + (endTime-startTime) + "毫秒");
    }

}
