## Leetcode24 Swap

### note link
https://github.com/kechenkristin/leetcode-master/blob/master/problems/0024.%E4%B8%A4%E4%B8%A4%E4%BA%A4%E6%8D%A2%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9.md

### problem link
https://leetcode.com/problems/swap-nodes-in-pairs/

### code
```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        
        ListNode sential = new ListNode(-999, head);
        ListNode cur = sential;
        
        while (cur.next != null && cur.next.next != null) {
            
            // operation begin
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;
            
            cur.next = cur.next.next;
            cur.next.next = temp1;
            temp1.next = temp2;
            
            //update
            cur = cur.next.next; 
        }
        
        return sential.next;
    }
}
```

### side notes
the core of this problem is to save the temp value 
and the movement of cur pointer, and the end condition
