/**https://leetcode.com/problems/sort-list/ */
//Given the head of a linked list, return the list after sorting it in ascending order.


/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
    if(head == null || head.next == null){
        return head;
    }
    let slow = head;
    let fast = head;
    while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    let mid = slow.next;
    slow.next = null;
    let left = sortList(head);
    let right = sortList(mid);
    let result = merge(left, right);
    return result;
    
    
};
function merge(left, right){
    let dummy = new ListNode(0);
    let curr = dummy;
    while(left != null && right != null){
        if(left.val < right.val){
            curr.next = left;
            left = left.next;
        }
        else{
            curr.next = right;
            right = right.next;
        }
        curr = curr.next;
    }
    if(left != null){
        curr.next = left;
    }
    if(right != null){
        curr.next = right;
    }
    return dummy.next;
}

    