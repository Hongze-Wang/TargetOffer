class StreamRank {
    List<Integer> list;

    public StreamRank() {
        list = new ArrayList<Integer>();
    }
    
    public void track(int x) {
        int idx = Collections.binarySearch(list, x);
        if(idx < 0) {     // 返回负的应插入索引+1 -(idx+1) 相等插入后是第几个元素的负值
            idx = -idx-1; // 还原成正的索引位置
        }
        list.add(idx, x);
    }
    
    public int getRankOfNumber(int x) {
        int idx = Collections.binarySearch(list, x);
        if(idx < 0) {
            idx = -idx-1;
        }
        while(idx < list.size() && list.get(idx) <= x) { // 用于处理重复相等元素存在 不会调用太多次
            idx++;
        }
        return idx;
    }
}

/**
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank obj = new StreamRank();
 * obj.track(x);
 * int param_2 = obj.getRankOfNumber(x);
 */

// 自定义BST

 class StreamRank {
    private class BST {
        private class BSTreeNode {
            BSTreeNode left;
            BSTreeNode right;
            int val, leftSize=1;

            public BSTreeNode(int val) {
                this.val = val;
            }

            public void insert(int val) {
                if(this.val >= val) {
                    this.leftSize++;
                    if(this.left == null) {
                        this.left = new BSTreeNode(val);
                    } else {
                        this.left.insert(val);
                    }
                } else {
                    if(this.right == null) {
                        this.right = new BSTreeNode(val);
                    } else {
                        this.right.insert(val);
                    }
                }
            }

            public int find(int val) {
                if(this.val > val) {
                    if(this.left == null) {
                        return 0;
                    } else {
                        return this.left.find(val);
                    }
                } else {
                    if(this.right == null) {
                        return this.leftSize;
                    } else {
                        return this.leftSize + this.right.find(val);
                    }
                }
            }
        }

        BSTreeNode root;
        public void insert(int val) {
            if(root == null) {
                root = new BSTreeNode(val);
            } else {
                root.insert(val);
            }
        }

        public int find(int val) {
            if(root == null) return 0;
            else return root.find(val);
        }
    } 

    BST bst;
    public StreamRank() {
        bst = new BST();
    }
    
    public void track(int x) {
        bst.insert(x);
    }
    
    public int getRankOfNumber(int x) {
        return bst.find(x);
    }
}

/**
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank obj = new StreamRank();
 * obj.track(x);
 * int param_2 = obj.getRankOfNumber(x);
 */