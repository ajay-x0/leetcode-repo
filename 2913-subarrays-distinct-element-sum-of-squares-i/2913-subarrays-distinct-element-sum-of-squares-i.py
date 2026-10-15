class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        n = len(nums)
        result=0
        for i in range(0,n):
            res_set = set()
            for j in range(i,n):
                res_set.add(nums[j])
                result += len(res_set)*len(res_set)

        return result