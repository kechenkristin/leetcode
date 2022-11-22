## Fibonacci Number
### codes
1. Recursion implementation
```java
public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 2) + fib(n - 1);
    }
```

2. Iterative Implementation
- With array's help
```java
public int fib(int n) {
        if (n <= 1) return n;
        
        int[] fibs = new int[n + 1];
        fibs[0] = 0;
        fibs[1] = 1;
        
        for (int i = 2; i < n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        
        return fibs[n];
    }
```

```java
public int fib(int n) {
        if (n <= 1) return n;
        
        int prev2 = 0;
        int prev1 = 1;
        int cur = 0;
        
        for (int i = 2; i <= n; i++) {
            cur = prev2 + prev1;
            prev2 = prev1;
            prev1 = cur;
        }
        
        return cur;
    }
```

### leetcode
1. 509 Fibonacci Number
https://leetcode.com/problems/fibonacci-number/

2. useful res
https://leetcode.com/problems/fibonacci-number/discuss/1109647/5-ways-to-Solve-this-problem

https://leetcode.com/discuss/explore/april-leetcoding-challenge-2021/1159786/fibonacci-number-easy-solution-w-multiple-approaches-explained
