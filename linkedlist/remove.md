## 203: remove node 

### Link
https://leetcode.com/problems/remove-linked-list-elements/submissions/

### version1
```java
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        
        // set up sential
        ListNode sential = new ListNode(-999, head);
        
        ListNode current = sential;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                // 易错
                current = current.next;
            }
        }
        return sential.next;
    }
}
```

### version2
```java
public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        
        ListNode sential = new ListNode(-999, head);
        ListNode pre = sential;
        ListNode ptr = sential.next;
        
        while (ptr != null) {
            if (ptr.val == val) {
                pre.next = ptr.next;
            } else {
                pre = pre.next;
            }
            ptr = ptr.next;
        }  
        return sential.next;
    } 
```
