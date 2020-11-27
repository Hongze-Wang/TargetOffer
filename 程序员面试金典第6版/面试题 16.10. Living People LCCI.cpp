// 树状数组 有很多不必要的操作 可以用前缀和优化

const int maxN = 102;

class Solution {
public:
    // 树状数组构建及其函数
    vector<int> live;
    int lowbit(int x) {
        return x&(-x);
    }
    void update(int idx, int offset) {
        while(idx < maxN) {
            live[idx] += offset;
            idx += lowbit(idx);
        }
    }
    int query(int idx) {
        int res = 0;
        while(idx > 0) {
            res += live[idx];
            idx -= lowbit(idx);
        }
        return res;
    }

    int maxAliveYear(vector<int>& birth, vector<int>& death) {
        live = vector<int> (maxN);

        for(int i=0; i<birth.size(); i++) {
            update(birth[i] - 1899, 1);   // 1899
            update(death[i] - 1898, -1);  // 1898
        }
        
        int year = -1, maxAlive = 0;
        for(int i=1; i<maxN; i++) {
            int yearAlive = query(i);
            if(yearAlive > maxAlive) {
                maxAlive = yearAlive;
                year = i;
            }
        }

        return year+1899;
    }
};

// 利用hashmap的思想 数组模拟映射 但复杂度是O(n^2) 可以继续使用前缀和优化
class Solution {
public:
    int maxAliveYear(vector<int>& birth, vector<int>& death) {
        int res =-1, maxAlive = 0;
        vector<int> year(101, 0); // int year[102]; memset(year, 0, sizeof(year)); 

        for(int i=0; i<birth.size(); i++) {
            for(int j=birth[i]-1900; j<=death[i]-1900; j++) {
                year[j]++;
            }
        }

        for(int i=0; i<101; i++) {
            if(year[i] > maxAlive) {
                maxAlive = year[i];
                res = i;
            }
        }
        return res+1900;
    }
};

// 前缀和版本(从上面优化过来) / 差分算法(year是每年存活人数的差分数组 直接想到 比较困难)
class Solution {
public:
    int maxAliveYear(vector<int>& birth, vector<int>& death) {
        int res=-1, maxAlive = 0;
        int year[102]; // 102 防止year[death[i]-1900+1] 索引溢出
        memset(year, 0, sizeof(year));

        for(int i=0; i<birth.size(); i++) {
            year[birth[i]-1900]++;
            year[death[i]-1899]--;
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
};