### Link
https://leetcode.com/problems/valid-parentheses/

### Note
```
new stack
for (c : String)
if ('(' || '[' || '{') stack.push(c)
else (')' || ']' || '}') 
    char top = stack.peek();
    if (not pair(c, top) return false;
    else stack.pop()
return stack.isEmpty() ? true : false;
```

### Code
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if (pair(c, top)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
    
    private boolean pair(char c, char top) {
        if (c == ')' && top == '(') return true;
        if (c == ']' && top == '[') return true;
        if (c == '}' && top == '{') return true;
        return false;
        
    }
}
```
