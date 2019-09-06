package linklist;

/**
 * @Desc  双向链表
 * @Author lizeng
 * @CreateTime 2019/9/6 16:52
 **/
public class DoubleLinkList<T> {
    private DNode<T> mHead;
    private int size;

    public DoubleLinkList() {
        mHead = new DNode<>(null,null,null);
        mHead.next = mHead.prev = mHead;
    }

    /**
     *  tail 添加新元素
     * @param t element
     */
    public void appendLast(T t){
        DNode<T> dNode = new DNode<>(mHead.prev,mHead,t);
        mHead.prev = dNode;
        mHead.prev.next = dNode;
        size++;
    }

    public void insert(int index,T t){
        if (index == 0) {

        }
    }
}
