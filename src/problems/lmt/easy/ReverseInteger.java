package problems.lmt.easy;

/**
 * 反转整数
 *
 * @author MT-Lin
 */
public class ReverseInteger {

	public static void main(String[] args) {
		/**
		 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
		 * 
		 * 示例 1:
		 * 
		 * 输入: 123 输出: 321 示例 2:
		 * 
		 * 输入: -123 输出: -321 示例 3:
		 * 
		 * 输入: 120 输出: 21 注意:
		 * 
		 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
		 */
		System.out.println(betterSolution(2147483641));
	}

	public static int mySolution(int x) {
		String strX = String.valueOf(x);
		StringBuilder sb = new StringBuilder(strX);
		StringBuilder sbr = sb.reverse();
		long result = 0;
		if ('-' == sbr.charAt(strX.length() - 1)) {
			sbr = sbr.replace(strX.length() - 1, strX.length(), "");
			result = 0 - Long.valueOf(sbr.toString());
		} else {
			result = Long.valueOf(sbr.toString());
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		} else {
			return (int) result;
		}
	}

	public static int betterSolution(int x) {
		int output = 0;

		while (true) {
			if (x == 0) {
				return x;
			}

			output = output * 10 + x % 10;

			if ((x /= 10) == 0) {
				return output;
			}

			if (output > 214748364 || output < -214748364) {
				return 0;
			}
		}
	}
}
