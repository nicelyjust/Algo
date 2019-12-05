package algorithm.tree;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/9/19 10:53
 **/
public class TreeNode<T extends Comparable<T>> {
    public T value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
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
        System.out.println(value);
        if (left != null) {
            left.preOder();
        }
        if (right != null) {
            right.preOder();
        }
    }
    public void midOder(){
        if (left != null) {
            left.midOder();
        }
        System.out.println(value);
        if (right != null) {
            right.midOder();
        }
    }
    public void afterOder(){
        if (left != null) {
            left.afterOder();
        }
        if (right != null) {
            right.afterOder();
        }
        System.out.println(value);
    }

    public TreeNode<T> frontSearch(T value) {
        if (this.value == value) {
            return this;
        }
        TreeNode<T> tTreeNode = null;
        if (left != null) {
            tTreeNode = left.frontSearch(value);
        }
        if (tTreeNode != null)
            return tTreeNode;
        if (right != null) {
            tTreeNode = right.frontSearch(value);
        }
        return tTreeNode;
    }
}
