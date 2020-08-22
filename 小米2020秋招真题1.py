# 判断回文链表
# leetcode 234. Palindrome Linked List

class ListNode:
    def __init__(self, v):
        self.val = v
        self.next = None

class Solution:
    def isPalindrome(self, head):
        if head is None or head.next is None:
            return True

        if head.next.next is None:  # 这个边界处理可以省略
            return head.val == head.next.val

        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        pre, next = None, None
        while slow is not None:
            next = slow.next
            slow.next = pre
            pre = slow
            slow = next

        cur = head
        while pre:
            if pre.val != cur.val:
                return False
            pre = pre.next
            cur = cur.next
        return True

def list2LinkList(arr):
    if not arr:
        return None
    cur = head = ListNode(arr[0])
    for i in range(1, len(arr)):
        cur.next = ListNode(arr[i])
        cur = cur.next

    return head

nums = list(map(int, input().split()))
head = list2LinkList(nums)
s = Solution()
print(s.isPalindrome(head))
