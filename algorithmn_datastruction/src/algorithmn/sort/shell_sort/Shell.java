package algorithmn.sort.shell_sort;

/**
 * 希尔排序
 * 插入排序的优化算法
 * 加入偏移量 h 实现分组排序
 */
public class Shell {

    //对数组a元素排序
    public static void sort(Comparable[] a) {
        //1.通过数组a的长度，确定增量h的初始值
        int h = 1;
        while (h < a.length/2){
            h = 2 * h + 1;
        }
        //2.排序
        while (h >= 1){
            //找到要插入的元素
            for (int i=h; i < a.length; i++){
                //以偏移量 h 依次比较，将索引 j 处元素插入到比它大的元素之前，比他小的元素之后
                for (int j=i; j>=h; j-=h){
                    if (greater(a[j-h], a[j])){
                        exch(a, j-h, j);
                    }else {
                        //已经插入到合适位置，结束循环
                        break;
                    }
                }
            }
            //减小h的值
            h = h / 2;
        }
    }
    //判断v是否大于w
    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }
    //交换元素i和j位置
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
