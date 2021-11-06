package algorithm.array;

import algorithm.utils.CommonUtil;

import java.util.Arrays;

public class FindMinusK {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{1, 5, 3, 4, 2}, 2)));
    }

    /**
     * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * 思路一:对数组排序,
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int size = arr.length;
        if (k >= size) {
            return arr;
        }
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    CommonUtil.swap(arr, i, j);
                }
            }
        }
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = arr[i];
        }
        return results;
    }

    public static int[] getLeastNumbers1(int[] arr, int k) {
        int size = arr.length;
        for (int i = 0; i < k; i++) {
            for (int j = size - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    CommonUtil.swap(arr, j, j - 1);
                }
            }
        }
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = arr[i];
        }
        return results;
    }
}
