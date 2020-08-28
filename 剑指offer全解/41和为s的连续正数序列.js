// two pointer method based on arithmetic pregression sum
// 1   等差数列： current = (high-low+1)(high+low) / 2
// 2   初始化两个指针 low = 1, high = 2 覆盖尽可能多的情况
// 3   low < high 循环就可以继续进行
// 4.0 不断比较current 和 low
// 4.1 current == sum, 那么low~high之间的数满足要求，遍历其中的数存入一个数组 low++ 继续进行求下一个序列

function FindContinuousSequence(sum)
{
    // write code here
    var res = [];
    var low = 1; var high = 2;
    while(low < high) {
        current = (high-low+1)*(high+low) / 2;
        if(current == sum) {
            var list = [];
            for(let i = low; i <= high; i++) {
                list.push(i);
            }
            res.push(list);
            low++;
        } else if(current < sum) {
            high++;
        } else {
            low++;
        }
    }
    return res;
}