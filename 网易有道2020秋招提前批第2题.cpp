/*
小易有一个长度为n的数字数组a_1, a_2, …, a_n。

问你是否能用这n个数字构成一个环(首尾连接)，使得环中的每一个数字都小于它相邻的两个数字的和(每个数字都必须使用并且每个数字只能使用一次)。
*/


#include <iostream>

using namespace std;

int main() {
    int t;
    cin >> t;
    while(t) {
        int n;
        cin >> n;
        if(n < 3) {
            cout << "NO" << endl;
            continue;
        }
           
        long int nums[n];
        long max=0, cmax=0, ccmax=0;
        for(int i=0; i<n; i++) {
            cin >> nums[i];
            if(nums[i] >= max) {
                ccmax = cmax;
                cmax = max;
                max = nums[i];
            }
        }
        if(cmax + ccmax >= max) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
        t--;
    }
}
