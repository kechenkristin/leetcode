## DFS
### LC144 PreorderTrversal
- recursive
```python
def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        left = self.preorderTraversal(root.left)
        right = self.preorderTraversal(root.right)
        return [root.val] + left + right

```

- iterative
```python
def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        result = []
        stack = [root]

        while stack:
            node = stack.pop()
            result.append(node.val)

            if node.right: stack.append(node.right)
            if node.left: stack.append(node.left)

        return result
```

- iterative(using mark)
```python
def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        stack, result = [root], []

        while stack:
            node = stack.pop()

            if node:
                if node.right: stack.append(node.right)
                if node.left: stack.append(node.left)
                stack.append(node)
                stack.append(None)
            else:
                node = stack.pop()
                result.append(node.val)

        return result
```

### LC 145 postorder
- recursive
```python
def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        left = self.postorderTraversal(root.left)
        right = self.postorderTraversal(root.right)

        return left + right + [root.val]
```

- iterative
```python
def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        stack, result = [root], []

        while stack:
            node = stack.pop()
            if node:
                stack.append(node)
                stack.append(None)
                if node.right: stack.append(node.right)
                if node.left: stack.append(node.left)
            else:
                node = stack.pop()
                result.append(node.val)

        return result
```

### LC94 inorder
- recursion
```python
def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
    if not root: return []
    left = self.inorderTraversal(root.left)
    right = self.inorderTraversal(root.right)

    return left + [root.val] + right
```

- iterative
```python
def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        stack, result = [root], []

        while stack:
            node = stack.pop()
            if node:
                if node.right: stack.append(node.right)
                stack.append(node)
                stack.append(None)
                if node.left: stack.append(node.left)
            else:
                node = stack.pop()
                result.append(node.val)

        return result
```

## BFS
### LC102  level order
```python
def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        queue = collections.deque([root])
        result = []
        while queue:
            level = []
            for _ in range(len(queue)):
                cur = queue.popleft()
                level.append(cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            result.append(level)
        return result
```

## Example
### LC226 Invert Binary Tree
- recursive(not working for inoder)
```python
def invertTree(root):
    if not root: return root
    # if preorder
    # root.left, root.right = root.right, root.left # swap
    invertTree(root.left)
    invertTree(root.right)
    # postorder
    root.left, root.right = root.right, root.left # swap
    return root
```

- iterative
  - BFS
```python
def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return root
        queue = collections.deque([root])
        while queue:
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                curr.left, curr.right = curr.right, curr.left
                if curr.left: queue.append(curr.left)
                if curr.right: queue.append(curr.right)
        return root
```

- DFS (inorder)
```python
def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return root
        stack = [root]

        while stack:
            node = stack.pop()
            if node:
                if node.right: stack.append(node.right)
                stack.append(node)
                stack.append(None)
                if node.left: stack.append(node.left)
            else:
                node = stack.pop()
                node.left, node.right = node.right, node.left

        return root
```
