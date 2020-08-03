// 拼多多2020校招部分编程题合集 3

/*
[编程题]多多的电子字典
热度指数：810时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 32M，其他语言64M

多多鸡打算造一本自己的电子字典，里面的所有单词都只由a和b组成。
每个单词的组成里a的数量不能超过N个且b的数量不能超过M个。
多多鸡的幸运数字是K，它打算把所有满足条件的单词里的字典序第K小的单词找出来，作为字典的封面。

输入描述:
共一行，三个整数N, M, K。(0 < N, M < 50, 0 < K < 1,000,000,000,000,000)


输出描述:
共一行，为字典序第K小的单词。
示例1
输入
2 1 4
输出
ab
说明
满足条件的单词里，按照字典序从小到大排列的结果是
a
aa
aab
ab
aba
b
ba
baa

备注:
对于40%的数据：0 < K < 100,000

对于100%的数据：0 < K < 1,000,000,000,000,000

题目保证第K小的单词一定存在
*/

#include <iostream>
#include <string>
#include <map>

using namespace std;

map<pair<int, int>, unsigned long long> memo;

unsigned long long getSubTreeNum(int m, int n) {
    if(memo.count({m, n})) return memo[{m, n}];
    if(!m) memo[{m, n}] = n;
    else if (!n) memo[{m, n}] = m;
    else memo[{m, n}] = getSubTreeNum(m-1, n) + getSubTreeNum(m, n-1)+2;
    return memo[{m, n}];
}

int main() {
    long long k;
    int n, m;
    cin >> n >> m >> k;
    string cur = "a";
    n--;
    k--;
    while(k > 0 && (m || n)) {
        unsigned long long step = getSubTreeNum(n, m)+1;
        if(step > k) {
            k--;
            if(n) {
                cur += "a";
                n--;
            } else {
                cur += "b";
                m--;
            }
        } else {
            k -= step;
            n++;
            m--;
            cur.back()++; // 修改字符串最后一个字符
        }
    }
    cout << cur << endl;
    return 0;
}
