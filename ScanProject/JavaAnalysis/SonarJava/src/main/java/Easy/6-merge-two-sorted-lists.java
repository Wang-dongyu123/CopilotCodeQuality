package main.java.Easy; /**https://leetcode.com/problems/merge-two-sorted-lists/ */
//You are given the heads of two sorted linked lists list1 and list2.
//Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
//Return the head of the merged linked list.




 class ListNode1 {
      int val;
     ListNode1 next;
      ListNode1() {}
      ListNode1(int val) { this.val = val; }
      ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
  }

class MergeTwoSortedLists {
    public ListNode1 mergeTwoLists(ListNode1 list1, ListNode1 list2) {
        ListNode1 head = new ListNode1(0);
        ListNode1 current = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 != null){
            current.next = list1;
        }
        if(list2 != null){
            current.next = list2;
        }
        return head.next;
       
        
    }
}

    