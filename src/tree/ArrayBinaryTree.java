package tree;

/**
 * @Desc 顺序结构去存储二叉树,
 * 1.index与左右结点关系:2*index+1,2*index+2;
 * 2.父结点:(index-1)/2(index从0开始)
 * @Author lizeng
 * @CreateTime 2019/9/24 11:16
 **/
public class ArrayBinaryTree {
    private int[] arr;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6,7};
        ArrayBinaryTree binaryTree = new ArrayBinaryTree(arr);
        binaryTree.preOder();
    }

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOder(){
        preOder(0);
    }
    public void preOder(int index){
        if (arr == null || index >= arr.length) {
            return;
        }
        int element = arr[index];
        System.out.println(element);
        if (2*index+1 < arr.length){
            preOder(2*index+1);
        }
        if (2 * index + 2 < arr.length) {
            preOder(2*index+2);
        }
    }
}
