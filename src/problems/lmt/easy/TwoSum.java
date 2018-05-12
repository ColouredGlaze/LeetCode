package problems.lmt.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和
 *
 * @author MT-Lin
 */
public class TwoSum {

	public static void main(String[] args) {
		/**
		 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
		 * 
		 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
		 * 
		 * 示例:
		 * 
		 * 给定 nums = [2, 7, 11, 15], target = 9
		 * 
		 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
		 */
		int[] a = { 3, 2, 4 };
		System.out.println(mySolution(a, 6));
	}

	public static int[] mySolution(int[] nums, int target) {
		int[] result = { 0, 0 };
		Map<Integer, List<Integer>> numsMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			if (!numsMap.containsKey(nums[i])) {
				numsMap.put(nums[i], new ArrayList<>());
			}
			numsMap.get(nums[i]).add(i);
		}
		for (Integer key : numsMap.keySet()) {
			if (numsMap.containsKey(target - key)) {
				if (numsMap.get(key).size() > 1) {
					result[0] = numsMap.get(key).get(0);
					result[1] = numsMap.get(key).get(1);
				} else {
					result[0] = numsMap.get(key).get(0);
					result[1] = numsMap.get(target - key).get(0);
				}
				break;
			}
		}
		return result;
	}

	public static int[] betterSolution(int[] nums, int target) {
		int numMin = Integer.MAX_VALUE;
		int numMax = Integer.MIN_VALUE;

		for (int num : nums) {
			if (num < numMin) {
				numMin = num;
			}

			if (num > numMax) {
				numMax = num;
			}
		}

		int max = target - numMin;
		int min = target - numMax;

		int targetMax = max > numMax ? numMax : max;
		int targetMin = min < numMin ? numMin : min;

		int[] numIndices = new int[targetMax - targetMin + 1];

		for (int i = 0; i <= numIndices.length - 1; i++) {
			numIndices[i] = -1;
		}

		for (int i = 0; i <= nums.length - 1; i++) {
			if (nums[i] >= targetMin && nums[i] <= targetMax) {
				int offset = -targetMin;
				if (numIndices[(target - nums[i]) + offset] != -1) {
					return new int[] { numIndices[(target - nums[i]) + offset], i };
				} else {
					numIndices[nums[i] + offset] = i;
				}
			}
		}
		return new int[] { 0, 0 };
	}
}
