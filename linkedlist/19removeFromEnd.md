## 19.Remove Nth Node From End of List
### problem link
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

### note link
https://github.com/kechenkristin/leetcode-master/blob/master/problems/0019.%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E7%9A%84%E5%80%92%E6%95%B0%E7%AC%ACN%E4%B8%AA%E8%8A%82%E7%82%B9.md

### codes
```java
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null) return head;
        
        // create sential
        ListNode sential = new ListNode(-999, head);
        
        // create pointers
        ListNode fast = sential;
        ListNode slow = sential;
        
        // let fast moves (n+1) first
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // move together
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // remove element
        slow.next = slow.next.next;
        
        return sential.next;
    }
}
```


### side note
1. use of fast and slow pointer
- how to locate to the nth node from end?
let fast pointer moves n + 1 firstly, and then both fast and slow pointers move together, when fast reaches the last node of the linkedlist, slow pointer is at the position we want.

2. In order to remove a pointer at nth node, we need to operate the node before nth node.

In this problem, we need to let slow pointer at (n-1)th, so fast moves (n+1) firstly.
