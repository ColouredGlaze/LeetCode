package problems.lmt.easy;

/**
 * 最长公共前缀
 *
 * @author MT-Lin
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		/**
		 * 编写一个函数来查找字符串数组中的最长公共前缀。
		 * 
		 * 如果不存在公共前缀，返回空字符串 ""。
		 * 
		 * 示例 1:
		 * 
		 * 输入: ["flower","flow","flight"] 输出: "fl"
		 * 
		 * 示例 2:
		 * 
		 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
		 * 
		 * 所有输入只包含小写字母 a-z 。
		 */
		System.out.println(mySolution(new String[] { "flower", "flow", "flight" }));
		System.out.println(betterSolution(new String[] { "flower", "flow", "flight" }));
	}

	public static String mySolution(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String prefix = "";
		prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].startsWith(prefix)) {
				continue;
			}
			while (prefix.length() > 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (strs[i].startsWith(prefix)) {
					break;
				}
			}
			if (prefix.length() <= 0) {
				return "";
			}
		}
		return prefix;
	}

	public static String betterSolution(String[] strs) {
		if (strs.length == 0)
			return "";
		String pre = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(pre) != 0)
				pre = pre.substring(0, pre.length() - 1);
		return pre;
	}
}
