## binary search
1. note

[left, right]

是闭就沾一： 左闭 left = middle + 1; 右闭 right = middle - 1

两闭加等于： 如果是两个闭区间 while(left <= right), 反之没有 “=”

2. code
```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
```


3. exercise

704 https://leetcode.com/submissions/detail/819655864/

35 https://leetcode.com/submissions/detail/820384962/ 

34 https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

69 https://leetcode.com/problems/sqrtx/description/

367 https://leetcode.com/problems/valid-perfect-square/description/

2089 https://leetcode.com/problems/find-target-indices-after-sorting-array/

278 https://leetcode.com/problems/first-bad-version/

374 https://leetcode.com/problems/guess-number-higher-or-lower/

71 https://leetcode.com/problems/search-a-2d-matrix/
