package quiz1_3;

public class Main {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node tail = node;
        tail.next = new Node(2);
        tail = tail.next;
        Node pivot = tail;
        tail.next = new Node(3);
        tail = tail.next;
        tail.next = new Node(4);
        tail = tail.next;
        tail.next = new Node(5);
        tail = tail.next;
        tail.next = new Node(6);
        tail = tail.next;
        tail.next = pivot;

        Node ans = findMiddle(node);
        System.out.println(ans.val);
    }


    public static Node findMiddle(Node node) {
        Node ans = node;
        Node end = findEnd(node);
        int len = countLength(node, end);
        int step = (len - 1) / 2;
        for(int i = 0; i < step; i++) {
            ans = ans.next;
        }
        return ans;
    }
//    public static Node findMiddle(Node node) {
//        Node end = findEnd(node);
//        Node slow = node, fast = node;
//        while(fast != end) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }

    public static Node findEnd(Node node) {
        Node slow = node, fast = node;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                Node ptr = node;
                while(slow != ptr) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }

        return slow;
    }

    public static int countLength(Node node, Node end) {
        int len = 0;
        Node cur = node;
        boolean visited = false;
        while(cur != end || (cur == end && visited == false)) {
            if(cur == end) visited = true;
            cur = cur.next;
            len++;
            //if(cur == end) visited = true;
        }
        return len;
    }
}
