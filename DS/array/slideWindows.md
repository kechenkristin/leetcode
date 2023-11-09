## 滑动窗口
### 算法应用场景
#### 关键词:  
- 满足XXX条件(计算结果 出现次数 同时包含)  
- 最长/最短(minimal/maximal length)
- 子串/子数组/子序列(subarray)  
eg. 长度最小的子数组

### 使用思路(寻找最长)
#### 核心: 左右双指针(L, R)在起始点， R向右逐位滑动循环
#### 流程
- 每次滑动过程中
	- 窗口元素满足条件 R向右扩大窗口 并更新最优结果
	- 窗口元素不满足条件 L向右缩小窗口
- R到达结尾

### 模板
#### 最长
```
初始化left, right, result, bestResult
while(右指针没有到达结尾){
	窗口扩大 加入right对应元素 更新当前result
	while(result不满足要求) {
		窗口缩小 移除left对应元素 left右移
	}
	更新最优结果bestResult
	right++
}
返回bestResult
```

#### 最短
```
初始化left, right, result, bestResult
while(右指针没有到达结尾){
	窗口扩大 加入right对应元素 更新当前result
	while(result满足要求) {
		更新最优结果bestResult
		窗口缩小 移除left对应元素 left右移
	}
	right++
}
返回bestResult
```



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

209 https://leetcode.com/problems/minimum-size-subarray-sum/

904 https://leetcode.com/submissions/detail/824440658/
