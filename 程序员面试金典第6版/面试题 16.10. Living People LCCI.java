// hashmap思想 暴力法数组优化实现 O(n^2) 前缀和可以继续优化该版本

class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int res = -1, max = 0;
        int[] year = new int[101];

        for(int i=0; i<birth.length; i++) {
            for(int j=birth[i]-1900; j <= death[i]-1900; j++) {
                year[j]++;
            }
        }

        for(int i=0; i<101; i++) {
            if(year[i] > max) {
                max = year[i];
                res = i;
            }
        }

        return res+1900;
    }
}

// 差分算法 构造差分数组求前缀和

class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int res=-1, maxAlive = 0;
        int[] year = new int[102]; // 102 防止year[death[i]-1899] 索引溢出

        for(int i=0; i<birth.length; i++) {
            year[birth[i]-1900]++;
            year[death[i]-1899]--; // -1900+1 
        }

        int temp = 0;
        for(int i=0; i<101; i++) {
            temp += year[i];
            if(temp > maxAlive) {
                maxAlive = temp;
                res = i;
            }
        }
        return res + 1900;
    }
}