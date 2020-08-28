class Solution:
    def FindFirstCommonNode(self, pHead1, pHead2):
        # write code here
        p1 = pHead1
        p2 = pHead2
        size1 = size2 = 0
        while p1:
            size1 += 1
            p1 = p1.next
        while p2:
            size2 += 1
            p2 = p2.next
        if size1 < size2:
            pHead1, pHead2 = pHead2, pHead1
        distance = size1 - size2
        for i in range(distance):
            pHead1 = pHead1.next
        while pHead1 != pHead2:
            pHead1 = pHead1.next
            pHead2 = pHead2.next
        return pHead1