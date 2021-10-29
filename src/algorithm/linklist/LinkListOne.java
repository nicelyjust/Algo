package algorithm.linklist;


import static algorithm.linklist.Node.printNode;

/*
 *  @描述：使用单链表实现堆栈;链表反转示例;
 */
public class LinkListOne {
    public static void main(String[] args){
        /*LinkListStack<String> algorithm.stack = new LinkListStack<>();
        algorithm.stack.push("Q");
        algorithm.stack.push("W");
        algorithm.stack.push("E");
        algorithm.stack.push("R");

        System.out.println(algorithm.stack.pop());
        System.out.println(algorithm.stack.pop());
        System.out.println(algorithm.stack.pop());
        System.out.println(algorithm.stack.pop());

        System.out.println(algorithm.stack.pop());*/

        Node<Integer> node = new Node<>();
        node.element = 1;
        Node<Integer> node1 = new Node<>();
        node1.element = 2;
        Node<Integer> node2 = new Node<>();
        node2.element = 3;
        Node<Integer> node3 = new Node<>();
        node3.element = 4;

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        printNode(node);
        Node<Integer> reverse = reverse(node);
        printNode(reverse);
    }

    /**
     * 陷入细节就乱,
     */
    public static <T> Node<T> reverse(Node<T> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<T> reverse = reverse(node.next);
        printNode(reverse);
        node.next.next = node;
        node.next = null;
        return reverse;
    }

    public static <T> Node<T> reverse1(Node<T> head) {
        Node<T> prev = null;
        Node<T> next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }
        return prev;
    }


    class LinkListStack<T> {
        //当前节点
        private Node<T> mNode;

        public LinkListStack() {
        }

        public void push(T t){
            Node<T>  oldNode = mNode;
            mNode = new Node<>();
            mNode.element = t;
            mNode.next = oldNode;
        }

        public T pop(){
            T value = null;
            if (!isEmpty()) {
                value = mNode.element;
                mNode = mNode.next;
            }
            return value;
        }

        private boolean isEmpty() {
            return mNode == null;
        }
    }
}
