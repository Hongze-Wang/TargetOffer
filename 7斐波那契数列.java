public class Solution {
    public int Fibonacci(int n) {
        if(n < 2) return n;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
// Time Complexity: O(2^n)
// Space Complexity: 0(1)

public class Solution {
    public int Fibonacci(int n) {
        int ans[] = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for(int i=2; i<=n; i++) {
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }
}
// Time Complexity: O(n)
// Space Complexity: 0(n)

public class Solution {
    public int Fibonacci(int n) {
        if(n < 2) return n;
            int sum = 0;
            int two = 0;
            int one = 1;
         for(int i=2; i<=n; i++) {
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }
}
// Time Complexity: O(n)
// Space Complexity: 0(1)

public class Solution {
    public int Fibonacci(int n) {
        if(n < 2) return n;
        int one = 0, sum = 1;
        for(int i=2; i<=n; i++) {
            sum += one;
            one = sum - one;
        }
        return sum;
    }
}
// Time Complexity: O(n)
// Space Complexity: 0(1)