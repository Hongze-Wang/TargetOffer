'''
[编程题]水平线-研发
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 64M，其他语言128M

伞屉国是一个以太阳能为主要发电手段的国家，因此他们国家中有着非常多的太阳能基站，链接着的基站会组合成一个发电集群。但是不幸的是伞屉国不时会遭遇滔天的洪水，当洪水淹没基站时，基站只能停止发电，同时被迫断开与相邻基站的链接。你作为伞屉国的洪水观察员，有着这样的任务：在洪水到来时，计算出发电集群被洪水淹没后被拆分成了多少个集群。

由于远古的宇宙战争的原因，伞屉文明是一个二维世界里的文明，所以你可以这样理解发电基站的位置与他们的链接关系：给你一个一维数组a，长度为n，表示了n个基站的位置高度信息。数组的第i个元素a[i]表示第i个基站的海拔高度是a[i],而下标相邻的基站才相邻并且建立链接，即x号基站与x-1号基站、x+1号基站相邻。特别的，1号基站仅与2号相邻，而n号基站仅与n-1号基站相邻。当一场海拔高度为y的洪水到来时，海拔高度小于等于y的基站都会被认为需要停止发电，同时断开与相邻基站的链接。


输入描述:
每个输入数据包含一个测试点。

第一行为一个正整数n，表示发电基站的个数 (0 < n <= 200000)

接下来一行有n个空格隔开的数字，表示n个基站的海拔高度，第i个数字a[i]即为第i个基站的海拔高度，对于任意的i(1<=i<=n),有(0 <= a[i] < 2^31-1)

接下来一行有一个正整数q(0 < q <= 200000)，表示接下来有q场洪水

接下来一行有q个整数，第j个整数y[j]表示第j场洪水的海拔为y[j],对于任意的j(1<=j<=n),有(-2^31 < y[j] < 2^31-1)

输出描述:
输出q行，每行一个整数，第j行的整数ans表示在第j场洪水中，发电基站会被分割成ans个集群。标准答案保证最后一个整数后也有换行。

输入例子1:
10
6 12 20 14 15 15 7 19 18 13 
6
15 23 19 1 17 24

输出例子1:
2
0
1
1
2
0
'''

n_plant = int(input())
h_plant = list(map(int, input().split()))
n_flood = int(input())
h_flood = list(map(int, input().split()))

rsp_plant = list(range(0, n_plant+2))
rsp_plant[0], rsp_plant[-1] = -1, -1

idx_plant = [index for index, value in sorted(enumerate(h_plant), key=lambda h: h[1])]
idx_flood = [index for index, value in sorted(enumerate(h_flood), key=lambda h: h[1])]
cluster_num = [0] * n_flood
k = 0
for i in range(n_flood):
    new_cluster = 0
    while k < n_plant and h_plant[idx_plant[k]] <= h_flood[idx_flood[i]]:
        if rsp_plant[idx_plant[k]] == -1 and rsp_plant[idx_plant[k]+2] == -1:
            new_cluster -= 1
        elif rsp_plant[idx_plant[k]] != -1 and rsp_plant[idx_plant[k]+2] != -1:
            new_cluster += 1
        rsp_plant[idx_plant[k]+1] = -1
        k += 1
    if i == 0:
        cluster_num[idx_flood[i]] = 1 + new_cluster
    else:
        cluster_num[idx_flood[i]] = cluster_num[idx_flood[i-1]] + new_cluster
for c in cluster_num:
    print(c)

'''
对电站洪水海拔进行排序 这里排序后取了排序索引 利用排序索引访问数组和访问排序后的数组相同
设置一个表示当前电站的数组(rsp_plant) 在数组的前后分别加入-1 表示淹没 即不能构成集群
这样每一个点的位置判断流程相同 不需要区分第一个电站和最后一个电站的特殊情况
如果当前电站被淹没 （1）其左右都被淹没则集群数-1 （2）其左右集群数都未被淹没则集群数+1
初始集群数为1 当前集群数等于前面计算的集群数 + 洪水造成的增加的集群数

请注意： h_plant的索引和rsp_plant的索引相差1
idx_plant[index] 对应 rsp_plant[index+1]
因此rsp_plant[index]是其左边的电站 rsp_plant[index+2]是其右边的电站
while循环中包含了电站被淹的条件 所以要置rsp[index+1] = -1
'''
