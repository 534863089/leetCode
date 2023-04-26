package easy;

import java.util.Stack;

public class 用栈实现队列 {

    /**
     * > 2023/04/25 11:10:05
     * 解答成功:
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:39.4 MB,击败了41.32% 的Java用户
     */
    class MyQueue {

        /**
         * true 已翻转; 队列顺序
         */
        boolean flag;
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            flag = false;
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            if (flag) {
                this.reverse();
            }
            if (!stack2.isEmpty()) {
                stack2.push(x);
            } else {
                stack1.push(x);
            }
        }

        public int pop() {
            if (!flag) {
                this.reverse();
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                return stack1.pop();
            }
        }

        private void reverse() {
            if (stack1.isEmpty()) {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            flag = !flag;
        }

        public int peek() {
            if (!flag) {
                this.reverse();
            }
            if (!stack2.isEmpty()) {
                return stack2.peek();
            } else {
                return stack1.peek();
            }
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}

// 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
//
// 实现 MyQueue 类：
//
// void push(int x) 将元素 x 推到队列的末尾
// int pop() 从队列的开头移除并返回元素
// int peek() 返回队列开头的元素
// boolean empty() 如果队列为空，返回 true ；否则，返回 false
// 说明：
//
// 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
// 示例 1：
//
// 输入：
// ["MyQueue", "push", "push", "peek", "pop", "empty"]
// [[], [1], [2], [], [], []]
// 输出：
// [null, null, null, 1, 1, false]
//
// 解释：
// MyQueue myQueue = new MyQueue();
// myQueue.push(1); // queue is: [1]
// myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
// myQueue.peek(); // return 1
// myQueue.pop(); // return 1, queue is [2]
// myQueue.empty(); // return false
// 提示：
//
// 1 <= x <= 9
// 最多调用 100 次 push、pop、peek 和 empty
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
// 进阶：
//
// 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
// Related Topics
// 栈
// 设计
// 队列
