// Hash
class Solution
{
public:
    string str;
    char hash[256] = {0};
  //Insert one char from stringstream
    void Insert(char ch)
    {
        str += ch;
        hash[ch]++;
    }
  //return the first appearence once char in current stringstream
    char FirstAppearingOnce()
    {
        for(char ch : str) {
            if(hash[ch] == 1) return ch;
        }
        return '#';
    }
};