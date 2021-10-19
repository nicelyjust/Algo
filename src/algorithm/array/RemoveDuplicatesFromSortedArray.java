package algorithm.array;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 解题思路: 读题 升序数组
 * 双指针方法:快慢指针,将不重复的元素移到左侧
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

    }

    private static int removeDuplicate(int[] nums) {
        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

}
