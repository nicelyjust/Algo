package algorithm.array;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/9/29 11:32
 **/
public class BinarySort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,6};
        System.out.println(binarySort(arr,arr.length,2));
    }

    private static int binarySort(int[] arr, int length, int key) {
        int start = 0, end = length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -(start+1);
    }
}
