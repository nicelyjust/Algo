package tree;

/**
 * 树实现的存储结构:顺序存储,链式存储
 * @Desc 二叉树 数据结构
 * @Author lizeng
 * @CreateTime 2019/9/9 15:46
 **/
public class BinaryTree<T extends Comparable<T>> {
    public BinaryTree<T> left;
    public BinaryTree<T> right;
    public T data;

    public BinaryTree() {
    }
    public BinaryTree(T data) {
        this(null,null,data);
    }
    public BinaryTree(BinaryTree<T> left, BinaryTree<T> right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    /**
     * 判断是否是叶子结点
     * @return
     */
    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }
}
