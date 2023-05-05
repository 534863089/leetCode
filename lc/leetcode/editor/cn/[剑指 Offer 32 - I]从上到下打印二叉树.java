//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
//
//
// 例如: 给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回：
//
// [3,9,20,15,7]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
//
// Related Topics 树 广度优先搜索 二叉树 👍 268 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        // 执行耗时:2 ms,击败了19.27% 的Java用户
        // 	内存消耗:41.7 MB,击败了14.44% 的Java用户
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        if (null == root) {
            return new int[0];
        }
        queue.add(root);

        recursion(result, queue);

        if (queue.size() > 1) {
            TreeNode poll = queue.poll();
            if (null != poll) {
                result.add(poll.val);
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);

        }
        return ints;

        // 执行耗时:3 ms,击败了18.01% 的Java用户
        // 	内存消耗:41.4 MB,击败了46.14% 的Java用户
        /*if (root == null) return new int[0];
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int i = 0;
        while (i < list.size()) {
            TreeNode r = list.get(i++);
            if (r != null) {
                if (r.left != null) list.add(r.left);
                if (r.right != null) list.add(r.right);
            }
        }
        return list.stream().map(n -> n.val).mapToInt(Integer::intValue).toArray();*/
    }

    private void recursion(List<Integer> result, Queue<TreeNode> queue) {
        TreeNode poll = queue.poll();
        if (null != poll) {
            result.add(poll.val);
            if (null != poll.left) {
                queue.add(poll.left);
            }
            if (null != poll.right) {
                queue.add(poll.right);
            }

            recursion(result, queue);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//leetcode submit region end(Prohibit modification and deletion)
