// 直线的一般式 Ax + By + C = 0

// 根据两点求一般式 A、B、C的系数
// 设两个点为(x1, y1), (x2, y2)则有：
// A = y2-y1 B = x1-x2 C = x2y1 - x1y2  推导过程 https://baike.baidu.com/item/%E7%9B%B4%E7%BA%BF%E7%9A%84%E4%B8%80%E8%88%AC%E5%BC%8F%E6%96%B9%E7%A8%8B/11052424?fr=aladdin#3

// 判断线段是否平行
// 两直线平行表现为A1/B1 = A2/B2 即A1*B2 = A2*B1 (避免除零)

// 两平行线段的x1求最小的交点
// 四种情况 相离 只有一个交点 多个交点 内含

// 判断是否在线段上
// 记线段两端点为s,e 如果点p在线段上 那么d(s, p) + d(p, e) = d(s, e) 否则不在线段上

// 两不平行线段求交点
// a1x + b1y + c1 = 0 (1)
// a2x + b2y + c2 = 0 (2)
// (1)乘a2 (2)乘a1 两式相减得到
// y = (c1*a2 - c2*a1) / (a1*b2 - a2*b1)
// x = (c2*b1 - c1*b2) / (a1*b2 - a2*b1)
// 若(x, y) 同时在两线段上 则为所求 否则不存在

class Solution {
public:
    const double EPS = 1e-7;

    template<typename T1, typename T2, typename T3>
    bool isOnLine(T1 &p, T2 &s, T3 &e) {
        double d1 = sqrt((p[0]-s[0])*(p[0]-s[0]) + (p[1]-s[1])*(p[1]-s[1]));
        double d2 = sqrt((p[0]-e[0])*(p[0]-e[0]) + (p[1]-e[1])*(p[1]-e[1]));
        double d3 = sqrt((s[0]-e[0])*(s[0]-e[0]) + (s[1]-e[1])*(s[1]-e[1]));
        if(fabs(d1+d2-d3) <= EPS) {
            return true;
        }
        return false;
    }

    vector<double> getParameter(vector<int> &p1, vector<int> &p2) {
        double a = p2[1] - p1[1]; // A =  y2-y1
        double b = p1[0] - p2[0]; // B =  x1-x2
        double c = p2[0]*p1[1] - p1[0]*p2[1]; // C = x2y1 - x1y2
        return vector<double> {a, b, c};
    }
    
    vector<double> getIntersectionParallel(vector<int> &s1, vector<int> &e1, vector<int> &s2, vector<int> &e2) {
        vector<vector<double>> res;
        if(isOnLine(s1, s2, e2)) {
            res.push_back(vector<double> {double(s1[0]), double(s1[1])});
        } else if(isOnLine(e1, s2, e2)) {
            res.push_back(vector<double> {double(e1[0]), double(e1[1])});
        } else if(isOnLine(s2, s1, e1)) {
            res.push_back(vector<double> {double(s2[0]), double(s2[1])});
        } else if(isOnLine(e2, s1, e1)) {
            res.push_back(vector<double> {double(e2[0]), double(e2[1])});
        }
        if(res.size() == 0) {
            return vector<double> {};
        }
        sort(res.begin(), res.end(), [](vector<double> &l, vector<double> &r){
            return l[0] < r[0];
        });
        return res[0];
    }

    vector<double> intersection(vector<int> &start1, vector<int> & end1, vector<int> &start2, vector<int> &end2) {
        int dx1 = end1[0] - start1[0];
        int dy1 = end1[1] - start1[1];

        int dx2 = end2[0] - start2[0];
        int dy2 = end2[1] - start2[1];

        if(dx1*dy2 == dx2*dy1) {
            return getIntersectionParallel(start1, end1, start2, end2);
        }

        vector<double> p1 = getParameter(start1, end1);
        vector<double> p2 = getParameter(start2, end2);

        // x = (c2*b1 - c1*b2) / (a1*b2 - a2*b1)
        // y = (c1*a2 - c2*a1) / (a1*b2 - a2*b1)
        // 若(x, y) 同时在两线段上 则为所求 否则不存在
        double x = double(p2[2]*p1[1] - p1[2]*p2[1]) / double(p1[0]*p2[1] - p2[0]*p1[1]);
        double y = double(p1[2]*p2[0] - p2[2]*p1[0]) / double(p1[0]*p2[1] - p2[0]*p1[1]);

        vector<double> p{x, y};

        if(isOnLine(p, start1, end1) && isOnLine(p, start2, end2)) {
            return p;
        }
        return vector<double> {};
    }
};

// x = (c2*b1 - c1*b2) / (a1*b2 - a2*b1)
// y = (c1*a2 - c2*a1) / (a1*b2 - a2*b1)