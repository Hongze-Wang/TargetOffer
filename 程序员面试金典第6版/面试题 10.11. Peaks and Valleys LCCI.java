class Solution {
    public void wiggleSort(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int low = 0, high = nums.length-1, idx = 0;
        while(low < high) {
            nums[idx++] = sorted[high--];
            nums[idx++] = sorted[low++];
        }
        if((nums.length&1) == 1) {
            // nums[idx] = sorted[low];
            nums[idx] = sorted[high];
        }
    }
}