## Single LinkedList
```python3
class LinkNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class MyLinkedList:

    def __init__(self):
        self.dummy_head = LinkNode()
        self.size = 0

    def get(self, index: int) -> int:
        if index < 0 or index >= self.size:
            return -1

        current = self.dummy_head.next

        for i in range(index):
            current = current.next

        return current.val

    def addAtHead(self, val: int) -> None:
        self.dummy_head.next = LinkNode(val, self.dummy_head.next)
        self.size += 1

    def addAtTail(self, val: int) -> None:
        current = self.dummy_head

        for i in range(self.size):
            current = current.next

        current.next = LinkNode(val)

        self.size += 1

    def addAtIndex(self, index: int, val: int) -> None:
        if index < 0 or index > self.size: return

        current = self.dummy_head
        for i in range(index):
            current = current.next
        current.next = LinkNode(val, current.next)
        self.size += 1

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.size: return
        curr = self.dummy_head

        for i in range(index):
            curr = curr.next

        curr.next = curr.next.next
        self.size -= 1
```
