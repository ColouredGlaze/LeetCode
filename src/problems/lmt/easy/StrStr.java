package problems.lmt.easy;

/**
 * 实现strStr()
 *
 * @author MT-Lin
 * @date 2018/05/14
 */
public class StrStr {

    public static void main(String[] args) {
        /**
         * 实现 strStr() 函数。
         *
         * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
         *
         * 示例 1:
         *
         * 输入: haystack = "hello", needle = "ll"
         * 输出: 2
         * 示例 2:
         *
         * 输入: haystack = "aaaaa", needle = "bba"
         * 输出: -1
         * 说明:
         *
         * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
         *
         * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
         */
        System.out.println(mySolution("mississippi", "issi"));
    }

    public static int mySolution(String haystack, String needle){
        if (null == needle || "".equals(needle)){
            return 0;
        }
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        for (int i = 0; i < haystackChar.length; i++) {
            if (haystackChar[i] == needleChar[0]){
                int temp = i;
                int j = 1;
                i++;
                for (; j < needleChar.length && i < haystackChar.length; j++, i++) {
                    if (haystackChar[i] != needleChar[j]) {
                        break;
                    }
                }
                if (j == needleChar.length) {
                    return temp;
                }
                i = temp;
            }
        }
        return -1;
    }

    public static int betterSolution(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
