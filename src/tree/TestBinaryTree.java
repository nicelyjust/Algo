package tree;

/**
 * @Desc 二叉树前序中序后序遍历
 * @Author lizeng
 * @CreateTime 2019/9/9 16:09
 **/
public class TestBinaryTree{
    public static void main(String[] args) {
        BinaryTree<Integer> binTree = new BinaryTree<>(1);
        BinaryTree<Integer> left = new BinaryTree<>(2);
        binTree.setLeft(left);
        BinaryTree<Integer> right = new BinaryTree<>(3);
        binTree.setRight(right);

        left.setLeft(new BinaryTree<>(4));
        left.setRight(new BinaryTree<>(5));

        right.setLeft(new BinaryTree<>(6));
        right.setRight(new BinaryTree<>(7));
        binTree.preOder();
        System.out.println("=============");
        binTree.midOder();
        System.out.println("=============");
        binTree.afterOder();

    }

}
