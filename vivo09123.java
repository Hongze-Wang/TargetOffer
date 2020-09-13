// 编译依赖 我没太看懂这个解法

import java.util.Scanner;
import java.util.Iterator;
import java.util.TreeMap;

class Solution {
    public void static main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(compileSeq(s));
    }
    public String compileSeq(String input) {
        String[] strList = input.split(",");
        TreeMap<Integer, Integer> rbt = new TreeMap();
        for(int i=0; i<strList.length; i++) {
            rbt.put(i, Integer.parseInt(strList[i]));
        }

        HashSet<Integer>[] lasts = new HashSet[2];
        lasts[0] = new HashSet<Integer>();
        lasts[1] = new HashSer<Integer>();
        int lastIndex = 0;
        lasts[lastIndex].add(-1);

        StringBuilder sb = new StringBuilder();
        while(!rbt.isEmpty()) {
            Iterator<Integer> iter = rbt.keySet().iterator();
            while(iter.hasNext()) {
                int val = iter.next();
                if(lasts[lastIndex].contains(rbt.get(val))) {
                    sb.append(val);
                    sb.append(",");
                    iter.remove();
                    last[(lastIndex+1) % 2].add(val);
                }
            }
            lastIndex = (lastIndex+1) % 2;
        }
        return sb.substring(0, sb.length()-1);
    }
}
