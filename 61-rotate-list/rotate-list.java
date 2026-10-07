// Second method - similar to the listed one
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        // Make list circular
        tail.next = head;

        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Break circular list to establish new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}

// class Solution {
//      public int length(ListNode head){
//             int len = 0;
//             ListNode temp = head;
//             while(temp != null){
//                 len++;
//                 temp = temp.next;
//             }
//             return len;
//         }
//     public ListNode rotateRight(ListNode head, int k) {
//         if(head == null || head.next == null) return head;
//         int n = length(head);
//         k = k % n;
//         if(k == 0)return head;
//         ListNode slow = head;
//         ListNode fast = head;
//         for(int i = 1; i <= k+1; i++) {
//             fast = fast.next;
//         }
//         while(fast != null){
//             slow = slow.next;
//             fast = fast.next;
//         }
//         ListNode a = slow.next;
//         slow.next = null;
//         ListNode tail = a;
//         while(tail.next != null){
//             tail = tail.next;
//         }
//             tail.next = head;
//             return a;
//     }
// }