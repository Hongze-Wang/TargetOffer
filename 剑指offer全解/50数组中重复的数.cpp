// This solution will change the value of the original array
// It's controversial!
class Solution {
public:
    // Parameters:
    //        numbers:     an array of integers
    //        length:      the length of array numbers
    //        duplication: (Output) the duplicated number in the array number
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    bool duplicate(int numbers[], int length, int* duplication) {
        int index;
        for(int i = 0; i < length; i++) {
            index = numbers[i] % length;   // hash function map value to index of numbers
            if(numbers[index] >= length) { // >= length, visited.
                *duplication = index;
                return 1;
            }
            numbers[index] += length;
        }
        return 0;
    }
};