/*
小易给你一个包含n个数字的数组。你可以对这个数组执行任意次以下交换操作：
对于数组中的两个下标i,j(1<=i,j<=n)，如果a_i+a_j为奇数，就可以交换a_i和a_j。

现在允许你使用操作次数不限，小易希望你能求出在所有能通过若干次操作可以得到的数组中，字典序最小的一个是什么。
*/

// 全奇全偶无法交换 因为不能改变其字典序
// 只要存在一对奇偶 就可以排血

#include<iostream>
#include<algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    long int a[n];
    int oddCount = 0;
    for(int i=0; i<n; i++) {
        cin >> a[i];
        if(a[i] & 1) {
            oddCount++;
        }
    }
    if(oddCount == 0 || oddCount == n) {
        for(int i=0; i<n-1; i++) {
            cout << a[i] << " ";
        }
        cout << a[n-1] << endl;
    } else {
        sort(a, a+n);
        for(int i=0; i<n-1; i++) {
            cout << a[i] << " ";
        }
        cout << a[n-1] << endl;
    }
}
