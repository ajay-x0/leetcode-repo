// class Solution {
//     public int minSwaps(int[] nums) {
//         int swap=0;
//         int [] arr = new int[nums.length];
        
//         for (int i=0; i<nums.length; i++){
//             int sum=0;
//             while(nums[i]>0){
//                 int rem = nums[i]%10;
//                 sum += rem;

//             //     if(sum>currentSum && i>0){
//             //     swap++;
//             //     currentSum = sum;
//             // }
                
//                 nums[i] = nums[i]/10;
//             }
//             arr[i]=sum;
             
//         }
//         if(isSorted(arr)){
//             swap=nums.length;
//             return swap;
//         }
        
//         return 0;
//     }

//     public boolean isSorted(int [] arr){
//         for(int i=0; i<arr.length-1; i++){
//             if(arr[i]>arr[i+1]){
//                 return false;
//             }

//         }
//         return true;
//     }
// }


import java.util.*;

class Solution {

    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Original array ki copy banao
        Integer[] sorted = new Integer[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        // Digit sum ke basis par sort karo
        // Same sum hone par smaller number pehle aayega
        Arrays.sort(sorted, (a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(a, b);
        });

        // Har number ki correct position store karo
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(sorted[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {

            // Already visited ya correct position par hai
            if (visited[i] || map.get(nums[i]) == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            // Cycle ke andar saare positions visit karo
            while (!visited[j]) {
                visited[j] = true;

                // Is number ko kis index par hona chahiye?
                j = map.get(nums[j]);
                cycleSize++;
            }

            // K elements ki cycle = K-1 swaps
            swaps += cycleSize - 1;
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
