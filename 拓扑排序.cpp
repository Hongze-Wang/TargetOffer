// 拓扑排序
// 核心思想 借助队列
// 首先将所有入度为0的顶点加入队列
// 然后只要队列非空 重复以下步骤：
// 出队 将所有以该出队节点的邻接点 入度减一
// 如果某点入度减零则加入队列


class Node {
public:
    int val;
};

class Graph {
public:
    vector<int> node;
    vector<vector<int>> adjmatrix;
    vector<int> indegree;
    graph(Node[] points, int[][] map) {
        for(int i=0; i<sizeof(points); i++) {
            node.push_back(points[i].val);
        }
        vector<int> temp;
        vector<int> indegreetemp(sizeof(map), 0);
        for(int i=0; i<sizeof(map); i++) {
            for(int j=0; j<sizeof(map[0]); j++)) {
                temp.push_back(map[i][j]);
                if(map[i][j] == 1) {
                    indegreetemp[j] += 1;
                }
            }
            adjmatrix.push_back(temp);
        }
        indegree = indegreetemp;
    }
};

int toposort(vector<int> &node, vector<vector<int>> &adjmatrix, vector<int> &indegree) {
    vector<int> res;
    queue<int> que;
    for(int i=0; i<n; i++) {
        if(indegree[i] == 0) {
            que.push(i);
        }
    }
    while(!que.empty()) {
        int p=que.front(); // 优先队列 使用top() 求字典序最小拓扑排血
        res.push_back(p);
        que.pop();
        int y;
        for(int i=0; i<adjmatrix[p].size(); i++) {
            if(adjmatrix[p][i]) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    que.push(i);
                }
            }
        }
    }
    if(res.size() == sizeof(adjmatrix)) {
        for(int i=0; i<res.size(); i++) {
            cout << res[i] << "\n" << endl;
        }
    } else {
        cout << "No answer!" << endl;
    }
}
