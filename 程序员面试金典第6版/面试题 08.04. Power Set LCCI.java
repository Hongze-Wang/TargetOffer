// 回溯法 接近双百

class Solution {
    List<List<Integer>> res = new ArrayList();
    private void backtrack(int[] nums, int idx, List<Integer> list) {
        if(idx == nums.length) return;
        list.add(nums[idx]);            // A
        res.add(new ArrayList(list));
        backtrack(nums, idx+1, list);
        list.remove(list.size()-1);     // A
        backtrack(nums, idx+1, list);   
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList();
        res.add(list);
        backtrack(nums, 0, list);
        return res;
    }
}

// 直接生成 接近双百 因为没有递归的开销 空间复杂度更低
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        for(int n: nums) {
            int size = res.size();
            for(int i=0; i<size; i++) {
                List<Integer> list = new ArrayList();
                list.addAll(res.get(i));
                list.add(n);
                res.add(list);
            }
        }
        return res;
    }
}