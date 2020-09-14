class Solution {
    public boolean oneEditAway(String first, String second) {
        int l1 = first.length(), l2 = second.length();
        int diff = l1-l2;
        if(Math.abs(diff) >= 2) return false;

        int count = 1;
        for(int i=0, j=0; i<l1 && j<l2; i++, j++) {
            if(first.charAt(i) != second.charAt(j)) {
                if(diff == 1) {  // l1长一位
                    j--;         // j原地踏步 让i多走一步
                } else if(diff == -1) {  // l2长一位
                    i--;                 // i原地踏步 让j都走一步
                }
                count--;
            }
            if(count < 0) {
                return false;
            }
        }
        return true;
    }
}