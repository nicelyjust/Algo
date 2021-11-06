package algorithm.linklist;

public class DeleteListNodeItem {
    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        if (head.val == val) {
            return head.next;
        }
        while (head.next != null) {
            ListNode listNode = head.next;
            if (listNode.val == val) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
        return node;
    }
    public ListNode deleteNode1(ListNode head, int val) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode node = listNode;
        while (listNode.next != null) {
            ListNode next = listNode.next;
            if (next.val == val) {
                listNode.next = listNode.next.next;
                break;
            }
            listNode = listNode.next;
        }
        return node.next;
    }
}
