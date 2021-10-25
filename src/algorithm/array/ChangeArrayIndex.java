package algorithm.array;

import algorithm.utils.CommonUtil;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class ChangeArrayIndex {

    public static void main(String[] args) {

    }

    /**
     * 快慢指针
     * 先找出第一位偶数,往后再去找奇数,找到奇数再交换
     */
    public int[] exchange(int[] nums) {
        int i = 0;
        int length = nums.length;
        while (i < nums.length && (nums[i] & 1) == 1) {
            i++;
        }
        int j = i + 1;
        while (j < length) {
            if ((nums[j] & 1) == 1) {
                CommonUtil.swap(nums, i, j);
                i++;
            }
            j++;
        }

        return nums;
    }


    /**
     * 首尾指针
     */
    public int[] exchange1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            CommonUtil.swap(nums, left, right);
        }
        return nums;
    }
}
