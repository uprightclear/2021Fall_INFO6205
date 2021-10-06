package question4_5;

import question4_1.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode example = new ListNode(1);
        ListNode dummy = example;
        dummy.next = new ListNode(0);
        dummy = dummy.next;
        dummy.next = new ListNode(1);
        dummy = dummy.next;
        dummy.next = null;

        System.out.println(getDecimalValue(example));
    }


    //Time Complexity: o(n)
    //Space Complexity: o(1)
    public static int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        int ans = 0;
        while (curNode != null) {
            ans = ans * 2 + curNode.val;
            curNode = curNode.next;
        }
        return ans;
    }

}
