def searchRange(nums, target):
    ret = []

    def findFirst(nums, target):
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (left + right) // 2
            if target < nums[mid]:
                right = mid - 1
            elif target > nums[mid]:
                left = mid + 1
            else:
                if mid == 0 or nums[mid - 1] < target:
                    return mid
                right -= 1
        return -1

    def findLast(nums, target):
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (left + right) // 2
            if target < nums[mid]:
                right = mid - 1
            elif target > nums[mid]:
                left = mid + 1
            else:
                if mid == (len(nums) - 1) or nums[mid + 1] > target:
                    return mid
                left += 1
        return -1

    ret.append(findFirst(nums, target))
    ret.append(findLast(nums, target))
    return ret


def targetIndices(nums, target):
    size = 0
    count = 0
    ret = []

    for item in nums:
        if item < target:
            count += 1
        elif item == target:
            size += 1

    if size > 1:
        for i in range(0, size):
            ret.append(count)
            count += 1
    else:
        ret.append(count)

    return ret


def sortedSquares(nums):
    """
    leftIndex, rightIndex, result = 0, len(nums) - 1, len(nums) - 1

    ret = len(nums) * [0]
    while leftIndex <= rightIndex:
        left = nums[leftIndex] * nums[leftIndex]
        right = nums[rightIndex] * nums[rightIndex]

        if right > left:
            ret[result] = right
            rightIndex -= 1
        else:
            ret[result] = left
            left += 1

        result -= 1

    return ret
    """
    return sorted(list(map((lambda x: x ** 2), nums)))


def removeDuplicates(nums):
    nums = list(set(nums))
    return len(nums)


def merge(nums1, m: int, nums2, n: int):
    """
    Do not return anything, modify nums1 in-place instead.
    """
    index, left, right = 0, 0, 0
    ret = (m + n) * [0]

    while (left < m and right < n):
        if nums1[left] <= nums2[right]:
            ret[index] = nums1[left]
            left += 1
        else:
            ret[index] = nums2[right]
            right += 1
        index += 1

    while left < m:
        ret[index] = nums1[left]
        left += 1
        index += 1

    while right < n:
        ret[index] = nums2[right]
        right += 1
        index += 1
    return ret


def containsNearbyDuplicate1(nums, k):
    left, right = 0, 1

    for right in range(1, len(nums)):
        result = nums[left] == nums[right]
        while result:
            absLen = abs(right - left)
            if absLen <= k and absLen != 0: return True
            left += 1
            result = nums[left] == nums[right]

    while left < len(nums) - 1:
        result = nums[left] == nums[right]
        absLen = abs(right - left)
        if absLen <= k and result: return True
        left += 1

    return False


def containsNearbyDuplicate(nums, k):
    left, right = 0, 1

    for right in range(1, len(nums)):
        result = nums[left] == nums[right] and abs(right - left) <= k
        if result: return True

        while abs(right - left) > k:
            left += 1
            # result = nums[left] == nums[right] and abs(right - left) <= k
            # if result: return True
            break

    print()
    return False


if __name__ == '__main__':
    nums1 = [1, 0, 1, 1]
    nums2 = [1, 2, 3, 1, 2, 3]
    nums3 = [1, 2, 3, 1]
    nums4 = [4, 1, 2, 3, 1, 5]
    print(containsNearbyDuplicate(nums1, 1))  # true
    print(containsNearbyDuplicate(nums2, 2))  # false
    print(containsNearbyDuplicate(nums3, 3))  # false
    print(containsNearbyDuplicate(nums4, 3))  # true
