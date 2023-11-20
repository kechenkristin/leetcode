### template code
```python
class QuickUnion:
    def __init__(self, n):
        self.parent = [i for i in range(n)]

    def find(self, n):
        """
        Give a number n, find it's parent
        """
        while n != self.parent[n]:
            n = self.parent[n]
        return n

    def isConnected(self, q, p):
        parent_q = self.find(q)
        parent_p = self.find(p)
        return parent_q == parent_p

    def connect(self, q, p):
        parent_q = self.find(q)
        parent_p = self.find(p)
        self.parent[parent_q] = parent_p
```

### exercise
- LC 1971
- LC 684
- LC 547 https://leetcode.com/problems/number-of-provinces/