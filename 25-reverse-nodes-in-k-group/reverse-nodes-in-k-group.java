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
    // Helper function to get the k-th node from current node
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy; // Node right before the k-group to reverse

        while (true) {
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break; // Less than k nodes remain, stop reversing

            ListNode groupNext = kth.next; // Start of the next group

            // Reverse the current k-group
            ListNode prev = groupNext; // Attach tail directly to next group
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // Re-link the previous part of the list to the new head of this reversed group
            ListNode tmp = groupPrev.next; // This will become the tail of current group
            groupPrev.next = kth;
            groupPrev = tmp; // Move groupPrev to the tail of the current reversed group
        }

        return dummy.next;
    }
}