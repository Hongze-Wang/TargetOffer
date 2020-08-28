// two pointer method
// the difference from question 41 is that now high pointer start from array.length -1

// 1.双指针，low=0，high=array.length-1;
// (注意这里区分，连续和为s的序列，一个high指向2，一个指向数组末尾)
// 2.健壮性：数组长度小于2，返回[]
// 3.循环开始的条件 low < high(反过来即推出循环的条件)
// 4.不断比较当前和与sum和current
// (注意：这里的current=array[low]+array[high]一定要放在while循环的里面)
// 4.1 current < sum slow++
// 4.2 current > sum high--
// 4.3 current == sum, res.put(array[low], array[high])

function FindNumbersWithSum(array, sum)
{
    // write code here
    if(array.length < 2) return [];
    var low = 0;
    var high = array.length-1;
    var list = [];
    var current;
    while(low < high) {
        current = array[low] + array[high];
        if(current < sum) {
            low++;
        } else if(current > sum) {
            high--;
        } else if(current == sum) {
            list.push(array[low]);
            list.push(array[high]);
            break;
        }
    }
    return list;
}