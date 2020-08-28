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
    // return hash[key];
}

void put(int key, int value, unordered_map<int, int>& hash, list<int>& l, int N) {
    if(hash.find(key) != hash.end()) { // 不是重复插入
        for(auto it=l.begin(); it != l.end(); it++) { // 删除原缓冲区元素
            if(*it == key) {}
            l.erase(it); // 删除访问元素
            break;
        }
    }
    l.push_back(key);  // 将刚刚访问的重置为缓冲区最后端
    hash[key] = value; // map保存数据
    if(l.size() > N) { // 超出缓冲区最大限制
        hash.erase(*l.begin());  //删除map最左端元素
        l.pop_front(); // 删除缓冲区最左端
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

// 可运行版本

#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;

void get(int key, unordered_map<int, int>& hash, list<int>& list) {
	if (hash.find(key) == hash.end()) return; // if last "get" operation get the same key, we do not need any further modification // return hash[key]
	for (auto it = list.begin(); it != list.end(); it++) {
		if (*it == key) {
			list.erase(it);
			break; // necessary
		}
	}
	list.push_back(key);
	// return hash[key]
	// search use map
	// least used info using double list (queue actually) to maintain
}

void put(int key, int value, unordered_map<int, int>& hash, list<int>& list, int N) {
	if (hash.find(key) != hash.end()) { // not duplicate put operation
		for (auto it = list.begin(); it != list.end(); it++) {
			if (*it == key) {
				list.erase(it);
				break; // necessary
			}
		}
	}
	list.push_back(key);
	hash[key] = value;
	if (list.size() > N) {
		hash.erase(*list.begin());
		list.pop_front();
	}
}

int main() {
	int N;
	cin >> N;
	unordered_map<int, int> hash;
	list<int> l;
	string s;
	int a, b;
	while (cin >> s) {
		if (s == "put") {
			cin >> a >> b;
			put(a, b, hash, l, N);
		}
		else if (s == "get") {
			cin >> a;
			get(a, hash, l);
		}
		else {
			cout << "illeagal operation!" << endl;
		}
	}
	for (auto it = l.begin(); it != l.end(); it++) {
		cout << *it << " " << hash[*it] << endl;
	}
	return 0;
}
// list erase need pointer as parameter
// hash erase need content as parameter *pointer = context
