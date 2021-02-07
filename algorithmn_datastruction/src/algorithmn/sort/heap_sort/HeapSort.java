package algorithmn.sort.heap_sort;

/**
 * 堆排序
 */
public class HeapSort {
    /**
     * 根据原数组source构造出堆heap
     */
    private static void createHeap(Comparable[] source, Comparable[] heap){
        //将source数组元素复制到heap中,得到一个无序堆heap
        System.arraycopy(source,0,heap,1,source.length);
        //对堆中元素进行下沉调整，从长度的一半开始，往索引1处下沉
        for (int i=heap.length/2; i>0; i--){
            sink(heap, i, heap.length-1);
        }
    }

    /**
     * 对source数组从小到大排序
     */
    public static void sort(Comparable[] source){
        //构建堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        //记录待排序元素最大索引
        int N = heap.length-1;
        //交换索引 1 处和最大待排序索引处的元素
        while (N != 1){
            exch(heap,1,N);
            N--;
            sink(heap,1,N);
        }
        //把heap元素复制回原数组source
        System.arraycopy(heap,1,source,0,source.length);
    }

    /**
     * 堆 target 处元素下沉，范围是 0~range
     */
    private static void sink(Comparable[] heap, int target, int range){
        while (target*2 <= range){
            //找出当前节点的较大子节点，将当前节点值替换为较大值
            int max = 0;
            if (target*2+1 <= range){
                if (less(heap, target*2, target*2+1)){
                    max = target * 2 + 1;
                }else {
                    max = target * 2;
                }
            }else {
                max = target * 2;
            }
            if (!less(heap, target, max)){
                break;
            }
            exch(heap, target, max);
            target = max;
        }
    }

    /**
     * 判断heap堆中索引 i 处的元素是否小于索引 j 处的元素
     */
    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j]) < 0;
    }
    /**
     * 交换heap堆中索引 i 处和索引 j 处的元素
     */
    private static void exch(Comparable[] heap, int i, int j){
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
