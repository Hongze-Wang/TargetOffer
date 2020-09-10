# 第三题：字符串编码的压缩，按一定压缩规则把字母数字组合转换成数字

s = input()
i, segment = 0, []# 第三题：字符串编码的压缩，按一定压缩规则把字母数字组合转换成数字

s = input()
i, segment = 0, []
while i+5 < len(s):
    segment.append(s[i: i+5])
    i += 5
segment.append(s[i:])

def transfer_char(s):
    if 'a' <= s <= 'z':
        return ord(s) - 96
    elif 'A' <= s <= 'Z':
        return ord(s) - 64 + 26
    elif '0' <= s <= '9':
        return int(s) + 53
    else:
        return 0

def transfer_seg(s):
    res = transfer_char(s[0])
    for t in s[1:]:
        res <<= 6
        res += transfer_char(t)
    return res

res = []
for t in segment:
    out = transfer_seg(t)
    res.append(str(out))

ans = " ".join(res)
print(ans)
while i+5 < len(s):
    segment.append(s[i: i+5])
    i += 5
segment.append(s[i:])

def transfer_char(s):
    if 'a' <= s <= 'z':
        return ord(s) - 96
    elif 'A' <= s <= 'Z':
        return ord(s) - 64 + 26
    elif '0' <= s <= '9':
        return int(s) + 53
    else:
        return 0

def transfer_seg(s):
    res = transfer_char(s[0])
    for t in s[1:]:
        res <<= 6
        res += transfer_char(t)
    return res

res = []
for t in segment:
    out = transfer_seg(t)
    res.append(str(out))

ans = " ".join(res)
print(ans)
