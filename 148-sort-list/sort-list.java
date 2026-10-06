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
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = sortList(head);
        head2 = sortList(head2);
        return mergeLists(head1, head2);
    }
    public ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode i = head1;
        ListNode j = head2;
        ListNode dummy = new ListNode(-1);
        ListNode d = dummy;
        while(i != null && j != null){
            if(i.val <= j.val){
                d.next = i;
                d = i;
                i = i.next;
            }
            else{
                d.next = j;
                d = j;
                j = j.next;
            }
        }
        if(i == null) d.next = j;
        else d.next = i;
        return dummy.next;
    }
}