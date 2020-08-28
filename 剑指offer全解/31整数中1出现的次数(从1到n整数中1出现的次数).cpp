// 解析见：https://blog.csdn.net/weixin_41025517/article/details/85177507
// a+8是因为 这种计数方式中， a < 2 和 a >= 2 两种情况相差1 因此+8/10就能增加1
// 还有一种同等简便的方法见java解法

class Solution {
public:
    int NumberOf1Between1AndN_Solution(int n)
    {
       int count = 0;
       long long i;
        for(i = 1; i <= n; i *= 10) {
            int a = n/i, b = n%i;
            count = count + (a+8)/10*i + (a%10 == 1)*(b+1);
        }
        return count;
    }
};