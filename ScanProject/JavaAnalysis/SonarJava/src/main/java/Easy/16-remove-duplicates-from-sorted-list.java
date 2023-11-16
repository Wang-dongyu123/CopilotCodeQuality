package main.java.Easy; /**https://leetcode.com/problems/remove-duplicates-from-sorted-list/ */
//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.



class ListNode4 {
      int val;
      ListNode4 next;
      ListNode4() {}
      ListNode4(int val) { this.val = val; }
      ListNode4(int val, ListNode4 next) { this.val = val; this.next = next; }
  }

class RemoveDuplicatesFromSortedList {
    public ListNode4 deleteDuplicates(ListNode4 head) {
        ListNode4 cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
        
    }
}

    