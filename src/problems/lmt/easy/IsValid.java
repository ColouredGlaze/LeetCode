package problems.lmt.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有效的括号
 *
 * @author MT-Lin
 */
public class IsValid {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
         *
         * 有效字符串需满足：
         *
         * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
         *
         * 示例 1: 输入: "()" 输出: true
         *
         * 示例 2: 输入: "()[]{}" 输出: true
         *
         * 示例 3: 输入: "(]" 输出: false
         *
         * 示例 4: 输入: "([)]" 输出: false
         *
         * 示例 5: 输入: "{[]}" 输出: true
         */
        System.out.println(mySolution("{[]}"));
    }

    public static boolean mySolution(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        List<Character> cache = new ArrayList<>();
        List<Character> right = Arrays.asList(')', ']', '}');
        List<Character> left = Arrays.asList('(', '[', '{');
        Map<Character, Character> tmp = new HashMap<>();
        tmp.put(')', '(');
        tmp.put(']', '[');
        tmp.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            if (left.contains(s.charAt(i))) {
                cache.add(s.charAt(i));
            } else if (right.contains(s.charAt(i))) {
                if (cache.size() == 0) {
                    return false;
                }
                if (tmp.get(s.charAt(i)) != cache.get(cache.size() - 1)) {
                    return false;
                }
                cache.remove(cache.size() - 1);
            }
        }
        if (cache.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean betterSolution(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if (head == 0 || stack[--head] != '{')
                        return false;
                    break;
                case ')':
                    if (head == 0 || stack[--head] != '(')
                        return false;
                    break;
                case ']':
                    if (head == 0 || stack[--head] != '[')
                        return false;
                    break;
                default:
                    break;
            }
        }
        return head == 0;
    }

}
