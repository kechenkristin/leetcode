## 1342. Number of Steps to Reduce a Number to zero
- link

https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

- code
```cpp
class Solution {
public:
    int numberOfSteps(int num) {
        return helperCount(num, 0);
    };
    
    // help fun
    int helperCount(int num, int step) {
        if (num == 0) return step;
        if ((num & 1) == 0) {
            return helperCount(num/2, step + 1);
        } else {
            return helperCount(num - 1, step + 1);
        }
    };
};
```
