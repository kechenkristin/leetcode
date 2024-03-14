### Decimal number to other base
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

### Binary to Decimal  
https://www.geeksforgeeks.org/python-program-to-covert-decimal-to-binary-number/  

- decimal to binary
```python
def decimalToBinary(n):
    return "{0:b}".format(int(n))
```
if we want to use 32 based:
```python
def decimalToBinary(n):
    return "{0:032b}".format(int(n))
```

- binary to decimal
```python
binary_to_decimal = lambda binaryString: int(binaryString, 2)
```

LC190 https://leetcode.com/problems/reverse-bits/description/  
```python
def reverseBits(n: int) -> int:
        return int((('{0:032b}'.format(n))[::-1]),2)
```