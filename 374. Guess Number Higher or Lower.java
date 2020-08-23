// 374. Guess Number Higher or Lower

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

// Binary Search
// public class Solution extends GuessGame {
//     public int guessNumber(int n) {
//         int low = 1, high = n;
//         while(low <= high) {
//             int mid = low + (high-low) / 2;
//             int res = guess(mid);
//             if(res == 0) return mid;
//             else if(res < 0) {
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }
//         return -1;
//     }
// }


// Ternary Search
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low <= high) {
            int mid1 = low + (high-low) / 3;  // 三分之一结点
            int mid2 = high - (high-low) / 3; // 三分之二结点
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if(res1 == 0) {
                return mid1;
            }
            if(res2 == 0) {
                return mid2;
            } else if(res1 < 0) {
                high = mid1 - 1;
            } else if(res2 > 0) {
                low = mid2 + 1;
            } else { // 介于两个中点之间
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }
}
