/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> BSTSequences(TreeNode* root) {
        if(!root) return {{}};
        deque<TreeNode*> q;
        vector<int> path;
        vector<vector<int>> res;

        q.push_back(root);
        findPath(q, path, res);
        return res;
    }

    void findPath(deque<TreeNode*> &q, vector<int> &path, vector<vector<int>> &res) {
        if(q.empty()) { // 递归出口
            res.push_back(path);
            return;
        }
        int size = q.size();
        while(size--) {
            TreeNode* cur = q.front(); q.pop_front(); // 该操作递归结束后需要还原 A1
            path.push_back(cur->val);                 // 该操作递归结束后需要还原 A2
            int children = 0;                         // 记录需要还原的次数
            if(cur->left) {
                children++;
                q.push_back(cur->left);               // 该操作递归结束后需要还原 B1
            }
            if(cur->right) {
                children++;
                q.push_back(cur->right);              // 该操作递归结束后需要还原 B2
            }
            findPath(q, path, res);                   // 递归
            // 递归完成 复位 恢复上下文 以便循环的下一次递归
            while(children--) {
                q.pop_back();                         // B1 B2
            }
            q.push_back(cur);                         // A1 从队头取出 复位时加入队尾 这是为什么使用双端队列的原因 Java解法使用ArrayList其实也一样
            path.pop_back();                          // A2
        }
    }
};