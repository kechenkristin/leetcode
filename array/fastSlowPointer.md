## Fast Slow Pointer

### link
https://github.com/kechenkristin/leetcode-master/blob/master/problems/0027.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0.md

### code
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast ++) {
            if ( nums[fast] != val) {
                nums[slow] = nums[fast];
                slow ++;
            }
        }
        return slow;
    }
}
```

### exercise
27 https://leetcode.com/problems/remove-element/

283 https://leetcode.com/problems/move-zeroes/

977 https://leetcode.com/problems/squares-of-a-sorted-array/

26 https://leetcode.com/problems/remove-duplicates-from-sorted-array/

88 https://leetcode.com/problems/merge-sorted-array/

344 https://leetcode.com/problems/reverse-string/

202 https://leetcode.com/problems/happy-number/solutions/3767573/easy-java-solution-two-pointers-floyd-s-tortoise-and-hare-detailed-explanation/
