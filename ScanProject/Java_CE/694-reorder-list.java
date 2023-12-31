package main.java.Medium; /**https://leetcode.com/problems/reorder-list/ */
//You are given the head of a singly linked-list. The list can be represented as:
//L0 �� L1 �� �� �� Ln - 1 �� Ln
//Reorder the list to be on the following form:
//L0 �� Ln �� L1 �� Ln - 1 �� L2 �� Ln - 2 �� ��
//You may not modify the values in the list's nodes. Only nodes themselves may be changed.


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
class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        merge(head, head2);
        
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next; //1
            cur.next = prev; //null
            prev = cur; //1
            cur = next; //2
        }
        return prev;
    }
    private void merge(ListNode head1, ListNode head2){
        while(head1 != null && head2 != null){
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }
}

    