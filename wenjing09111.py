# 简单的问题想复杂了 应该先思考清楚 原地merge是可以的

#字符串合并

#假设有多个字符串，现需要对相邻字符串做合并处理，要求如果一个字符串的结尾字符串和下一个字符串的开头字符串相同，
#那么合并两个字符串（如‘ab’和‘bc’合并后成为‘abc’，‘abc’和‘bc’合并后成为‘abc’）。
#字符串合并

#假设有多个字符串，现需要对相邻字符串做合并处理，要求如果一个字符串的结尾字符串和下一个字符串的开头字符串相同，
#那么合并两个字符串（如‘ab’和‘bc’合并后成为‘abc’，‘abc’和‘bc’合并后成为‘abc’）。
def concat_list(str_list):
    '''
    Input:
    list: 多个字符串，如 ['a','abc','ef','d','dd,'dc']
    Output:
    list,合并后的字符串列表，如['abc','ef', 'ddc'].
    '''
    size = len(str_list)
    res = []
    i = 0
    last = 0

    while last != res.size():
        last = res.size()
        while i < size-1:
                res.append(merge(str_list[i], str_list[i+1]))
        i += 1
      
    return res
    
def merge(s1, s2):
    res = []
    if str_list[i][-1] == str_list[i+1][0]:
        s = ""
        s1 = ""
        s2 = ""
        flag = False
        for j in range(max(len(str_list[i]), len(str_list[i+1]))):
            if j >= len(str_list[i]):
                s2 += str_list[i+1][j:]
                break
            if j >= len(str_list[i+1]):
                s2 += str_list[i][j:]
                break

            if str_list[i][j] == str_list[i+1][j]:
                flag = True
                s += str_list[i][j]
            if str_list[i][j] != str_list[i+1][j] and flag:
                s2 += str_list[i+1][j]
            if str_list[i][j] != str_list[i+1][j]:
                s1 += str_list[i][j]
        res.append(s1 + s + s2)
    else:
        res.append(str_list[i])

# written after the interview
def merge_in_place(str_list):
  idx = 0
  res = []
	for i in range(len(str_list)):
    if str_list[i][-1] == str_list[i+1][0]:
      s1, s, s2 = "", "", ""
      l1, l2 = len(len(str_list[i])), len(str_list[i+1])
      flag = false
      for j in range(max(l1, l2)):
        if j >= l1:
          s2 += str_list[i+1][j:]
          break
        if j >= l2:
          s1 += str_list[i][j]
          break
          
      	if str_list[i][j] == str_list[i+1][j]:
          flag = True
          s += str_list[i][j]
        if str_list[i] != str_list[i+1] and flag:
          s2 += str_list[i+1][j]
        if str_list[i] != str_list[i+1]:
					s1 += str_list[i][j]
      res.insert(idx, s)
      i += 1
      idx += 1
    else:
      res.insert(idx, str_list[i])
  return res
