def getMin(s):
    # Write your code here
    res, balance = 0, 0
    for i in range(len(s)):
        balance += 1 if s[i] == '(' else -1
        if balance == -1:
            res += 1
            balance += 1
    return res + balance

# dfs
# time limit exceeds
def minCost(cost):
    # Write your code here
    n = len(cost)
    res = []
    def bfs(i, lastIndex, cur, choice):
        if i == n:
            res.append(cur)
            return
        for idx in range(3):
            if idx == lastIndex:
                continue
            bfs(i+1, idx, cur+choice[i][idx], choice)  
    bfs(0, -1, 0, cost)
    return min(res)


def minCost_clip(cost):
    n = len(cost)
    res = []
    curMin = 101*n
    def bfs(i, lastIndex, cur, choice):
        nonlocal curMin
        if cur > curMin:
            return
        if i == n:
            res.append(cur)
            curMin = min(curMin, cur)
            return
        for idx in range(3):
            if idx == lastIndex:
                continue
            bfs(i+1, idx, cur+choice[i][idx], choice)  
    bfs(0, -1, 0, cost)
    return min(res)