package datastructure.heap;

/**
 * @自定义_____________堆______
 */
public class Heap<T extends Comparable> {
    //存储堆中的元素
    private T[] items;
    //记录堆中元素个数
    private int N;

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity];
        this.N = 0;
    }

    /**
     * 判断堆中索引 i 处的元素是否小于 j 处元素
     */
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }
    /**
     * 交换堆中 i 索引处和 j 索引处元素
     */
    private void exch(int i, int j){
        T temp;
        temp = items[j];
        items[j] = items[i];
        items[i] = temp;
    }

    /**
     * 向堆中插入一个元素
     */
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    /**
     * 使用上浮算法，使索引 k 处的元素处于堆中正确的位置
     */
    private void swim(int k){
        //通过循环不断比较当前节点和其父节点的值，父节点比当前节点小就交换位置
        while (k > 1){
            if (less(k/2, k)){
                exch(k/2, k);
            }
            k = k / 2;
        }
    }

    /**
     * 使用下沉算法，使索引 k 处的元素处于堆中正确的位置
     */
    private void sink(int k){
        //循环对比当前 k 节点和其左右子节点2k和2k+1处元素中较大元素的大小，如果当前节点小就交换位置
        while (2*k <= N){
            int max;
            if (2*k+1 <= N){
                if (less(2*k, 2*k+1)){
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }
            }else {
                max = 2*k;
            }
            if (!less(k, max)){
                break;
            }
            exch(k, max);
            k = max;
        }
    }

    /**
     * 删除堆中最大元素，并返回这个最大元素
     */
    public T delMax(){
        T max = items[1];
        //交换索引 1 处和最大索引处的元素，让完全二叉树中最右侧元素变为临时根节点
        exch(1, N);
        //最大索引处元素删除
        items[N] = null;
        N--;
        //下沉算法让堆重新有序
        sink(1);
        return max;
    }
}
