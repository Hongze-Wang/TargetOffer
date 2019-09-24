/* function TreeNode(x) {
    this.val = x;
    this.left = null;
    this.right = null;
} */
function Print(pRoot)
{
    // write code here
    if(!pRoot) return [];
    var queue = [], res = [], temp = [];
    var node, num = 0, toBePrinted = 1, isOdd = true;
    queue.push(pRoot);
    while(queue.length) {
        node = queue.shift();
        if(isOdd) {
            temp.push(node.val);
        } else {
            temp.unshift(node.val);
        }
        if(node.left) {
            queue.push(node.left);
            num++;
        }
        if(node.right) {
            queue.push(node.right);
            num++;
        }
        toBePrinted--;
        if(toBePrinted == 0) {
            res.push(temp);
            temp = [];
            toBePrinted = num;
            num = 0;
            isOdd = !isOdd;
        }
    }
    return res;
}
// num记录了同层需要打印的数量 isOdd是当前奇偶的判断
// push向[]末尾添加
// unshift向队首添加一个元素
// shift返回[]第一个元素
// 奇数往队尾加表示从左到右打印 偶数加到队头 表示从右向左打印