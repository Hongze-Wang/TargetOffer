// 树状数组 模板题 求和变计数
// 详见https://www.cnblogs.com/xenny/p/9739600.html
// 2^k = i&(i^(i-1)) k表示i二进制中从低到高连续零的长度
// 2^k = i&(-i) lowbit求2^k专用称呼
// x&(-x) x为零时结果为零；x为奇数时结果为1；x为偶数时，结果为x中2的最大次方的因子

// class StreamRank {
// private:
//     const static int SIZE = 5e4+10;
//     int tree[SIZE];
//     // int idx

//     int lowbit(int x) {
//         return x&(-x);
//     }

// public:
//     StreamRank() {
//         memset(tree, 0, sizeof(tree)); // fill(tree, tree+SIZE, 0);
//         // idx = 0;
//     }
    
//     void track(int x) {
//         for(int i=x+1; i<=SIZE; i+=lowbit(i)) {
//             tree[i] += 1;
//         }
//     }
    
//     int getRankOfNumber(int x) {
//         int res = 0;
//         for(int i=x+1; i>0; i-=lowbit(i)) {
//             res += tree[i];
//         }
//         return res;
//     }
// };

class StreamRank {
private:
    const static int SIZE = 5e4+10;
    int tree[SIZE];

    int lowbit(int x) {
        return x&(-x);
    }
public:
    StreamRank() {
        memset(tree, 0, sizeof(tree));
    }
    
    void track(int x) {
        for(int i=x+1; i<SIZE; i += lowbit(i)) { // +1 x可以等0 但树状数组0位置不存元素 所以全体右移1个索引
            tree[i] += 1;
        }
    }
    
    int getRankOfNumber(int x) {
        int res = 0;
        for(int i=x+1; i>0; i -= lowbit(i)) {
            res += tree[i];
        }
        return res;
    }
};

/**
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank* obj = new StreamRank();
 * obj->track(x);
 * int param_2 = obj->getRankOfNumber(x);
 */