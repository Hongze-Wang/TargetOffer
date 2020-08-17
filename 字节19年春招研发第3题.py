'''
[编程题]雀魂启动！
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 32M，其他语言64M

小包最近迷上了一款叫做雀魂的麻将游戏，但是这个游戏规则太复杂，小包玩了几个月了还是输多赢少。
于是生气的小包根据游戏简化了一下规则发明了一种新的麻将，只留下一种花色，并且去除了一些特殊和牌方式（例如七对子等），具体的规则如下：

总共有36张牌，每张牌是1~9。每个数字4张牌。
你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
14张牌中有2张相同数字的牌，称为雀头。
除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）

例如：
1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
1 1 1 2 2 2 3 3 3 5 6 7 7 9 无论用1 2 3 7哪个做雀头，都无法组成和牌的条件。

现在，小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。

输入描述:
输入只有一行，包含13个数字，用空格分隔，每个数字在1~9之间，数据保证同种数字最多出现4次。

输出描述:
输出同样是一行，包含1个或以上的数字。代表他再取到哪些牌可以和牌。若满足条件的有多种牌，请按从小到大的顺序输出。若没有满足条件的牌，请输出一个数字0

输入例子1:
1 1 1 2 2 2 5 5 5 6 6 6 9

输出例子1:
9

例子说明1:
可以组成1,2,6,7的4个刻子和9的雀头

输入例子2:
1 1 1 1 2 2 3 3 5 6 7 8 9

输出例子2:
4 7

例子说明2:
用1做雀头，组123,123,567或456,789的四个顺子

输入例子3:
1 1 1 2 2 2 3 3 3 5 7 7 9

输出例子3:
0

例子说明3:
来任何牌都无法和牌
'''
def is_win(nums):
    if not nums:
        return True
    n = len(nums)
    count0 = nums.count(nums[0])
    # 没出现过雀头 首元素计数大于等于2 使用首元素做雀头看能不能胡牌
    if n%3 != 0 and count0 >= 2 and is_win(nums[2:]):
        return True
    # 如果首元素计数大于等于3 去掉这个刻子 看能不能胡牌
    if count0>=3 and is_win(nums[3:]):
        return True
    # 如果存在顺子 移除顺子后看能不能胡牌
    if nums[0]+1 in nums and nums[0]+2 in nums:
        nums_copy = nums.copy()
        nums_copy.remove(nums[0])
        nums_copy.remove(nums[0]+1)
        nums_copy.remove(nums[0]+2)
        if is_win(nums_copy):
            return True
    return False

def main(nums):
    dic = {}
    for i in nums:
        dic[i] = dic.get(i, 0) + 1
    # card_list 排除了出现四次的牌 它们不能被添加
    card_list = set(range(1, 10)) - {i for i, v in dic.items() if v==4}
    res = []
    for i in card_list:
        if is_win(sorted(nums + [i])):
            res.append(i)
    res = ' '.join(str(x) for x in sorted(res)) if res else '0'
    return res

nums = list(map(int, input().split()))
print(main(nums))
