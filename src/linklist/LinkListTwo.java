package linklist;

/**
 * @Desc 链表的循环,整表删除
 * @Author lizeng
 * @CreateTime 2019/9/6 11:04
 **/
public class LinkListTwo {
    public static void main(String[] args) {
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

        Node temp = node;
        while (temp.next != null) {
            System.out.println(temp.element);
            temp = temp.next;
        }
        System.out.println(temp.element);

        Node.printNode(node);
        // 整表删除
        Node firstNode = node;
        while (firstNode.next != null) {
            Node next = firstNode.next;
            firstNode.free();
            firstNode = next;
        }
        firstNode.free();
        Node.printNode(node);
    }

}
