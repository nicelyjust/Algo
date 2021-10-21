package algorithm.linklist;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Tail2Head {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        int[] result = reversePrint(listNode1);
        System.out.println(Arrays.toString(result));
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 辅助数组方法：
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0];
        ListNode cur = head;
        int length = 1;
        while(cur.next != null){
            cur = cur.next;
            length++;
        }
        cur = head;
        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = cur.val;
            cur = cur.next;
        }
        return result;
    }
    /**
     * 辅助栈
     */
    public static int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int size = stack.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = stack.pop();
        }
        return ints;
    }

}
