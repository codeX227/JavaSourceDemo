package algorithmn.sort.insert_sort;

/**
 * 插入排序
 * 从第二个元素开始，将第 i 个元素插入到前面比它大的元素前，比它小的元素后
 */
public class Insertion {
    //对数组a元素排序
    public static void sort(Comparable[] a){
        for (int i=1; i<a.length; i++){
            //将索引 i 处元素插入到比它大的元素之前，比他小的元素之后
            for (int j=i; j>0; j--){
                if (greater(a[j-1], a[j])){
                    exch(a, j-1, j);
                }else {
                    break;
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
