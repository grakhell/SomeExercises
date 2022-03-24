package ru.exercises.loop;

import java.util.LinkedList;

public class Loop {
    public static void detectLoop(LinkedLst<Integer> lst) {
        if (lst.head == null || lst.head.nextNode == null)
        return;
        LinkedLst<Integer>.Node slow = lst.head, fast = lst.head;
        slow = slow.nextNode;
        fast = fast.nextNode.nextNode;
        while (fast != null && fast.nextNode != null) {
            if (slow == fast) break;
                slow = slow.nextNode;
                fast = fast.nextNode.nextNode;
        }
        if (slow == null || fast == null) return;
        if(slow == fast) {
            int length_of_loop = 1;
            while(fast.nextNode != slow){
                fast = fast.nextNode;
                length_of_loop = length_of_loop + 1;
            }
            removeLoop(lst, length_of_loop);
        }
    }

    private static void removeLoop(LinkedLst<Integer> lst, int D) {
        LinkedLst<Integer>.Node ptr1 = lst.head;
        LinkedLst<Integer>.Node ptr2 = lst.head;
        while(D > 0){
            ptr2 = ptr2.nextNode;
            D--;
        }
        while(ptr1.nextNode != ptr2.nextNode) {
            ptr1 = ptr1.nextNode;
            ptr2 = ptr2.nextNode;
        }
        ptr2.nextNode = null;
    }
}
