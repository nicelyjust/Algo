package algorithm.linklist;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 给你非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 难度:中等
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 解题思路：模拟竖式相加流程即可
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
            }
            if (l2 != null) {
                val2 = l2.val;
            }
            int value = val1 + val2 + carry;
            carry = value % 10;
            if (head == null) {
                head = tail = new ListNode(value / 10);
            } else {
                tail.next = new ListNode(value / 10);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
