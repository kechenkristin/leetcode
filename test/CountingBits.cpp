//
// Created by kristin on 23/11/22.
//

#include "CountingBits.h"
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;


   vector<int> countBits(int n) {
        vector<int> vet;
        int even = 0;

        for (int i = 0; i <= n; i++) {
            if ((i % 2) == 0) {
                vet.push_back(even);
                even = even << 1;
            } else {
                vet.push_back(even + 1);
            }
        }
        return vet;
    };

int xorOperation(int n, int start) {
    int result = 0;
    vector<int> arr;
    for (int i = 0; i < n; i++) {
        arr.push_back(start + 2 * i);
        result ^= arr[i];
    }

    return result;
};

vector<int> findErrorNums(vector<int>& nums) {
    vector<int> ans;
    int xorSum = 0;

    for (int i = 0; i < nums.size(); i++) {
        xorSum ^= nums[i];
        if (xorSum == 0) {
            ans = {nums[i], (nums[i] + 1)};
        }
    }

    return ans;
}

int findFirst(vector<int>& nums, int target) {
    int left = 0, right = nums.size() - 1;

    while(left <= right) {
        int mid = left + (right - left) / 2;
        if (target < nums[mid]) {
            right = mid - 1;
        } else if (target > nums[mid]) {
            left = mid + 1;
        } else {
            if (mid == 0 || nums[mid - 1] < nums[mid]) return mid;
            right = mid - 1;
        }
    }
    return -1;
}


int findLast(vector<int>& nums, int target) {
    int left = 0, right = nums.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (target < nums[mid]) {
            right = mid - 1;
        } else if (target > nums[mid]) {
            left = mid + 1;
        } else {
            if (mid == (nums.size() - 1) || nums[mid + 1] > nums[mid]) return mid;
            left = mid + 1;
        }
    }
    return -1;
}
vector<int> targetIndices(vector<int>& nums, int target) {
    std::sort(nums.begin(), nums.end());
    vector<int> ans;

    int first = findFirst(nums, target);
    int last = findLast(nums, target);

    if (first != -1) ans.push_back(first);
    if (last != -1) ans.push_back(last);

    return ans;
}





int main() {
    vector<int> demo;
    demo = countBits(2);
    for (int i : demo) {
        cout << i << "\n";
    }

    int demo2 = xorOperation(4, 3);
    cout << demo2 << "\n";

    vector<int> demo3 {1, 2, 5, 2, 3};
    vector<int> demo4 = targetIndices(demo3, 2);
    for (int i : demo4) {
        cout << i << endl;
    }

}