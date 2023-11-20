### Template for building the graph
https://docs.google.com/presentation/d/1tEcMWoqOGCE0oPDxIRBqpfv1HPFk8YEudA6cJ2z6vds/edit#slide=id.g76e0dad85_2_196
- java implementation
```java
public class Graph {
    private final int V;  private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);   adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
```
- python implementation
```python

```

- LC1466 https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
```python
from collections import defaultdict

class Solution:
    def search(sels, visited, graph_map):
        queue = [0]
        ret = 0

        while queue:
            front = queue.pop(0)
            for next_node, cost in graph_map[front]:
                if next_node in visited: continue
                visited.add(next_node)
                queue.append(next_node)
                ret += cost
        return ret

    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        # step1 build the graph
        # key: source node
        # value: [(1, 1), (4, 0)]   
        #         (next_node_val, cost)
        graph_map = defaultdict(list)

        for source, point_to in connections:
            graph_map[source].append((point_to, 1))
            graph_map[point_to].append((source, 0))

        visited = set()
        visited.add(0)
        return self.search(visited, graph_map)
```

```python
class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        # step1 build the graph
        # key: source node
        # value: [(1, 1), (4, 0)]
        #         (next_node_val, cost)
        graph_map = defaultdict(list)

        for source, point_to in connections:
            graph_map[source].append((point_to, 1))
            graph_map[point_to].append((source, 0))

        visited = set()

        total_cost = 0

        def dfs_search(node):
            visited.add(node)
            nonlocal total_cost
            for next_node, cost in graph_map[node]:
                if next_node in visited:
                    continue
                total_cost += cost
                dfs_search(next_node)

        dfs_search(0)
        return total_cost
```