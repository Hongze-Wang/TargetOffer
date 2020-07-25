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
