// 逐个查找
class Solution {
    public int findMagicIndex(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}

// 优化 下面的写法仅限于升序 该方法已经是最优
class Solution {
    public int findMagicIndex(int[] nums) {
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == i) {
                return i;
            }
            if(nums[i] > i+1) { // 如果nums[i] > i+1 那么到nums[nums[i]]之前 nums[i]都大于i+1
                i = nums[i]-1;  // 令i=nums[i] 跳过不需要的比较过程 
            }
        }
        return -1;
    }
}

// 官方解法 二分法 写法上递归加剪枝
class Solution {
    private int getAnswer(int[] nums, int left, int right) {
        if(left > right) {
            return -1;
        }
        int mid = (right-left) / 2 + left;

        int leftAnswer = getAnswer(nums, left, mid-1);
        if(leftAnswer != -1) {
            return leftAnswer;
        }
        if(nums[mid] == mid) return mid; // 优先返回第一个 所以mid判断在中间
        return getAnswer(nums, mid+1, right);
    }
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length-1);
    }
}