package main.java.Easy; /**https://leetcode.com/problems/linked-list-cycle/ */
//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//Return true if there is a cycle in the linked list. Otherwise, return false.




class ListNode2 {
     int val;
     ListNode2 next;
     ListNode2(int x) {
         val = x;
         next = null;
     }
  }

class LinkedListCycle {
    public boolean hasCycle(ListNode2 head) {
        if(head == null || head.next == null) return false;
        ListNode2 slow = head;
        ListNode2 fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
        
    }
}

    