public:
    bool IsPopOrder(vector<int> pushV,vector<int> popV) {
        if(pushV.size() == 0 || popV.size() == 0 || pushV.size() < popV.size()) {
            return false;
        }
        int len1 = pushV.size();
        int len2 = popV.size();
        vector<int> stack; // for a vector if add and remove from the same end it's a stack
        for(int i = 0, j = 0; i < len1; i++) {
            stack.push_back(pushV[i]);
            while(j < len2 && stack.back() == popV[j]) {
                stack.pop_back();
                j++;
            }
        }
        return stack.empty();
    }
};