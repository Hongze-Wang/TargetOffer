# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def kthToLast(self, head: ListNode, k: int) -> int:
        fast, slow = head, head
        while k > 0:
            fast = fast.next
            k -= 1
        while fast is not None:
            fast = fast.next
            slow = slow.next
        return slow.val