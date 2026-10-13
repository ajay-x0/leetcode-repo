class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        nums = [x*x for x in nums]
        
        nums.sort()

        n = len(nums)
        mid = n//2

        small = sum(nums[:mid])
        large = sum(nums[mid:])

        return large - small
        