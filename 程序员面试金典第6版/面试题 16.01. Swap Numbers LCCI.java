// a^b^b = a
// a^b^a = b
// a^0 = a 任何一个数和0异或得到本身
// a^a = 0 任何一个数和本身异或得到0

class Solution {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0]^numbers[1];
        numbers[1] = numbers[0]^numbers[1];
        numbers[0] = numbers[0]^numbers[1];
        return numbers;
    }
}