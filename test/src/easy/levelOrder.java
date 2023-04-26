package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class levelOrder {

    public int[] levelOrder(TreeNode root) {
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

    TreeNode(int x) {
        val = x;
    }
}

class solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
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
        return list.stream().map(n -> n.val).mapToInt(Integer::intValue).toArray();
    }
}
