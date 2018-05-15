package problems.lmt.easy;

/**
 * 搜索插入位置
 *
 * @author MT-Lin
 * @date 2018/05/15
 */
public class SearchInsert {
    public static void main(String[] args) {
        /**
         * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
         *
         * 你可以假设数组中无重复元素。
         *
         * 示例 1: 输入: [1,3,5,6], 5 输出: 2
         * 示例 2: 输入: [1,3,5,6], 2 输出: 1
         * 示例 3: 输入: [1,3,5,6], 7 输出: 4
         * 示例 4: 输入: [1,3,5,6], 0 输出: 0
         */
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(mySolution(nums, target));
    }

    public static int mySolution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    public static int betterSolution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int middle = (left + right) / 2;
            int cmp = nums[middle] - target;
            if (cmp < 0) {
                left = middle + 1;
            } else if (cmp > 0) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        if (nums[left] > target) {
            return left;
        } else if (nums[right] < target){
            return right + 1;
        } else if (nums[left] == target) {
            return left;
        } else {
            return right;
        }
    }
}
