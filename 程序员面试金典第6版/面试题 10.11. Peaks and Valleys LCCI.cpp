// 出现不符合要求的序列要么是 a<b<c-该出现peek的位置没出现peek 要么是a>b>c-该出现valley的位置没出现valley
// 调整为 a<c>b a>c<b 即可 即两种情况都是交换b和c的位置

class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        for(int i=1; i<nums.size(); i++) {
            if((i & 1) == 0) {
                if(nums[i] > nums[i-1]) swap(nums[i], nums[i-1]);
            } else {
                if(nums[i] < nums[i-1]) swap(nums[i], nums[i-1]);
            }
        }
    }
};