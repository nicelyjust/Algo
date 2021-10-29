package algorithm.linklist;

public class ReverseLinkList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {

            temp = cur.next;
            // 当前节点的next指针指向前驱节点
            cur.next = prev ;
            prev = cur;
            cur = temp;

        }
        return prev;
    }
}
