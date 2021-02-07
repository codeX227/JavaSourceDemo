package algorithmn.sort.quick_sort;

/**
 * 快速排序
 */
public class Quick {

    //对数组元素排序
    public static void sort(Comparable[] a){
        int low = 0;
        int high = a.length-1;
        sort(a, low, high);
    }

    //对数组 a 中从 low 到 high 索引的元素
    private static void sort(Comparable[] a, int low, int high){
        //安全校验
        if (low > high){
            return;
        }
        //对数组 low 到 high 的元素分组
        int partition = partition(a, low, high);
        //让左边有序
        sort(a, low, partition-1);
        //让右边有序
        sort(a, partition+1, high);
    }
    //对数组 a 中，从索引low到high的元素分组，同时使 a 有序，返回分组界限对应索引
    private static int partition(Comparable[] a, int low, int high){
        //确定分界值
        Comparable key = a[low];
        //两个指针分别指向最小索引处和最大索引处+1的位置
        int left = low;
        int right = high+1;
        //切分
        while (true){
            //从右向左扫描，左移 right 指针，找到第一个小于分界值key 的元素停止
            while (less(key, a[--right])){
                //如果 right 移动到最左端都没有找到，结束循环
                if (right <= low)
                    break;
            }
            //从左向右扫描，右移 left 指针，找到第一个大于分界值key 的元素停止
            while (less(a[++left], key)){
                //如果 left 移动到最右端都没有找到，结束循环
                if (left >= high)
                    break;
            }

            //当left >= right说明元素扫描完毕，结束循环，否则交换元素
            if (left >= right){
                break;
            }else {
                exch(a, left, right);
            }
        }
        //交换分界值
        exch(a, low, right);
        return right;
    }


    //比较元素 v 是否小于 w
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    //交换元素i和j位置
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
