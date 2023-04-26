package easy;

import java.util.HashMap;

public class 环形链表 {

    // > 2023/04/24 18:02:27
    // 解答成功:
    // 	执行耗时:5 ms,击败了5.41% 的Java用户
    // 	内存消耗:42.5 MB,击败了57.52% 的Java用户
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (null != head) {
            if (null != map.get(head)) {
                return true;
            } else {
                map.put(head, 1);
            }
            head = head.next;
        }
        return false;
    }

    // > 2023/04/24 18:19:42
    // 解答成功:
    // 	执行耗时:0 ms,击败了100.00% 的Java用户
    // 	内存消耗:42.7 MB,击败了23.75% 的Java用户
    public boolean hasCycle2(ListNode head) {
        // 双指针？
        if (null == head) {
            return false;
        }
        ListNode second = head.next;
        while (null != second) {
            if (head == second) {
                return true;
            } else {
                head = head.next;
                if (null == head) {
                    return false;
                }
                if (null == second.next) {
                    return false;
                }
                second = second.next.next;
            }
        }
        return false;
    }
}

// 给你一个链表的头节点 head ，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
// 输入：head = [3,2,0,-4], pos = 1
// 输出：true
// 解释：链表中有一个环，其尾部连接到第二个节点。
// 示例 2：
//
//
//
// 输入：head = [1,2], pos = 0
// 输出：true
// 解释：链表中有一个环，其尾部连接到第一个节点。
// 示例 3：
//
//
//
// 输入：head = [1], pos = -1
// 输出：false
// 解释：链表中没有环。
// 提示：
//
// 链表中节点的数目范围是 [0, 10^4]
// -10^5 <= Node.val <= 10^5
// pos 为 -1 或者链表中的一个 有效索引 。
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
//
// Related Topics
// 哈希表
// 链表
// 双指针
