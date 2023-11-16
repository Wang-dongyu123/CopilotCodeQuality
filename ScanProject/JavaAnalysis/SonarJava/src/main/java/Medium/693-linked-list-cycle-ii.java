package main.java.Medium; /**https://leetcode.com/problems/linked-list-cycle-ii/ */
//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//Do not modify the linked list.



class ListNode6 {
      int val;
      ListNode6 next;
      ListNode6(int x) {
          val = x;
          next = null;
      }
  }

class LinkedListCycleIi {
    public ListNode6 detectCycle(ListNode6 head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode6 slow = head;
        ListNode6 fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        
    }
}

    