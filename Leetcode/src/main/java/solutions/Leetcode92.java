package solutions;

/**
 * @Description 反转链表Ⅱ
 * @Author Goodenough
 * @Date 2021/3/13 16:22
 */
public class Leetcode92 {

    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if (left == 1) {
            return reverseN(head, right);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
