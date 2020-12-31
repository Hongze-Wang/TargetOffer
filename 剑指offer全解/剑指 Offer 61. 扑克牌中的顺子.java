// 排序 O(nlogn)

// class Solution {
//     public boolean isStraight(int[] nums) {
//         Arrays.sort(nums);

//         int zeroCount = 0, diff = 0;

//         for(int i=0; i<nums.length-1; i++) {
//             if(nums[i] == 0) {
//                 zeroCount++;
//                 continue;
//             }
//             if(nums[i] == nums[i+1]) return false;
//             if(nums[i+1] - nums[i] > 1) {
//                 diff += nums[i+1] - nums[i] -1;
//             }
//         }
//         return diff <= zeroCount;
//     }
// }

// 位运算 O(n)

class Solution {
    public boolean isStraight(int[] nums) {
        int flag = 0;
        int min=14, max=-1;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) continue;
            if(((flag >> nums[i]) & 1) == 1) return false;

            flag |= 1 << nums[i];
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if(max - min > 4) return false;

        return true;
    }
}