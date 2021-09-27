package question3_1;


public class Main {
    public static void main(String[] args) {
        ListNode example1 = new ListNode(4);
        ListNode dummy = example1;
        dummy.next = new ListNode(1);
        dummy = dummy.next;
        dummy.next = new ListNode(8);
        dummy = dummy.next;
        ListNode intersection = dummy;
        dummy.next = new ListNode(4);
        dummy = dummy.next;
        dummy.next = new ListNode(5);
        dummy = dummy.next;
        dummy.next = null;
        ///////////
        ListNode example2 = new ListNode(5);
        ListNode dummy2 = example2;
        dummy2.next = new ListNode(6);
        dummy2 = dummy2.next;
        dummy2.next = new ListNode(1);
        dummy2 = dummy2.next;
        dummy2.next = intersection;

        System.out.println(findInterSectionNode(example1, example2).val);
    }

    //Time Complexity: o(m + n)  m and n is the length of list a and list b;
    //Space Complexity: o(1)
    private static ListNode findInterSectionNode(ListNode a, ListNode b) {
        ListNode x = a;
        ListNode y = b;
        while(x != y) {
            x = x == null ? b : x.next;
            y = y == null ? a : y.next;
        }
        return x;
    }
}
