# HashMap
## Note
- res
https://github.com/kechenkristin/leetcode-master/blob/master/problems/%E5%93%88%E5%B8%8C%E8%A1%A8%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.md

## leetcode problems
### 1. Valid Anagram

- link
https://leetcode.com/problems/valid-anagram/

- note
使用数组作为哈希表查询

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
