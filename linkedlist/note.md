## LinkedList

### slides
- https://sp18.datastructur.es/

### notes and codes

- cs61b exercise
see more in pdf doc

- cs61b linked list

https://github.com/kechenkristin/CS61B/blob/main/lab2/Intlist/IntList.java


- circular double linked list( linked list deque)

	https://github.com/kechenkristin/CS61B/blob/main/proj1a/LinkedListDeque.java

	- resource

	https://github.com/kechenkristin/leetcode-master/blob/master/problems/%E9%93%BE%E8%A1%A8%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.md

### 203 remove
#### Link
https://leetcode.com/problems/remove-linked-list-elements/submissions/

#### version1
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

#### version2
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

### 707 design linkedList
#### Link 
https://leetcode.com/submissions/detail/825892586/

side note: use for loop to get the value we want

```java
ListNode sential;
int size;

public MyLinkedList() {
	sential = new ListNode(-999);
	size = 0;
}

public int get(int index) {
	if (index >= size || index < 0) return -1;

	ListNode ptr = sential;

	for (int i = 0; i <= index; i++) {
		ptr = ptr.next;
	}

	return ptr.val;
}

public void addAtHead(int val) {
	addAtIndex(0, val);
}

public void addAtTail(int val) {
	addAtIndex(size, val);
}

public void addAtIndex(int index, int val) {
	if (index > size) return;
	if (index < 0) index = 0;

	size++;
	ListNode addNode = new ListNode(val);
	ListNode ptr = sential;

	for (int i = 0; i < index; i++) {
		ptr = ptr.next;
	}

	addNode.next = ptr.next;
	ptr.next = addNode;
}

public void deleteAtIndex(int index) {
	if (index < 0 || index >= size) return;

	ListNode ptr = sential;
	size--;

	if (index == 0) {
		sential = sential.next;
		return;
	}

	for (int i = 0; i < index; i++) {
		ptr = ptr.next;
	}

	ptr.next = ptr.next.next;
}
```

### 206 reverse linkedlist
#### Iterative
```java
public ListNode reverseList(ListNode head) {
	ListNode prev = null;
	ListNode current = head;
	ListNode temp;

	while (current != null) {
		temp = current.next;
		current.next = prev;
		prev = current;
		current = temp;
	}
	// 返回易错
	return prev;
}
```


#### recursive
```java
public ListNode reverseList(ListNode head) {
	return reverseHelper(null, head);
}

public ListNode reverseHelper(ListNode pre, ListNode cur) {
	if (cur == null) return pre;

	ListNode temp = cur.next;
	cur.next = pre;

	return reverseHelper(cur, temp);
}
```

