package main.java.Medium; /**https://leetcode.com/problems/sort-list/ */
//Given the head of a linked list, return the list after sorting it in ascending order.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
        
        
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1; //0 1 2 3
                l1 = l1.next; //1 2 3
            }else{
                cur.next = l2; //0 1 2 3
                l2 = l2.next; //1 2 3
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1; //0 1 2 3
        }
        if(l2 != null){
            cur.next = l2; //0 1 2 3
        }
        return dummy.next;
    }
}

    