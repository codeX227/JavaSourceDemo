package demos.collectiontest;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class CQueue {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int i = 0;
        while(n != 0){
            i += n&1;
            n >>>= 1;
        }

        return i;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        int i = cQueue.hammingWeight(00000000000000000000000000001011);
        System.out.println(i);
    }
}
