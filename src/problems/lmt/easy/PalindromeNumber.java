package problems.lmt.easy;

/**
 * 回文数
 *
 * @author MT-Lin
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		/**
		 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
		 * 
		 * 示例 1:
		 * 
		 * 输入: 121 输出: true 示例 2:
		 * 
		 * 输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。 示例 3:
		 * 
		 * 输入: 10 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。
		 */
		System.out.println(mySolution(131));
		System.err.println(betterSolution(10));
	}

	public static boolean mySolution(int x) {
		if (x < 0) {
			return false;
		}
		String strx = String.valueOf(x);
		return strx.equals(new StringBuffer(strx).reverse().toString());
	}

	public static boolean betterSolution(int x) {

		if (x < 0) {
			return false;
		} else if (x / 10 == 0) {
			return false;
		} else {
			int a = 0;
			int b = x;
			while (x != 0) {
				a = a * 10 + x % 10;
				x = x / 10;
			}
			if (a == b) {
				return true;
			} else {
				return false;
			}
		}
	}
}
