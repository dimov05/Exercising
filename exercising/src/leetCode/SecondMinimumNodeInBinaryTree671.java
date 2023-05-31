package leetCode;

//Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
//
//Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
//
//If no such second minimum value exists, output -1 instead.

//Input: root = [2,2,5,null,null,5,7]
//Output: 5
//Explanation: The smallest value is 2, the second smallest value is 5.

//         Definition for a binary tree node.
//         public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }

import java.util.ArrayList;
import java.util.Collections;

public class SecondMinimumNodeInBinaryTree671 {
    public ArrayList<Integer> nums = new ArrayList<>();

    public int findSecondMinimumValue(BinaryTreeInOrderTraversal94.TreeNode root) {
        dfs(root);
        Collections.sort(nums);
        int num = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != num) {
                return nums.get(i);
            }
        }
        return -1;
    }

    private void dfs(BinaryTreeInOrderTraversal94.TreeNode node) {
        if (node == null) {
            return;
        }
        nums.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
