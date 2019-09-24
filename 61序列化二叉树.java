/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    int index = -1;
    String Serialize(TreeNode root) {
        if(root == null) return "#!";
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + "!");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    
    TreeNode Deserialize(String s) {
        index++;
        if(index >= s.length()) return null;
        String[] str = s.split("!");
        TreeNode node = null;
        if(!(str[index].equals("#"))) { //不能使用 ==
            node = new TreeNode(Integer.valueOf(str[index]));
            node.left = Deserialize(s);
            node.right = Deserialize(s);
        }
        return node;
    }
}