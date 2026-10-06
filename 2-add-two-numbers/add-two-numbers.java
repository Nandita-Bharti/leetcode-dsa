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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode d = dummy;
        ListNode i = l1;
        ListNode j = l2;
        int carry = 0;
        while(i != null || j != null || carry != 0){
            int val1 = (i == null ? 0 : i.val);
            int val2 = (j == null ? 0 : j.val);
            int sum = val1+val2+carry;
            carry = sum / 10;
            d.next = new ListNode(sum%10);
            d = d.next;
            if(i != null) i = i.next;
            if(j != null) j = j.next;
        }
        return dummy.next;
    }
}