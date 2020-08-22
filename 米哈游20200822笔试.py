'''
作者：爱玩矢量
链接：https://www.nowcoder.com/discuss/485077?source_id=profile_create&channel=1013
来源：牛客网

第一题
分数计算
写的可能有些复杂了，不过逻辑不难
注意分子是0和分母是1的情况就好
'''

def first():
    import math
    f, o, g = input().split(' ')
    # 1/8 + 3/8
    a, b = map(int, f.split('/'))
    c, d = map(int, g.split('/'))
 
    if o == '+':
        u = a * d + b * c
        l = b * d
        t = math.gcd(u, l)
    elif o == '-':
        u = a * d - b * c
        l = b * d
        t = math.gcd(u, l)
    elif o == '*':
        u = a * c
        l = b * d
        t = math.gcd(u, l)
    else:
        u = a * d
        l = b * c
        t = math.gcd(u, l)
 
    if u == 0:
        print(0)
    elif l // t == 1:
        print(u // t)
    else:
        print(str(u // t) + '/' + str(l // t))

'''
第二题
想法是把每一行当作一个二进制数
看有没有若干个数的和正好是全一的二进制数，即和正好是 2^m-1，m是列长
'''

def second():
    n, m = map(int, input().split(' '))
    matrix = []
    for _ in range(n):
        matrix.append(eval('0b' + ''.join(input().split(' '))))
 
    from itertools import combinations
    target = 2 ** m - 1
    for i in range(1, n + 1):
        for c in combinations(matrix, i):
            if sum(c) == target:
                print('YES')
                break
        else:
            continue
        break
    else:
        print('NO')
