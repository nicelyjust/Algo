package linklist;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/9/6 17:46
 **/
public class DNode<T> {
        public DNode<T> prev;
        public DNode<T> next;
        public T element;

        public DNode(DNode<T> prev, DNode<T> next, T element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }

}
