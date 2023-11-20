## Res
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E5%9B%BE%E8%AE%BA%E6%B7%B1%E6%90%9C%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.md

## Template
### DFS
- using recursion
```python
void dfs(参数) {
    if (终止条件) {
        存放结果;
        return;
    }

    for (选择：本节点所连接的其他节点) {
        处理节点;
        dfs(图，选择的节点); // 递归
        回溯，撤销处理结果
    }
}
```
- it can also use iterative, see more in following examples

### BFS
```python
dir = [(0, 1), (1, 0), (-1, 0), (0, -1)] # 创建方向元素

def bfs(grid, visited, x, y):
  
  queue = [(x, y)] # 初始化队列
  visited[x][y] = True # 标记为访问过的节点
  
  while queue: # 遍历队列里的元素
  
    curx, cury = queue.pop(0) # 取出第一个元素
    
    for dx, dy in dir: # 遍历四个方向
    
      nextx, nexty = curx + dx, cury + dy
      
      if nextx < 0 or nextx >= len(grid) or nexty < 0 or nexty >= len(grid[0]): # 越界了，直接跳过
        continue
        
      if not visited[nextx][nexty]: # 如果节点没被访问过  
        visited[nextx][nexty] = True # 标记为访问过的节点
        queue.append((nextx, nexty)) # 加入队列

```

i.e lc797 https://leetcode.com/problems/all-paths-from-source-to-target/description/
```python
class Solution:
    def dfs(self, graph, node, path, result):
        if node == len(graph) - 1:
            result.append(path[:])
            return

        for neighbour in graph[node]:
            self.dfs(graph, neighbour, path + [neighbour], result)

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        if not graph: return []
        result = []
        self.dfs(graph, 0, [0], result)
        return result
```

## Examples
### standard questions
####  LC 200 
https://leetcode.com/problems/number-of-islands/solutions/4287546/python3-bfs-dfs/

Code
dfs using recursion
```python

class Solution:
def numIslands(self, grid: List[List[str]]) -> int:
row, col = len(grid), len(grid[0])
directions = ((1, 0), (-1, 0), (0, 1), (0, -1))
visited = [[False for _ in range(col)] for _ in range(row) ]


        def dfs(x, y):
            for offset_x, offset_y in directions:
                next_x = x + offset_x
                next_y = y + offset_y
                if next_x < 0 or next_x >= row or next_y < 0 or next_y >= col: continue
                if not visited[next_x][next_y] and grid[x][y] == '1':
                    visited[next_x][next_y] = True
                    dfs(next_x, next_y)

        count = 0
        for i in range(row):
            for j in range(col):
                if not visited[i][j] and grid[i][j] == '1':
                    count += 1
                    visited[i][j] = True
                    dfs(i, j)

        return count
```

- dfs using stack

```python
def numIslands(self, grid: List[List[str]]) -> int:
row, col = len(grid), len(grid[0])
directions = ((1, 0), (-1, 0), (0, 1), (0, -1))
visited = [[False for _ in range(col)] for _ in range(row) ]

        def dfs(x, y):
            stack = [(x, y)]
            while stack:
                curr_x, curr_y = stack.pop()
                for dx, dy in directions:
                    next_x = curr_x + dx
                    next_y = curr_y + dy
                    if next_x < 0 or next_x >= row or next_y < 0 or next_y >= col: continue
                    if not visited[next_x][next_y] and grid[next_x][next_y] == '1':
                        visited[next_x][next_y] = True
                        stack.append((next_x, next_y))

        count = 0
        for i in range(row):
            for j in range(col):
                if not visited[i][j] and grid[i][j] == '1':
                    count += 1
                    visited[i][j] = True
                    dfs(i, j)

        return count
```

- bfs using queue
```python
class Solution:
def numIslands(self, grid: List[List[str]]) -> int:
row, col = len(grid), len(grid[0])
directions = ((1, 0), (-1, 0), (0, 1), (0, -1))
visited = [[False for _ in range(col)] for _ in range(row) ]

        def bfs(x, y):
            queue = [(x, y)]
            while queue:
                curr_x, curr_y = queue.pop(0)
                for dx, dy in directions:
                    next_x = curr_x + dx
                    next_y = curr_y + dy
                    if next_x < 0 or next_x >= row or next_y < 0 or next_y >= col: continue
                    if not visited[next_x][next_y] and grid[next_x][next_y] == '1':
                        visited[next_x][next_y] = True
                        queue.append((next_x, next_y))

        count = 0
        for i in range(row):
            for j in range(col):
                if not visited[i][j] and grid[i][j] == '1':
                    count += 1
                    visited[i][j] = True
                    bfs(i, j)

        return count
```

similar questions:
- LC 695  
https://leetcode.com/problems/max-area-of-island/solutions/4288639/python-bfs-dfs-solution/

### manipulate boarders
- LC 1020
    - https://programmercarl.com/1020.%E9%A3%9E%E5%9C%B0%E7%9A%84%E6%95%B0%E9%87%8F.html
    - https://leetcode.com/problems/number-of-enclaves/solutions/4288754/python-bfs-dfs-easy-understanding-solution/
- LC 1254
  - https://leetcode.com/problems/number-of-closed-islands/solutions/4288870/python3-dfs-solution/
- LC 130
  - https://programmercarl.com/0130.%E8%A2%AB%E5%9B%B4%E7%BB%95%E7%9A%84%E5%8C%BA%E5%9F%9F.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
  - https://leetcode.com/problems/surrounded-regions/solutions/4300644/python3-dfs-simple-solution/
  

