package algorithm.linklist;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 */
public class KthFromEnd {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针，快指针先走K步,然后快慢指针一起走
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode low = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 边界用例子代入
        while (fast != null){
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}
