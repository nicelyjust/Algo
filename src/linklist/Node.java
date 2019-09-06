package linklist;

/**
 * @Desc 单链表
 * @Author lizeng
 * @CreateTime 2019/9/6 11:03
 **/
public class Node<E> {
    public E element;
    public Node<E> next;

    public void free() {
        element = null;
        next = null;
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
}
