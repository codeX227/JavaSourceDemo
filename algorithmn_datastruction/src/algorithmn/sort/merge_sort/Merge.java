package algorithmn.sort.merge_sort;

/**
 * 归并排序
 *
 * 递归将数组分为两部分，分别对两部分归并排序
 *
 */
public class Merge {

    //归并所需要的辅助数组
    private static Comparable[] assist;

    //对数组 a 排序
    public static void sort(Comparable[] a){
        //初始化辅助数组
        assist = new Comparable[a.length];
        //初始化 low 和 high 分别记录数组中最小索引和最大索引
        int low = 0;
        int high = a.length-1;
        //调用sort重载方法，对数组 a 中 low 到 high 元素排序
        sort(a, low, high);
    }
    //对数组 a 中从 low 到 high 的元素排序
    private static void sort(Comparable[] a, int low, int high){
        //安全校验
        if (low > high){
            return;
        }
        //将数组 a 以 mid 为界分为两组
        int mid = (low + high) / 2;
        //分别对两组排序
        sort(a, low, mid);
        sort(a, mid+1, high);
        //两边排序完成后归并
        merge(a, low, mid, high);
    }
    //对数组 a 中 low 到 mid 为一组，mid+1 到 high 为一组，对两组归并
    private  static void merge(Comparable[] a, int low,int mid, int high){
        //初始化 3 个指针
        int p1 = low;
        int p2 = high;
        int i = low;
        //遍历，移动 p1 p2，比较对应指针的值，小的放到辅助数组的对应索引处
        while (p1<=mid && p2<=high){
            if (less(a[p1], a[p2])){
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }
        //遍历，如果 p1 没有走完，顺序移动 p1 指针，把元素放到辅助数组对应索引处
        while (p1 <= mid){
            assist[i++] = a[p1++];
        }
        //遍历，如果 p2 没有走完，顺序移动 p2 指针，把元素放到辅助数组对应索引处
        while (p2 <= high){
            assist[i++] = a[p2];
        }
        //把辅助数组元素依次复制到原数组中
        for (int index=low; index<=high; index++){
            a[index] = assist[index];
        }
    }

    //比较元素 v 是否 小于 m
    private static boolean less(Comparable v, Comparable m){
        return v.compareTo(m) < 0;
    }
    //交换元素i和j位置
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
