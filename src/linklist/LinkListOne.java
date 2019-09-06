package linklist;


/*
 *  @描述：使用单链表实现堆栈;链表反转示例;
 */
public class LinkListOne {
    public static void main(String[] args){
        /*LinkListStack<String> stack = new LinkListStack<>();
        stack.push("Q");
        stack.push("W");
        stack.push("E");
        stack.push("R");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.pop());*/

        Node<String> node = new Node<>();
        node.element = "Q";
        Node<String> node1 = new Node<>();
        node1.element = "W";
        Node<String> node2 = new Node<>();
        node2.element = "E";
        Node<String> node3 = new Node<>();
        node3.element = "R";

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        printNode(node);
        Node<String> reverse = reverse(node);
        printNode(reverse);
    }

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

    public static <T> void printNode(Node<T> node){
        StringBuilder builder = new StringBuilder();
        while (node.next != null) {
            builder.append(node.element);
            node = node.next;
        }
        builder.append(node.element);
        System.out.println(builder.toString());
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
