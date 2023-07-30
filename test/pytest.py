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


if __name__ == '__main__':
    demo = [1,2,5,2,3]
    print(targetIndices(nums=demo, target=2))
