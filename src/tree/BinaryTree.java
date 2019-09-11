package tree;

/**
 * 树实现的存储结构:顺序存储,链式存储
 * @Desc 二叉树 数据结构
 * @Author lizeng
 * @CreateTime 2019/9/9 15:46
 **/
public class BinaryTree<T extends Comparable<T>> {
    private BinaryTree<T> left;
    private BinaryTree<T> right;
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

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    /**
     * 判断是否是叶子结点
     * @return
     */
    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    public void preOder(){

    }
    public void midOder(){
        System.out.println(data);
    }
    public void afterOder(){

    }
}
