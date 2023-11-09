# HashMap
## Note
- res
https://github.com/kechenkristin/leetcode-master/blob/master/problems/%E5%93%88%E5%B8%8C%E8%A1%A8%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.md

- 什么时候使用哈希法，当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法

- 三种与哈希法相关的数据结构
	- 数组
		- 查询速度快 O(1)
		- 数组的大小是受限制的，而且如果元素很少，而哈希值太大会造成内存空间的浪费。
	- set
		- 应用场景与数组类似，但是空间浪费优于数组，查询速度慢于数组。
		- cf cpp set, multi_set, unordered_set

|集合 |底层实现 | 是否有序 |数值是否可以重复 | 能否更改数值|查询效率 |增删效率|
|---|---| --- |---| --- | --- | ---|
|std::set |红黑树 |有序 |否 |否 | O(log n)|O(log n) |
|std::multiset | 红黑树|有序 |是 | 否| O(logn) |O(logn) |
|std::unordered_set |哈希表 |无序 |否 |否 |O(1) | O(1)|

std::unordered_set底层实现为哈希表，std::set 和std::multiset 的底层实现是红黑树，红黑树是一种平衡二叉搜索树，所以key值是有序的，但key不可以修改，改动key值会导致整棵树的错乱，所以只能删除和增加。

	- map
		- map是一种key value的存储结构
C++中map，有三种类型：

|映射 |底层实现 | 是否有序 |数值是否可以重复 | 能否更改数值|查询效率 |增删效率|
|---|---| --- |---| --- | --- | ---|
|std::map |红黑树 |key有序 |key不可重复 |key不可修改 | O(log n)|O(log n) |
|std::multimap | 红黑树|key有序 | key可重复 | key不可修改|O(log n) |O(log n) |
|std::unordered_map |哈希表 | key无序 |key不可重复 |key不可修改 |O(1) | O(1)|

std::unordered_map 底层实现为哈希表，std::map 和std::multimap 的底层实现是红黑树。

同理，std::map 和std::multimap 的key也是有序的（这个问题也经常作为面试题，考察对语言容器底层的理解）。 更多哈希表的理论知识请看[关于哈希表，你该了解这些！](https://www.programmercarl.com/哈希表理论基础.html)。

## leetcode problems
### 1. Valid Anagram

- link
https://leetcode.com/problems/valid-anagram/

- note
使用数组作为哈希表查询

- res

- code
```cpp
class Solution {
public:
    bool isAnagram(string s, string t) {
        int arr[26] = {0};
        
        for (int i = 0; i < s.size(); i++) {
            arr[s[i] - 'a']++;
        }
        
        for (int i = 0; i < t.size(); i++) {
            arr[t[i] - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }
        
        return true;
    }
};
```

#### cf Ransom Note
- link https://leetcode.com/problems/ransom-note/
- code
```cpp
class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        if (ransomNote.size() > magazine.size()) return false;
        
        int record[26] = {0};
        
        for (int i = 0; i < magazine.size(); i++) {
            record[magazine[i] - 'a']++; 
        }
        
        for (int i = 0; i < ransomNote.size(); i++) {
            record[ransomNote[i] - 'a']--;
        }
        
        for (int i = 0; i < ransomNote.size(); i++) {
            if (record[ransomNote[i] - 'a'] < 0) return false;
        }
        
        return true;
    }
};
```

### 2. Intersection of Two Arrays
- link
https://leetcode.com/problems/intersection-of-two-arrays/

- note
	- 逻辑: num1处理, num2查询
	- 使用set作为哈希表查询, 如果某些数字很大，而且分布得很分散, 这时使用数组就浪费了大量空间，因此建议使用set
	- cf cpp中set, unordered_set, multi_set的区别

- code
```cpp
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> lookup(nums1.begin(), nums1.end());
        unordered_set<int> ins;
        vector<int> ret;
        
        for (int i = 0; i < nums2.size(); i++) {
            if(lookup.find(nums2[i]) != lookup.end()) ins.insert(nums2[i]);
        }
        
        ret.insert(ret.begin(), ins.begin(), ins.end());
        
        return ret;
    }
};
```

	- 使用数组作为哈希表查询
```cpp
vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ret;
        int hash[1002] = {0};
        unordered_set<int> ins;
        // nums1 处理
        for (int i = 0; i < nums1.size(); i++) {
            hash[nums1[i]] = 1;
        }
        
        // num2 查询
        for (int i = 0; i < nums2.size(); i++) {
            if (hash[nums2[i]] == 1) ins.insert(nums2[i]);
        }
        
        ret.insert(ret.begin(), ins.begin(), ins.end());
        
        return ret;
```

### 3. sum of two

- link  
https://leetcode.com/problems/two-sum/

- res

https://github.com/kechenkristin/leetcode-master/blob/master/problems/0001.%E4%B8%A4%E6%95%B0%E4%B9%8B%E5%92%8C.md

- code
```cpp
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> hash;
        
        for (int i = 0; i < nums.size(); i++) {
            auto iter = hash.find(target - nums[i]);
            if (iter != hash.end()) {
                return {iter->second, i};
            }
            hash.insert(pair<int, int>(nums[i], i));
        }
        return {};
    }
};
```

### 4. Happy number 202
- link

https://leetcode.com/problems/happy-number/

- res

https://github.com/kechenkristin/leetcode-master/blob/master/problems/0202.%E5%BF%AB%E4%B9%90%E6%95%B0.md

- code
```cpp
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hash = new HashSet();
        // if hash contains n, then infinite loop
        while (n != 1 && !hash.contains(n)) {
            hash.add(n);
            n = digitSum(n);
        }
        
        return n == 1;
    }
    
    
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}
```

