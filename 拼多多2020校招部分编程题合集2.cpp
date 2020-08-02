// 拼多多2020校招部分编程题合集2

#include <iostream>

using namespace std;

int main() {
    int t;
    cin >> t;
    int arr1[] = {1, 1, 0, 0}, arr2[] = {0, -1, -1, 0};
    while(t--) {
        int n;
        cin >> n;
        cout << arr1[(n-1)%4] << " " << n+arr2[(n-1)%4] << endl; 
    }
}
