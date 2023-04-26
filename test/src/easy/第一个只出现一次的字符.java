package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

        }
        return ' ';
    }

    // 复杂度分析
    //
    // 时间复杂度：O(n)，其中 n 是字符串 s 的长度。我们需要进行两次遍历。
    // 空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射。
    // > 2023/04/24 18:52:30
    // 解答成功:
    // 	执行耗时:25 ms,击败了39.33% 的Java用户
    // 	内存消耗:42 MB,击败了40.66% 的Java用户
    public char firstUniqChar2(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    // 方法二：使用哈希表存储索引
    // 思路与算法
    //
    // 我们可以对方法一进行修改，使得第二次遍历的对象从字符串变为哈希映射。
    //
    // 具体地，对于哈希映射中的每一个键值对，键表示一个字符，值表示它的首次出现的索引（如果该字符只出现一次）或者 −1（如果该字符出现多次）。当我们第一次遍历字符串时，设当前遍历到的字符为 c，如果 c 不在哈希映射中，我们就将 c 与它的索引作为一个键值对加入哈希映射中，否则我们将 c 在哈希映射中对应的值修改为 −1。
    //
    // 在第一次遍历结束后，我们只需要再遍历一次哈希映射中的所有值，找出其中不为 −1 的最小值，即为第一个不重复字符的索引，然后返回该索引对应的字符。如果哈希映射中的所有值均为 −1，我们就返回空格。
    // 复杂度分析
    //
    // 时间复杂度：O(n)，其中 n 是字符串 s 的长度。第一次遍历字符串的时间复杂度为 O(n)，第二次遍历哈希映射的时间复杂度为 O(∣Σ∣)，由于 s 包含的字符种类数一定小于 s 的长度，因此 O(∣Σ∣) 在渐进意义下小于 O(n)，可以忽略。
    // 空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射。
    // > 2023/04/24 18:52:55
    // 解答成功:
    // 	执行耗时:20 ms,击败了65.54% 的Java用户
    // 	内存消耗:41.9 MB,击败了48.21% 的Java用户
    public char firstUniqChar3(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        return first == n ? ' ' : s.charAt(first);
    }

    // 方法三：队列
    // 思路与算法
    //
    // 我们也可以借助队列找到第一个不重复的字符。队列具有「先进先出」的性质，因此很适合用来找出第一个满足某个条件的元素。
    //
    // 具体地，我们使用与方法二相同的哈希映射，并且使用一个额外的队列，按照顺序存储每一个字符以及它们第一次出现的位置。当我们对字符串进行遍历时，设当前遍历到的字符为 c，如果 c 不在哈希映射中，我们就将 c 与它的索引作为一个二元组放入队尾，否则我们就需要检查队列中的元素是否都满足「只出现一次」的要求，即我们不断地根据哈希映射中存储的值（是否为 −1）选择弹出队首的元素，直到队首元素「真的」只出现了一次或者队列为空。
    //
    // 在遍历完成后，如果队列为空，说明没有不重复的字符，返回空格，否则队首的元素即为第一个不重复的字符以及其索引的二元组。
    //
    // 小贴士
    //
    // 在维护队列时，我们使用了「延迟删除」这一技巧。也就是说，即使队列中有一些字符出现了超过一次，但它只要不位于队首，那么就不会对答案造成影响，我们也就可以不用去删除它。只有当它前面的所有字符被移出队列，它成为队首时，我们才需要将它移除。
    // 复杂度分析
    //
    // 时间复杂度：O(n)，其中 n 是字符串 s 的长度。遍历字符串的时间复杂度为 O(n)，而在遍历的过程中我们还维护了一个队列，由于每一个字符最多只会被放入和弹出队列最多各一次，因此维护队列的总时间复杂度为 O(∣Σ∣)，由于 s 包含的字符种类数一定小于 s 的长度，因此 O(∣Σ∣) 在渐进意义下小于 O(n)，可以忽略。
    // 空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射以及队列。
    //
    // > 2023/04/24 18:58:41
    // 解答成功:
    // 	执行耗时:25 ms,击败了39.33% 的Java用户
    // 	内存消耗:41.9 MB,击败了55.91% 的Java用户
    public char firstUniqChar4(String s) {
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

// 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例 1:
//
// 输入：s = "abaccdeff"
// 输出：'b'
// 示例 2:
//
// 输入：s = ""
// 输出：' '
// 限制：
//
// 0 <= s 的长度 <= 50000
//
// Related Topics
// 队列
// 哈希表
// 字符串
// 计数
