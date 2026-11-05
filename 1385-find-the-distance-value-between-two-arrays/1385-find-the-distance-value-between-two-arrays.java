class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        
        for(int n : arr1)
        {
            if(isValid(n, arr2, d)){
                count++;
            }
        }
        return count;
    }

    boolean isValid(int n, int [] arr, int d)
    {
        for(int i : arr)
        {
            if(Math.abs(i-n)<=d)
            {
                return false;
            }
        }
        return true;
    }
}