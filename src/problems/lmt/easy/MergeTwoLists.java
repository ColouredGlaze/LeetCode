package problems.lmt.easy;

/**
 * 合并两个有序链表
 *
 * @author MT-Lin
 */
public class MergeTwoLists {

	private static MergeTwoLists mergeTwoLists = new MergeTwoLists();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
		 * 
		 * 示例：
		 * 
		 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
		 */
		ListNode ltemp1 = null, ltemp2 = null;
		ListNode l1 = mergeTwoLists.new ListNode(1);
		ltemp1 = l1;
		l1.next = mergeTwoLists.new ListNode(2);
		l1 = l1.next;
		l1.next = mergeTwoLists.new ListNode(4);
		ListNode l2 = mergeTwoLists.new ListNode(1);
		ltemp2 = l2;
		l2.next = mergeTwoLists.new ListNode(3);
		l2 = l2.next;
		l2.next = mergeTwoLists.new ListNode(5);
		// System.out.println(mySolution(ltemp1, ltemp2));
		System.out.println(betterSolution(ltemp1, ltemp2));
	}

	public static ListNode mySolution(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode last = mergeTwoLists.new ListNode(0);
		ListNode make = null;
		make = last;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				last.next = l1;
				last = last.next;
				l1 = l1.next;
			} else if (l1.val > l2.val) {
				last.next = l2;
				last = last.next;
				l2 = l2.next;
			} else {
				last.next = l1;
				last = last.next;
				l1 = l1.next;
				last.next = l2;
				last = last.next;
				l2 = l2.next;
			}
		}
		if (l1 == null) {
			last.next = l2;
		}
		if (l2 == null) {
			last.next = l1;
		}
		return make.next;
	}

	public static ListNode betterSolution(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null, index = null;
		if (l1.val <= l2.val) {
			head = index = l1;
			l1 = l1.next;
		} else {
			head = index = l2;
			l2 = l2.next;
		}
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				index = index.next = l1;
				l1 = l1.next;
			} else {
				index = index.next = l2;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			index.next = l1;
		}
		if (l2 != null) {
			index.next = l2;
		}
		return head.next;

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}
}
