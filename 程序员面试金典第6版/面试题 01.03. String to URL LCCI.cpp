class Solution {
public:
    string replaceSpaces(string S, int length) {
        // int pos = S.length()-1;
        int pos = S.size()-1;
        for(int i=length-1; i>=0; i--) {
            if(S[i] == ' ') {
                S[pos--] = '0';
                S[pos--] = '2';
                S[pos--] = '%';
            } else {
                S[pos--] =  S[i];
            }
        }
        return S.substr(pos+1);
    }
};