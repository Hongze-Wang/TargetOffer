// 自动机解法：使用自动机的state保存一些历史信息用于处理
// 比较适用case情况比较少的情况

#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;

    while(n--) {
        int state = 0;
        char cur;
        string str;

        cin >> str;
        char last = str[0];
        string res = "";
        res += str[0];

        for(int i=1; i<str.size(); i++) {
            cur = str[i];
            switch(state) {
                case 0:
                    if(cur == last) { // AA state 1
                        state = 1;
                    } else {          // AB state 0
                        state = 0;
                    }
                    break;
                case 1:
                    if(cur == last) {  // AAA delete last A
                        continue;
                    } else {
                        state = 2;
                    }
                    break;
                case 2:
                    if(cur == last) { // AABB delete last B
                        continue;
                    } else {
                        state = 0;
                    }
                    break;
                default:
                    break;
            }
            res += cur;
            last = cur;
        }
        cout << res << endl;
    }
    return 0;
}
