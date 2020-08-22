'''
作者：爱玩矢量
链接：https://www.nowcoder.com/discuss/484925?channel=1013&source_id=home_feed
来源：牛客网

8.21 阿里笔试

爱玩矢量#笔试#
编辑于 2020-08-21 21:57:35APP内打开赞 14 | 收藏 32 | 回复20 | 浏览25088.21 阿里笔试APP内打开 分享给朋友 14 32 20
第一题
容易想到的过河方案就是最轻的人作为摆渡人，一趟一趟运
还有一种是，最轻的人把第二轻的送到对岸，自己回来，再让最重的两个人过去，第二轻的再把船划回来
一直比较这两种方案，直到人数小于3
'''

def first():
    t = int(input())
    for _ in range(t):
        n = int(input())
        weight = list(map(int, input().split(' ')))
        weight.sort()
        res = 0
 
        while n > 3:
            res += min(weight[1] * 2 + weight[0] + weight[-1], weight[0] * 2 + weight[-1] + weight[-2])
            weight.pop()
            weight.pop()
            n -= 2
 
        if n == 1 or n == 3:
            res += sum(weight)
        elif n == 2:
            res += max(weight)
 
        print(res)

'''
第二题
这个题我是自己枚举了3、4、5、6的情况，在草稿纸上发现的规律
从特殊到一般，我就是猜测规律
假设 A选点，B先走，A再走
我估计是 B 必胜，每次A、B都会选权值最大的点，但我不会证明
最后一分钟提交，本来想着能过多少算多少，居然AC了，其实是没想到的....
举个5个顶点的例子
B占据引导的地位，来左右A的路线

开始A选权值最大的点
B走到权值第二大的点
A走到权值第三大的点
B回到权值最大的点
A走到权值第四大的点
B回到权值第二大的点
A走到权值第五大的点
B回到权值最大的点
A无路可走，B获胜

计算权值和的时候就会发现代码里的规律了
'''

def second():
    n = int(input())
    perfect = list(map(int, input().split(' ')))
    res = 0
    perfect.sort()
    for i in range(n - 1):
        res += perfect[-1] * perfect[i]
    for i in range(n - 2):
        res += perfect[-2] * perfect[i]
    print(res)
