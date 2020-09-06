#include <bits/stdc++.h>
using namespace std;
bool cmp(int a, int b) {
    return b > a;
}
int main() {
    int n;
    scanf("%d", &n);
    int nums[n];
    int res[n];
    vector<int> pos;
    vector<int> neg;i

    for(int i=0; i<n; i++) {
        scanf("%d", &nums[i]);
        if(nums[i] > 0) {
            pos.push_back(nums[i]);
        } else {
            neg.push_back(nums[i]);
        }
    }
    sort(pos.begin(), pos.end(), cmp);
    sort(neg.begin(), neg.end(); cmp);
    int len1 = pos.size(), len2 = neg.size();
    int index=0, i=0, j=0;
    while(index < n && i<len1 && j<len2) {
        res[index++] = neg.pop_back();
        res[index++] = pos.pop_back();
        res[index++] = neg.pop_back();
        j+=2; 
        i+=1;
    }
    if(i == len1) {
        sort(neg.begin(); neg.end());
        res[index++] = neg.pop_back();
    }
    if(j == len2) {
        res[index++] = pos.pop_back();
    }
    for(int i=0; i<n; i++) {
        printf("%d", res[i]);
    }
    return 0;
}
