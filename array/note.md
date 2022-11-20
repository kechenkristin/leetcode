## 1. Two Sum
1. link
https://leetcode.com/problems/two-sum/
2. code
- brute force
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        
        return ret;
    }
}
```

- hashmap
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap hashMap = new HashMap();
        for (int i=0; i < nums.length; i++ ) {
            if(hashMap.containsKey(nums[i])) return new int[] {i, (int) hashMap.get(nums[i])};
            else hashMap.put(target-nums[i],i);
        }
        return new int[]{0,0};
    }
}
```
