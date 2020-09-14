class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 1) return true;

        char[] chs = s.toCharArray();
        Set<Character> set = new HashSet();
        for(char c: chs) {
            if(set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}