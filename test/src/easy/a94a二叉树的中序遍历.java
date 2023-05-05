package easy;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class a94a二叉树的中序遍历 {

    // > 2023/05/05 15:04:03
    // 解答成功:
    // 	执行耗时:0 ms,击败了100.00% 的Java用户
    // 	内存消耗:40 MB,击败了7.84% 的Java用户
    // 非递归
    // 中序遍历
    // 左-根-右
    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (null != root.left) {
            stack.push(root.left);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            // 左/中
            TreeNode pop = stack.pop();
            list.add(pop.val);
            // 右
            if (null != pop.right) {
                stack.push(pop.right);
                pop = pop.right;
                while (null != pop.left) {
                    stack.push(pop.left);
                    pop = pop.left;
                }
            }
        }
        return list;
    }

    // > 2023/05/05 15:10:45
    // 解答成功:
    // 	执行耗时:0 ms,击败了100.00% 的Java用户
    // 	内存消耗:39.6 MB,击败了71.56% 的Java用户
    // 递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }
        List<Integer> result = new ArrayList<>();
        // 中序遍历
        middleOrder(root, result);
        return result;
    }

    private void middleOrder(TreeNode root, List<Integer> result) {
        // 左
        if (null != root.left) {
            middleOrder(root.left, result);
        }
        // 中
        result.add(root.val);
        // 右
        if (null != root.right) {
            middleOrder(root.right, result);
        }
    }
}

// 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 示例 1：
//
//
// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
// 示例 2：
//
// 输入：root = []
// 输出：[]
// 示例 3：
//
// 输入：root = [1]
// 输出：[1]
// 提示：
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics
// 栈
// 树
// 深度优先搜索
// 二叉树
