// judge if there are same value elem in array numbers
int flag = 0
for(int i = 0; i < numbers.length; i++) {
    if(((flag >> numbers[i]) & 1) == 1) {
        return false;
    }
    flag |= 1 << numbers[i];
}