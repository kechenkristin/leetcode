LC 2396 https://leetcode.com/problems/strictly-palindromic-number/description/
```python
def convert_to(number, base):
    digits = '0123456789abcdefghijklmnopqrstuvwxyz'
    result = ''
    while number > 0:
        result = digits[number % base] + result
        number //= base
    return result
```
