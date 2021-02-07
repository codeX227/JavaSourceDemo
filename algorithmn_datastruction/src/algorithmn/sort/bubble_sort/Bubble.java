package algorithmn.sort.bubble_sort;

/**
 * 冒泡排序
 * 从小到大排序
 */
public class Bubble {
    //对数组a元素排序
    public static void sort(Comparable[] a){
        //6个元素，5次循环
        for (int i = a.length-1; i > 0; i--){
            for (int j=0; j<i; j++){
                //比较j和j+1处的值
                if (greater(a[j], a[j+1])){
                    exch(a, j, j+1);
                }
            }
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
