/*
有一天，小易把1到n的所有排列按字典序排成一排。小易从中选出了一个排列，假设它是正数第Q个排列，小易希望你能回答他倒数第Q个排列是什么。
例如1到3的所有排列是：
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
若小易选出的排列是1 2 3，则Q = 1，而你应该输出排列3 2 1
*/

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
