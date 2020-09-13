class Solution {
public:
    bool isUnique(string astr) {
        for(int i=0; i<astr.length(); i++) {
            if(astr.find(astr[i]) != astr.rfind(astr[i])) {
                return false;
            }
        }
        return true;
    }
};