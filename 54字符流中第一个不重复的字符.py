class Solution:
    # 返回对应char
    def __init__(self):
        self.string = ''
        self.dict = {}
        
    def FirstAppearingOnce(self):
        # write code here
        for str in self.string:
            if self.dict[str] == 1:
                return str
        return '#'
        
    def Insert(self, char):
        # write code here
        self.string += char
        if char in self.dict:
            self.dict[char] += 1
        else:
            self.dict[char] = 1
