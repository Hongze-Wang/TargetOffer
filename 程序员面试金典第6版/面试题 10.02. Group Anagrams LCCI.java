class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        if(strs == null) return res;
        HashMap<String, List<String>> map = new HashMap();
        for(int i=0; i<strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String s = new String(str);
            if(map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                List<String> list = new ArrayList();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        for(String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }
}