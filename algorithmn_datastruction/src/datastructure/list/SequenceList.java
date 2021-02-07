package datastructure.list;

import java.util.Iterator;

/**
 * @自制ArrayList顺序表
 * @param <T>
 */
public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] array;
    //记录当前顺序表元素个数
    private int N;

    /**
     * 构造方法
     * @param capacity 初始化数组的大小
     */
    public SequenceList(int capacity){
        //初始化数组
        this.array = (T[]) new Object[capacity];
        //初始化数组长度
        this.N = 0;
    }
    /**
     * 将线性表置为空表
     */
    public void clear(){
        this.N = 0;
    }
    /**
     * 判断当前线性表是否为空表
     */
    public boolean isEmpty(){
        return N == 0;
    }
    /**
     * 获取线性表长度
     */
    public int length(){
        return N;
    }
//    数组长度
//    public int arrayLength(){
//        return array.length;
//    }

    /**
     * 获取指定位置处元素
     * @param i
     */
    public T get(int i){
        return array[i];
    }

    /**
     * 向线性表中添加元素
     * @param t
     */
    public void insert(T t){
        //扩容
        if (N == array.length){
            resize(array.length * 2);
        }
        array[N++] = t;
    }

    /**
     * 在索引 i 处插入元素 t
     * @param i
     * @param t
     */
    public void insert(int i, T t){
        //扩容
        if (N == array.length){
            resize(array.length * 2);
        }
        //先将 i 及其以后元素后移
        for (int index=N-1; index>=i; index--){
            array[index+1] = array[index];
        }
        array[i] = t;
        //元素个数+1
        N++;
    }

    /**
     * 删除指定索引 i 处元素，并返回该元素
     * @param i
     */
    public T remove(int i){
        //记录要删除的元素
        T current = array[i];
        //将 i 之后元素前移一位
        for (int index=i; index<N-1; index++){
            array[index] = array[index+1];
        }
        //元素个数 -1
        N--;
        //元素个数小于数组长度1/4，缩容为原来一半
        if (N < array.length/4){
            resize(array.length / 2);
        }
        return current;
    }

    /**
     * 查找指定 t 元素第一次出现的位置
     * @param t
     */
    public int indexOf(T t){
        for (int i=0; i<N; i++){
            if (array[i].equals(t))
                return i;
        }
        return -1;
    }

    /**
     * 重置数组大小
     * @param newSize
     */
    public void resize(int newSize){
        //临时数组
        T[] temp = array;
        //创建新数组并拷贝元素
        array = (T[]) new Object[newSize];
        for (int i=0; i<N; i++){
            array[i] = temp[i];
        }
    }

    /**
     * 返回一个迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int cusor;
        public SIterator(){
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return array[cusor++];
        }
    }
}
