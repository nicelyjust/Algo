package algorithm.sort;

import algorithm.utils.CommonUtil;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = new int[]{6, 5, 2, 7, 3, 9, 8, 4, 10, 1};
        System.out.println(Arrays.toString(ints));
        solution(ints);
        System.out.println(Arrays.toString(ints));

    }

    public static void solution(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序思想: 1.选择一个排头兵:P,从左向右找比P大的数,从又到左找比P小的数
     * 2.找到left和right的位置(直到left >= right).swap两者
     * 3.swap排头兵和left和right碰面的位置(left)
     * 4.分而治之,递归查找左右两个堆
     * 优化思路: 1.标兵随机;2.小范围用插入排序
     *
     */
    private static void sort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int left = low, right = high;
        int p = nums[left];

        while (left < right) {

            while (left < right && nums[right] >= p) {
                right--;
            }
            while (left < right && nums[left] <= p) {
                left++;
            }
            CommonUtil.swap(nums, left, right);

        }
        CommonUtil.swap(nums, low, left);

        sort(nums, low, left - 1);
        sort(nums, left + 1, high);
    }

    private static int partition(int[] nums, int left, int right) {

        return 0;
    }
}
