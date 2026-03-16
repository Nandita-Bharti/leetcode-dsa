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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp);
            temp = temp.next;
        }
        int i = left-1;
        int j = right-1;
        while(i < j){
            ListNode t1 = arr.get(i);
            ListNode t2 = arr.get(j);
            arr.set(i,t2);
            arr.set(j,t1);
            i++;
            j--;
        }
        for(i = 0; i < arr.size(); i++){
            // arr.get(i).next = (i == arr.size()-1) ? null : arr.get(i+1);
            if(i == arr.size()-1) arr.get(i).next = null; 
            else arr.get(i).next = arr.get(i+1);
        }
        return arr.get(0);
    }
}