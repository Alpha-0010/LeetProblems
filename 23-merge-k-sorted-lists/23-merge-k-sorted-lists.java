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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) {
            return null;
        }
        
        PriorityQueue<ListNode> minheap = new PriorityQueue<>( (l1,l2) -> (l1.val-l2.val) );
        
        for (ListNode list : lists) {
            if (list!=null) {
                minheap.add(list);
            }
        }
        
        ListNode head = null;
        ListNode tail = null;
        
        while (minheap.size()!=0) {
            ListNode node = minheap.poll();
            if (node.next!=null) {
                minheap.add(node.next);
            }
            if (head==null && tail==null) {
                head = node;
                tail = node;
            }else {
                tail.next = new ListNode(node.val);
                tail = tail.next;
            }
        }
        return head;
    }
}