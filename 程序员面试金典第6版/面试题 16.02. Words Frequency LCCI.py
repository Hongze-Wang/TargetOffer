from collections import defaultdict
class WordsFrequency:

    def __init__(self, book: List[str]):
        self.dic = defaultdict(int)
        for s in book:
            self.dic[s] += 1 # self.dic[s] = self.dic.get(s, 0) + 1


    def get(self, word: str) -> int:
        return self.dic[word]

# from collections import Counter

# class WordsFrequency:

#     def __init__(self, book: List[str]):
#         self.dic = Counter(book)
    
#     def get(self, word: str) -> int:
#         return self.dic.get(word, 0)

# Your WordsFrequency object will be instantiated and called as such:
# obj = WordsFrequency(book)
# param_1 = obj.get(word)