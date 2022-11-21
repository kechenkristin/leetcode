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

## 1365 How Many Numbers Are Smaller Than the Current Number
1. link
https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

2. code
- brute force
```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = findSmallCount(nums, nums[i]);
        }
        return ret;
    }
    
    private int findSmallCount(int[] nums, int n) {
        int count = 0;
        for (int num : nums) {
            if (num < n) count++;
        }
        return count;
    }
}
```

- hashmap
```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;

        //克隆数组
        int[] var = new int[n];
        var = nums.clone();

        //将nums从小到大排序
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            var[i] = map.get(var[i]);
        }
        return var;
    }
}
```

