package easy;

import java.util.LinkedList;
import java.util.Queue;

public class a111a二叉树的最小深度 {


    // > 2023/05/05 11:52:55
    // 解答成功:
    // 	执行耗时:1 ms,击败了97.06% 的Java用户
    // 	内存消耗:60.2 MB,击败了91.45% 的Java用户
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return bfs(root);
    }

    private int bfs(TreeNode root) {
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int i = 0;
        TreeNode rightNode = root;
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            TreeNode left = node.left;
            if (node.left != null) {
                stack.add(node.left);
            }
            TreeNode right = node.right;
            if (right != null) {
                stack.add(right);
            }

            if (null == left && null == right) {
                return i + 1;
            }
            if (rightNode.equals(node)) {
                i++;
                if (right != null) {
                    rightNode = right;
                } else if (left != null) {
                    rightNode = left;
                } else {
                    return i;
                }
            }

        }
        return i;
    }

    // 递归 深度优先遍历
    // > 2023/05/05 11:29:51
    // 解答成功:
    // 	执行耗时:9 ms,击败了38.61% 的Java用户
    // 	内存消耗:60.6 MB,击败了68.63% 的Java用户

    int depth = 0;

    public int minDepth1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        dfs(root, 1);
        return depth;
    }

    private void dfs(TreeNode root, int i) {
        if (root.left == null && root.right == null) {
            if (depth == 0 || depth > i) {
                depth = i;
            }
            return;
        }
        if (null != root.left) {
            dfs(root.left, i + 1);
        }
        if (null != root.right) {
            dfs(root.right, i + 1);
        }
    }





    public static void main(String[] args) {
        a111a二叉树的最小深度 a111a二叉树的最小深度 = new a111a二叉树的最小深度();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        a111a二叉树的最小深度.minDepth(treeNode1);
    }
}

// 给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
// 示例 1：
//
//
// 输入：root = [3,9,20,null,null,15,7]
// 输出：2
// 示例 2：
//
// 输入：root = [2,null,3,null,4,null,5,null,6]
// 输出：5
// 提示：
//
// 树中节点数的范围在 [0, 105] 内
// -1000 <= Node.val <= 1000
// Related Topics
// 树
// 深度优先搜索
// 广度优先搜索
// 二叉树
