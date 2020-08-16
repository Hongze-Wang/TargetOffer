# two pointer / slide window

N, D = list(map(int, input().split()))
pos = list(map(int, input().split()))

res = 0
left = 0
right = 2

while left < N-2:
    while right < N and pos[right] - pos[left] <= D:
        num = right-left
        res += num * (num-1) // 2
        right += 1
    left += 1

print(res % 99997867)

# fix right 在窗口范围内选2（组合）
# (num * num-1) / 2 C_num^2
# window size = right-left
