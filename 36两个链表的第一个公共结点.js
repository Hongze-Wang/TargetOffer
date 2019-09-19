/*function ListNode(x){
    this.val = x;
    this.next = null;
}*/
function FindFirstCommonNode(pHead1, pHead2)
{
    // write code here
    let node1 = pHead1;
    while(node1) {
        node1.first = true;
        node1 = node1.next;
    }
    let node2 = pHead2;
    while(node2) {
        if(node2.first) {
            return node2;
        }
        node2 = node2.next;
    }
}
// javascript 不需要句尾加分号
// javascript 允许动态的向function里增加成员
// javascript function 如果没有返回任何值 则默认返回 null