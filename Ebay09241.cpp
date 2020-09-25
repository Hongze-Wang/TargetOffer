#include <bits/stdc++.h> 
using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	
	long dp[n+1];
	
	memset(dp, 0, sizeof(dp));
	// fill(dp, dp+n+1, 0);
	dp[0] = 0;
	dp[1] = 1;

	for(int i=2; i<=n; i++) {
		int c = 1;
		while(i - c > 0) {
			dp[i] += dp[i-c];
			c *= 2;
		}
	}
	printf("%ld", dp[n]);
    // cout << dp[n] << endl;
}
