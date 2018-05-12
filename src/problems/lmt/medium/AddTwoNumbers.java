package problems.lmt.medium;

/**
 * 两数相加
 *
 * @author MT-Lin
 */
public class AddTwoNumbers {

	private static AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

	public static void main(String[] args) {
		/**
		 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
		 * 
		 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
		 * 
		 * 示例：
		 * 
		 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
		 */
		ListNode ltemp1, ltemp2;
		ListNode l1 = addTwoNumbers.new ListNode(2);
		ltemp1 = l1;
		l1.next = addTwoNumbers.new ListNode(4);
		l1 = l1.next;
		l1.next = addTwoNumbers.new ListNode(3);
		ListNode l2 = addTwoNumbers.new ListNode(5);
		ltemp2 = l2;
		l2.next = addTwoNumbers.new ListNode(6);
		l2 = l2.next;
		l2.next = addTwoNumbers.new ListNode(4);
		System.out.println(ltemp1);
		System.out.println(ltemp2);
		System.out.println(addTwoNumbers(ltemp1, ltemp2));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode temp = addTwoNumbers.new ListNode(0);
		ListNode result = temp;
		int extend = 0;
		while (null != l1 && null != l2) {
			int addTwo = 0;
			addTwo = l1.val + l2.val + extend;
			if (addTwo >= 10) {
				temp.next = addTwoNumbers.new ListNode(addTwo - 10);
				extend = 1;
			} else {
				temp.next = addTwoNumbers.new ListNode(addTwo);
				extend = 0;
			}
			l1 = l1.next;
			l2 = l2.next;
			temp = temp.next;
		}
		if (null != l1) {
			while (extend != 0 && null != l1) {
				if (l1.val + extend >= 10) {
					temp.next = addTwoNumbers.new ListNode(l1.val + extend - 10);
					extend = 1;
				} else {
					temp.next = addTwoNumbers.new ListNode(l1.val + extend);
					extend = 0;
				}
				l1 = l1.next;
				temp = temp.next;
			}
			if (null != l1) {
				temp.next = l1;
			}
		}
		if (null != l2) {
			while (extend != 0 && null != l2) {
				if (l2.val + extend >= 10) {
					temp.next = addTwoNumbers.new ListNode(l2.val + extend - 10);
					extend = 1;
				} else {
					temp.next = addTwoNumbers.new ListNode(l2.val + extend);
					extend = 0;
				}
				l2 = l2.next;
				temp = temp.next;
			}
			if (null != l2) {
				temp.next = l2;
			}
		}
		if (extend != 0) {
			temp.next = addTwoNumbers.new ListNode(1);
		}
		return result.next;
	}

	public ListNode solution(ListNode l1, ListNode l2) {
		int sum = l1.val + l2.val;
		int carry = sum / 10;
		ListNode result = addTwoNumbers.new ListNode(sum % 10);
		l1 = l1.next;
		l2 = l2.next;
		ListNode cache = result;
		while (l1 != null || l2 != null || carry > 0) {
			sum = carry;
			if (l1 != null) {
				sum += l1.val;
			}
			if (l2 != null) {
				sum += l2.val;
			}
			cache.next = addTwoNumbers.new ListNode(sum % 10);
			carry = sum / 10;
			cache = cache.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		return result;

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
