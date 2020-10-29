class Solution {
    public int findString(String[] words, String s) {
        for(int i=0; i<words.length; i++) {
            if(words[i].equals("")) {
                continue;
            }
            if(words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }
}

// 计算mid位置使用temp 如果为空则--
// 比较mid位置的字符串和目标字符串大小
// 如果目标字符串大 则 low = temp+1
// 如果目标字符串小 则 high = mid-1

class Solution {
    public int findString(String[] words, String s) {
        int low=0, high=words.length-1;
        while(low <= high) {
            int mid = low+high >>> 1;
            int temp = mid;
            while(mid >= low && words[mid].equals("")) {
                mid--;
            }
            int flag = words[mid].compareTo(s);
            if(flag == 0) {
                return mid;
            } else if(flag < 0) {
                low = temp+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}