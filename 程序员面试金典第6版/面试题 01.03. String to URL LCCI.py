class Solution:
    def replaceSpaces(self, S: str, length: int) -> str:
        S = S[:length].replace(" ", "%20")
        return S

class Solution:
    def replaceSpaces(self, S: str, length: int) -> str:
        return "%20".join(S[:length].split(" "))