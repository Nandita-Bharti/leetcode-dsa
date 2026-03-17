/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node deepCopy(Node head1){
        Node dummy = new Node(-1);
        Node t = head1;
        Node t1 = dummy;
        while(t != null){
            t1.next = new Node(t.val);
            t1 = t1.next;
            t = t.next;   
        }
        return dummy.next;
    }
    public void merge(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node t = dummy;
        Node t1 = head1;
        Node t2 = head2;
        while(t1 != null && t2 != null){
            t.next = t1;
            t = t.next;
            t1 = t1.next;

            t.next = t2;
            t = t.next;
            t2 = t2.next;
        }
    }
    public void connect(Node head1, Node head2){
        Node t1 = head1;
        Node t2 = head2;
        while(t2 != null && t1 != null){
            if(t1.random == null) t2.random = null;
            else t2.random = t1.random.next;
            t1 = t1.next.next;
            if(t2.next != null)t2 = t2.next.next;
        }
    }
    public void spilt(Node head1){
        Node dummy1 = new Node(-1);
        Node t1 = dummy1;
        Node dummy2 = new Node(-1);
        Node t2 = dummy2;
        Node t = head1;
        
        while(t != null){
            t1.next  = t;
            t = t.next;
            t1 = t1.next;

            t2.next = t;
            t = t.next;
            t2 = t2.next;
        }
        t1.next = null;
    }
    public Node copyRandomList(Node head1) {
        // step 1. make a deep copy without random pointers
        Node head2 = deepCopy(head1);

        // step 2. make alternate connections and form a merge list
        merge(head1 , head2);

        // step 3. assign random pointer
        connect(head1,head2);

        // step 4. split the list
        spilt(head1);

        return head2;
    }
}