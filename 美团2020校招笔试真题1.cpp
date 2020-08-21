// 美团2020秋招笔试真题1
// LRU缓存机制
// 本质上为模拟题 考虑清楚所有操作的边界条件 就能答得出来
// 这里给了C++ 解法

#include <bits/stdc++.h>
using namespace std;

void get(int key, unordered_map<int, int>& hash, list<int>& l) {
    if(hash.find(key) == hash.end()) return; // 刚刚插入 不需要更改其在缓冲区的位置 返回
    for(auto it=l.begin(), it != l.end(); it++) { // 删除原缓冲区元素
        if(*it == key) {
            l.erase(it); // 删除访问元素
            break;
        }
    }
    l.push_back(key); // 将刚刚访问的重置为缓冲区最后端
}

void put(int key, int value, unordered_map<int, int>& hash, list<int> l, int N) {
    if(hash.find(key) != hash.end()) { // 不是重复插入
        for(auto it=l.begin(); it != l.end(); it++) { // 删除原缓冲区元素
            if(*it == key) {}
            l.erase(it); // 删除访问元素
            break;
        }
        l.push_back(key);  // 将刚刚访问的重置为缓冲区最后端
        hash[key] = value; // map保存数据
        if(l.size() > N) { // 超出缓冲区最大限制
            hash.erase(*l.begin());  //删除map最左端元素
            l.pop_front(); // 删除缓冲区最左端
        }
    }
}

int main() {
    int N;
    cin >> N;
    unordered_map<int, int> hash;
    list<int> l;
    string s;
    int a, b;
    while(cin >> s) {
        if(s == "put") {
            cin >> a >> b;
            put(a, b, hash, l, N);
        } else if(s == "get") {
            cin >> a;
            get(a, hash, l);
        }
    }
    for(auto it=l.begin(); it != l.end(); it++) {
        cout << (*it) << " " << hash[*it] << endl;
    }
    return 0;
}
