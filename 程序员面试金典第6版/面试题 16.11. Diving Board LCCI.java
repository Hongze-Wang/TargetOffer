// class Solution {
//     public int[] divingBoard(int shorter, int longer, int k) {
//         // List<Integer> res = new ArrayList();
//         if(k == 0) return new int[0];

//         HashSet<Integer> res = new HashSet(); // 需要去重
//         for(int i=0; i<=k; i++) {
//             res.add(i * longer + (k-i) * shorter);
//         }

//         int[] out = new int[res.size()];
//         int i = 0;
//         for(int l : res) {
//             out[i++] = l;
//         }
//         Arrays.sort(out);
//         return out;
//     }
// }

class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0) return new int[0];
        if(shorter == longer) return new int[] {longer*k};

        int[] res = new int[k+1]; // 0~k k+1种组合方式
        for(int i=0; i<=k; i++) {
            res[i] = shorter*(k-i) + longer*i; // 递增
        }
        return res;
    }
}