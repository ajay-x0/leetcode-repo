# """
# This is MountainArray's API interface.
# You should not implement it, or speculate about its implementation
# """
#class MountainArray:
#    def get(self, index: int) -> int:
#    def length(self) -> int:

class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:

        n = mountainArr.length()

        # Find the peak of the mountain
        low = 0
        high = n - 1

        while low < high:
            mid = (low + high) // 2

            if mountainArr.get(mid) < mountainArr.get(mid + 1):
                low = mid + 1
            else:
                high = mid

        peak = low

        # Search in the increasing part
        low = 0
        high = peak

        while low <= high:
            mid = (low + high) // 2
            value = mountainArr.get(mid)

            if value == target:
                return mid

            if value < target:
                low = mid + 1
            else:
                high = mid - 1

        # Search in the decreasing part
        low = peak + 1
        high = n - 1

        while low <= high:
            mid = (low + high) // 2
            value = mountainArr.get(mid)

            if value == target:
                return mid

            if value > target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

        