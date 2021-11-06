package algorithm.array;

import algorithm.utils.CommonUtil;

import java.util.Arrays;

public class FindKLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = size - 1; j > i; j--) {
                if (nums[j] > nums[j - 1]) {
                    CommonUtil.swap(nums, j, j - 1);
                }
            }
        }

        return nums[k];
    }
}
