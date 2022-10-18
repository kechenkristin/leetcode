## 滑动窗口

### link
https://github.com/kechenkristin/leetcode-master/blob/master/problems/0209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.md

### note
当窗口不满足要求时， 向右拓宽边界。
当窗口满足要求时，向左收缩边界。

### code
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        // 当窗口不满足要求时， 向右拓展窗口
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 当窗口满足要求时， 向左收缩窗口
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left ++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
```

### exercise

209 https://leetcode.com/submissions/detail/824414827/

904 https://leetcode.com/submissions/detail/824440658/
