# bitwise
## pre knowledge
1. cs61c sp21  
https://inst.eecs.berkeley.edu/~cs61c/sp22/pdfs/lectures/lec01.pdf  
- Two's Complement
	- positive 它的二进制表示本身
	- negative 
		- decimal -> binary  
		eg. -7
```
Unsigned: 0b00111
Flip bits: 0b11000
Add one: 0b11001
```
		- binary -> decimal
```
Flip bits: 0b00101
Add one: 0b00110
Answer: -6
```
		
2. 知乎文章  
https://www.zhihu.com/question/38206659

3. 偶数的二进制表示总是100000(1若干0）  
(even - 1) into binary 011111(0若干1)


## and &
1. rule

全真为真，有假即假

> 0 & 0 = 0	0 & 1 = 0	1 & 0 = 0	1 & 1 = 1

eg. 3&5
```
 1 0 0 1 1
&1 1 0 0 1
------------
 1 0 0 0 1
```

2. usage
- 清零

如果想将一个单元清零，即使其全部二进制位为0，只要与一个各位都为零的数值相与，结果为零。
```
 0 1 0 1 1 0 1 1
&0 0 0 0 0 0 0 0
------------------
 0 0 0 0 0 0 0 0
```

- 取一个数的指定位

比如取数 X=1010 1110 的低4位，只需要另找一个数Y，令Y的低4位为1，其余位为0，即Y=0000 1111，然后将X与Y进行按位与运算（X&Y=0000 1110）即可得到X的指定位。
```
 1 0 1 0 1 1 1 0
&0 0 0 0 1 1 1 1
------------------
 0 0 0 0 1 1 1 0
```
eg2: get 1010 1110 的第四位
```
 1 0 1 0 1 1 1 0
&0 0 0 0 1 0 0 0
-------------------
 0 0 0 0 1 0 0 0
```

- 判断奇偶
偶数最末位是0,奇数最末位是1。

只要根据最未位是0还是1来决定，为0就是偶数，为1就是奇数。因此可以用if ((a & 1) == 0)代替if (a % 2 == 0)来判断a是不是偶数。

eg. 3 is odd
```
 0 0 0 0 0 1 1 1
&0 0 0 0 0 0 0 1
------------------
 0 0 0 0 0 0 0 1
```

## or |
1. rule

有真即真，全假为假。

> 0 | 0 = 0	0 | 1 = 1	1 | 0 = 1	1 | 1 = 1

eg. 3|5
```
 0 0 0 0 0 0 1 1
|0 0 0 0 0 1 0 1
-----------------
 0 0 0 0 0 1 1 1
```

2. usage

- 常用来对一个数据的某些位设置为1

比如将数 X=1010 1110 的低4位设置为1，只需要另找一个数Y，令Y的低4位为1，其余位为0，即Y=0000 1111，然后将X与Y进行按位或运算（X|Y=1010 1111）即可得到。
```
 1 0 1 0 1 1 1 0
|0 0 0 0 1 1 1 1
------------------
 1 0 1 0 1 1 1 1
```

## xor ^
1. rule

相同为0,相异为1

> 0 ^ 0 = 0	0 ^ 1 = 1	1 ^ 0 = 1	1 ^ 1 = 0

2. features

- 交换律
- 结合律 (a^b)^c == a^(b^c)
- 对于任何数x, 有x ^ x = 0, x ^ 0 = x
- 自反性: a ^ b ^ b = a ^ 0 = a

3. usage
- 翻转指定位

比如将数 X=1010 1110 的低4位进行翻转，只需要另找一个数Y，令Y的低4位为1，其余位为0，即Y=0000 1111，然后将X与Y进行异或运算（X^Y=1010 0001）即可得到。

```
 1 0 1 0 1 1 1 0
^0 0 0 0 1 1 1 1
------------------
 1 0 1 0 0 0 0 1
```

- swap two number
```cpp
void Swap(int &a, int &b){
    if (a != b){
        a ^= b;
        b ^= a;
        a ^= b;
    }
}
```

## 取反运算符
1. rule

> ~1 = 0	~0 = 1

2. usage
- 使一个数的最低位为零
使a的最低位为0，可以表示为：a & ~1。~1的值为 1111 1111 1111 1110，再按"与"运算，最低位一定为0。因为" ~"运算符的优先级比算术运算符、关系运算符、逻辑运算符和其他运算符都高。

## << 左移运算符
```
int a = 8;
a << 3;
移位前：0000 0000 0000 0000 0000 0000 0000 1000
移位后：0000 0000 0000 0000 0000 0000 0100 0000
```

## 右移运算符
```
unsigned int a = 8;
a >> 3;
移位前：0000 0000 0000 0000 0000 0000 0000 1000
移位后：0000 0000 0000 0000 0000 0000 0000 0001

int a = -8;
a >> 3;
移位前：1111 1111 1111 1111 1111 1111 1111 1000
移位前：1111 1111 1111 1111 1111 1111 1111 1111
```

# leetcode
## XOR
### 1.swap number
- code
```cpp
void swap(int& a, int&b) {
	a ^= b;
	b ^= a;		// b = a ^ b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a
	a ^= b;		// a = a ^ b = (a ^ b) ^ a = (a ^ a) ^ b = 0 ^ b = b
}
```

### 2.single number 136
- link
https://leetcode.com/problems/single-number/
- code
```cpp
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum ^= nums[i];
        }
        return sum;
    }
};
```
- note
	- a ^ a = 0
	- a ^ 0 = a
	- 满足交换律和结合律
	- eg1
```
	nums = [2,2,1]  
	sum = 2 ^ 2 ^ 1  
	    = 0 ^ 1 = 1  
```
	- eg2
```
	nums = [4,1,2,1,2]  
	sum = 4 ^ 1 ^ 2 ^ 1 ^ 2  
	    = 4 ^ (1 ^ 1) ^ (2 ^ 2)  
	    = 4 ^ 0 ^ 0  
	    = 4
```

### 3. Missing Number
- link
https://leetcode.com/problems/missing-number/

- code
```cpp
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        /*
        std::sort(nums.begin(), nums.end());
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != i) return i;
        }
        return nums.size();
        */
        
        std::sort(nums.begin(), nums.end());
        int ans = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            ans = ans ^ nums[i] ^ i;
        }
        
        ans ^= nums.size();
        return ans;
    }
};
```

## Power of Two
### 1. power of two 231
- link

https://leetcode.com/problems/power-of-two/

- code
```cpp
class Solution {
public:
    bool isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
};
```

- note

A num is power of two iff
	- num > 0
	- binary representation 1000000(1 加若干零)
	- (num - 1)'s binary representation 0111111(0 加若干1)
	- 对形如100000和0111111的式子做 &，结果总为0.

### 2. power of 4
- note
一个数只要满足是2的幂，并且模3等于1,就一定是4的幂。

- link

https://leetcode.com/problems/power-of-four/

- code
```cpp
class Solution {
public:
    bool isPowerOfFour(int n) {
        return (n > 0) && ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
};
```

## Count Number of 1 Bits
### 1. Number of 1 Bits 191

- link
https://leetcode.com/problems/number-of-1-bits/

- code 
```cpp
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        while (n) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
};
```

- note
	- 消1 n &= (n - 1) 形如100000(1若干0)的数，减1(01111111), 再与就可以把一消去
	- 利用此思想，依次消去一，统计总共消去了几次一


### 2. Counting Bit 338
- link
https://leetcode.com/problems/counting-bits/
- code
```cpp
class Solution {
public:
    int bits1Count(int num) {
        int count = 0;
        while (num) {
            num &= (num - 1);
            count++;
        }
        return count;
    }
    
    
    vector<int> countBits(int n) {
        vector<int> ans;
        
        for (int i = 0; i <= n; i++) {
            ans.push_back(bits1Count(i));
        }
        
        return ans;
    };
};
```

### 3. Hamming Distance 461
- link
https://leetcode.com/problems/hamming-distance/

- code
```cpp
class Solution {
public:
    int hammingDistance(int x, int y) {
        return count1Bits(x ^ y);
    }
    
    int count1Bits(int num) {
        int count = 0;
        while (num) {
            num &= (num - 1);
            count++;
        }
        return count;
    }
};
```

- note
汉明距离实际上是比较两个数x, y二进制表示不同的个数。  
计算x y 异或后二进制表示的1的个数.

### 4. Minimum Bit Flips to Convert Number 2220
- link

https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

- code
```cpp
class Solution {
public:
    int minBitFlips(int start, int goal) {
        return bit1Count(start^goal);
    }
    
    int bit1Count(int num) {
        int count = 0;
        while (num) {
            num &= (num - 1);
            count++;
        }
        return count;
    }
};
```
