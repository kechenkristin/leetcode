# GCD
## code
```java
public static void gcd(int a, int b) {
	if (a % b == 0) return b;
	return gcd(b, a % b);
}
```

## leetcode
### 1979. Find Greatest Common Divisor of Array
- link

https://leetcode.com/problems/find-greatest-common-divisor-of-array/

- code
```java
class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        // find max and min
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        
        return gcd(max,min);
    }
    
    
    // find gcd
    private int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
```


