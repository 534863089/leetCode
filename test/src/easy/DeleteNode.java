package easy;

// 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//
// 返回删除后的链表的头节点。
//
// 注意：此题对比原题有改动
//
// 示例 1:
//
// 输入: head = [4,5,1,9], val = 5
// 输出: [4,1,9]
// 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 示例 2:
//
// 输入: head = [4,5,1,9], val = 1
// 输出: [4,5,9]
// 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 说明：
//
// 题目保证链表中节点的值互不相同
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
// Related Topics
// 链表
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
        }

        ListNode current = head;
        ListNode next = head.next;
        while (null != next) {
            if (next.val == val) {
                current.next = next.next;
            }
            current = next;
            next = current.next;
        }

        return head;
    }

}

class  ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// 解答成功:
// 	执行耗时:0 ms,击败了100.00% 的Java用户
// 	内存消耗:40.6 MB,击败了92.14% 的Java用户
