## Res
https://yulezhang.github.io/2021/09/02/68CombinationLeetcode/

https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.md

## Code
```python
void backtracking(参数) {
    if (终止条件) {
        存放结果;
        return;
    }

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果
    }
}
```

## Exercise
### LC77
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:  

Input: n = 4, k = 2  
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]  
Explanation: There are 4 choose 2 = 6 total combinations.  
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:  

Input: n = 1, k = 1  
Output: [[1]]  
Explanation: There is 1 choose 1 = 1 total combination.  

```python
class Solution:
    
    def __init__(self):
        self.path = []
        self.result = []

    def backtracking(self, n, k, startIndex):
        if len(self.path) == k:
            self.result.append(self.path[:])
            return 

        for i in range(startIndex, n + 1):
            self.path.append(i)
            self.backtracking(n, k, i + 1)
            self.path.pop()
        return

    def combine(self, n: int, k: int) -> List[List[int]]:
        self.backtracking(n, k, 1)
        return self.result
    
```

pruning, implicit backtracking, no creation of global variable
```python
class Solution:
    def backtracking(self, n, k, startIndex, path, result):
        if len(path) == k:
            result.append(path)
            return

        for i in range(startIndex, n - (k - len(path)) + 2):
            self.backtracking(n, k, i + 1, path + [i], result)


    def combine(self, n: int, k: int) -> List[List[int]]:
        result = []
        self.backtracking(n, k, 1, [], result)
        return result
```

### LC216
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.



Example 1:

Input: k = 3, n = 7  
Output: [[1,2,4]]  
Explanation:  
1 + 2 + 4 = 7  
There are no other valid combinations.  

Example 2:

Input: k = 3, n = 9  
Output: [[1,2,6],[1,3,5],[2,3,4]]  
Explanation:  
1 + 2 + 6 = 9  
1 + 3 + 5 = 9  
2 + 3 + 4 = 9  
There are no other valid combinations.  
Example 3:  

Input: k = 4, n = 1  
Output: []  
Explanation: There are no valid combinations.  
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.  

https://leetcode.com/problems/combination-sum-iii/solutions/4279891/python-backtracking-solution/

### LC17
https://programmercarl.com/0017.%E7%94%B5%E8%AF%9D%E5%8F%B7%E7%A0%81%E7%9A%84%E5%AD%97%E6%AF%8D%E7%BB%84%E5%90%88.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE

### LC39
https://leetcode.com/problems/combination-sum/solutions/4279910/python3-easy-understanding-solution/

### LC40
https://leetcode.com/problems/combination-sum-ii/solutions/4277439/python3-backtracking-solution/
