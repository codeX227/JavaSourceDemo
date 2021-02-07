package algorithmn.sort.select_sort;

/**
 * 选择排序
 * 找出最小元素，将最小元素插入第一个位置
 *
 */
public class Selection {
    //对数组a元素排序
    public static void sort(Comparable[] a){
        //当只有最后两个元素时不需要找最小元素
        for (int i=0; i < a.length-2; i++){
            //先将第一个元素作为最小元素
            int minIndex = i;
            //找出最小元素
            for (int j=i+1; j<a.length; j++){
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            //将最小元素与索引为 i 的元素交换
            exch(a, i, minIndex);
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
