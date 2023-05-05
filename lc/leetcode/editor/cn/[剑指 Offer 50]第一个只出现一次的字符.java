//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例 1:
//
//
//输入：s = "abaccdeff"
//输出：'b'
//
//
// 示例 2:
//
//
//输入：s = ""
//输出：' '
//
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 50000
//
// Related Topics 队列 哈希表 字符串 计数 👍 323 👎 0


import java.util.Map;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Character> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(ch);
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek()) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? ' ' : queue.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
