### LC 47
```python
class Solution:
    def backtracking(self, nums, flag, path, result):
        if len(path) == len(nums):
            result.append(path)
            return

        used = set()
        for i in range(len(nums)):
            if flag[i] or nums[i] in used: continue
            used.add(nums[i])
            flag[i] = True
            self.backtracking(nums, flag, path + [nums[i]], result)
            flag[i] = False


    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result = []
        flag = [False] * len(nums)
        self.backtracking(nums, flag, [], result)
        return result
```

