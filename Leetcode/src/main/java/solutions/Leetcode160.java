package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表的第一个公共节点
 */
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();
        for(ListNode node1=headA; node1!=null; node1=node1.next){
            set.add(node1);
        }
        for(ListNode node2=headB; node2!=null; node2=node2.next){
            if(set.contains(node2)){
                return node2;
            }
        }
        return null;
    }
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
     }
}
