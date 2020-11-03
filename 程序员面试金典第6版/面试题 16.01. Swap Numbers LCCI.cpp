// 加法交换会溢出
// class Solution {
// public:
//     vector<int> swapNumbers(vector<int>& numbers) {
//         numbers[0] = numbers[0] + numbers[1];
//         numbers[1] = numbers[0] - numbers[1];
//         numbers[0] = numbers[0] - numbers[1];
//         return numbers;
//     }
// };
// 减法 100% faster 17.58% memory

class Solution {
public:
    vector<int> swapNumbers(vector<int>& numbers) {
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] = numbers[0] + numbers[1];
        numbers[0] = numbers[1] - numbers[0];
        // numbers[0] = -(numbers[0] - number[1]);
        return numbers;
    }
};