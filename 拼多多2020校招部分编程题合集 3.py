# 拼多多2020校招部分编程题合集3

'''
使用hashmap避免重复计算

'''

count_dict = {}

def get_sub_treenum(n, m):
    if (n, m) in count_dict.keys():
        return count_dict[(n, m)]
    elif n == 0:
        count_dict[(n, m)] = m
    elif m == 0:
        count_dict[(n, m)] = n
    else:
        count_dict[(n, m)] = get_sub_treenum(n-1, m) + get_sub_treenum(n, m-1) + 2
    return count_dict[(n, m)]

def get_kth_str():
    n, m, k = list(map(int, input().split()))
    res = ""
    while k > 0:
        if n > 0 and m > 0:
            # 计算左子树包含的字符串数目
            left_subtree_num = get_sub_treenum(n-1, m) + 1
            if k <= left_subtree_num:
                # k在该左子树下
                res += 'a'
                k -= 1
                n -= 1
            else:
                # k在右子树下 跳过左子树的值 + 左子树根结点(1)
                res += 'b'
                k -= left_subtree_num + 1
                m -= 1
        # 其他情况非零则添加相应字符即可
        elif n == 0 and m > 0:
            res += 'b'
            k -= 1
            m -= 1
        elif m == 0 and n > 0:
            res += 'a'
            k -= 1
            n -= 1
    return res

print(get_kth_str())
