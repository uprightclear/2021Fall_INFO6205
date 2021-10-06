package question4_7;

import question4_1.ListNode;
import question4_2.Node;

public class Main {
    public static void main(String[] args) {
        PolyNode a = new PolyNode(2, 2);
        PolyNode b = new PolyNode(4, 1);
        PolyNode c = new PolyNode(3, 0);
        a.next = b;
        b.next = c;

        PolyNode d = new PolyNode(3, 2);
        PolyNode e = new PolyNode(-4, 1);
        PolyNode f = new PolyNode(-1, 0);
        d.next = e;
        e.next = f;

        printList(addPoly(a, d));
    }

    //Time Complexity: o(m + n) (m and n is the length of poly1 and poly2)
    //Space Complexity: o(1)
    public static PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode(0, 0);
        PolyNode cur = dummy;

        while (poly1 != null && poly2 != null) {
            if (poly1.power > poly2.power) {
                cur.next = poly1;
                poly1 = poly1.next;
            } else if (poly1.power < poly2.power) {
                cur.next = poly2;
                poly2 = poly2.next;
            } else {
                if (poly1.coefficient + poly2.coefficient == 0) {
                    poly1 = poly1.next;
                    poly2 = poly2.next;
                    continue;
                }
                cur.next = new PolyNode(poly1.coefficient + poly2.coefficient, poly1.power);
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
            cur = cur.next;
        }
        cur.next = null; // need this because poly1, poly2 sum of coeficient = 0 at last.
        if (poly1 != null) {
            cur.next = poly1;
        }
        if (poly2 != null) {
            cur.next = poly2;
        }
        return dummy.next;
    }

    private static void printList(PolyNode node){
        PolyNode temp = node;
        while(temp != null){
            System.out.print("[" + temp.coefficient + "," + temp.power + "]" + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
