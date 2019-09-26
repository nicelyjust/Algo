package tree;

import java.util.Arrays;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/9/25 15:08
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 9, 5, 8, 1, 0, 7, 3, 6, 4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        // 找出最后一个非叶子结点 --> (index -1)/2,变成大顶堆
        int start = (arr.length - 2) / 2;
        for (int i = start; i >= 0; i--) {
            maxHeap(arr,arr.length,i);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("========");
        for (int i = arr.length -1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr,i,0);
            System.out.println(Arrays.toString(arr));
        }
    }
    /**
     *
     * @param arr
     * @param size 需要处理的长度
     * @param index
     */
    public static void maxHeap(int[] arr ,int size,int index){

        int leftNode = 2 * index + 1;
        int rightNode = 2 * index + 2;

        //比较三者大小
        int max = index;
        if (leftNode < size && arr[leftNode] > arr[max]){
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }

        if (max != index){
            //交换位置
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            //移动的节点处还需排最大堆
            maxHeap(arr,size,max);
        }
    }
}
