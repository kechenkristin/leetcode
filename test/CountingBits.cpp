//
// Created by kristin on 23/11/22.
//

#include "CountingBits.h"
#include <vector>
#include <iostream>

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

int main() {
    vector<int> demo;
    demo = countBits(2);
    for (int i : demo) {
        cout << i << "\n";
    }

    int demo2 = xorOperation(4, 3);
    cout << demo2;

}