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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode d = dummy;
        while(d.next != null){
            if(set.contains(d.next.val)){
                d.next = d.next.next;
            }
            else{
                d = d.next;
            }
        }
        return dummy.next;
    }
}