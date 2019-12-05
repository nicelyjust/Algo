package algorithm.tree;

/**
 * @Desc 二叉树前序中序后序遍历
 * @Author lizeng
 * @CreateTime 2019/9/9 16:09
 **/
public class TestBinaryTree{
    public static void main(String[] args) {
        BinaryTree<Integer> binTree = new BinaryTree<>();
        TreeNode<Integer> rootNode = new TreeNode<>(1);
        binTree.setRoot(rootNode);
        TreeNode<Integer> left = new TreeNode<>(2);
        rootNode.setLeft(left);
        TreeNode<Integer> right = new TreeNode<>(3);
        rootNode.setRight(right);

        left.setLeft(new TreeNode<>(4));
        left.setRight(new TreeNode<>(5));

        right.setLeft(new TreeNode<>(6));
        right.setRight(new TreeNode<>(7));

        binTree.preOder();
        System.out.println("=============");
        binTree.midOder();
        System.out.println("=============");
        binTree.afterOder();

        TreeNode<Integer> treeNode = binTree.frontSearch(2);
        System.out.println("结点" + treeNode.value + "; 左结点" + treeNode.getLeft().value + "; 右结点" + treeNode.getRight().value);
    }

}
