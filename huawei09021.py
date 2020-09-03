n = int(input())
children = []

for i in range(n):
    num, color = list(map(int, input().split()))
    children.append((i + 1, num, color))

children.sort(key=lambda x:(x[2], x[1]))

max_sum = 0
max_index = 0
max_color = 0
size = len(children)

for i in range(size):
    if i+2 < size and children[i][2] == children[i + 2][2]:
        sum = children[i][1] + children[i + 1][1] + children[i + 2][1]
        if sum > max_sum:
            max_sum = sum
            max_color = children[i][2]
            max_index = i

if max_sum == 0:
    print("null")
else:
    arr = []
    for i in range(max_index, max_index+3):
        arr.append(children[i][0])
    arr.sort()
    # arr = sorted(arr)
    for a in arr:
        print(a, end=" ")
    print()
    print(max_color)
    print(max_sum)
