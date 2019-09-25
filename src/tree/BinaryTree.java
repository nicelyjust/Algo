package tree;

/**
 * 树实现的存储结构:顺序存储,链式存储
 * @Desc 二叉树 数据结构
 * @Author lizeng
 * @CreateTime 2019/9/9 15:46
 **/
public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> rootNode;

    public BinaryTree() {
    }
    public void setRoot(TreeNode<T> rootNode) {
        this.rootNode = rootNode;
    }


    public void preOder() {
        if (rootNode != null) {
            rootNode.preOder();
        }
    }

    public void midOder() {
        if (rootNode != null) {
            rootNode.midOder();
        }
    }

    public void afterOder() {
        if (rootNode != null) {
            rootNode.afterOder();
        }
    }

    public TreeNode<T> frontSearch(T i) {
        if (rootNode != null) {
           return rootNode.frontSearch(i);
        }
        return null;
    }
}
