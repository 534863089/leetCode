package medium;

import java.util.*;

public class a451a根据字符出现频率排序 {
    public static String frequencySort(String s) {
        // > 2023/04/26 14:14:57
        // 解答成功:
        // 	执行耗时:17 ms,击败了39.62% 的Java用户
        // 	内存消耗:44.4 MB,击败了8.00% 的Java用户
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int fre = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), fre);
            max = Math.max(fre, max);
        }
        List<List<Character>> lists = new ArrayList<>(max + 1);
        for (int i = 0; i < max + 1 ; i++) {
            lists.add(i, new ArrayList<>());
        }
        for (Map.Entry<Character, Integer> next : map.entrySet()) {
            lists.get(next.getValue()).add(next.getKey());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = lists.size() - 1; i > 0; i--) {
            List<Character> characters = lists.get(i);
            if (characters.size() > 0) {
                for (Character character : characters) {
                    for (int j = 0; j < i; j++) {
                        stringBuilder.append(character.toString());
                    }
                }

            }
        }
        return stringBuilder.toString();
    }

    // 先使用「哈希表」对词频进行统计；
    // 遍历统计好词频的哈希表，将每个键值对以 {字符,词频} 的形式存储到「优先队列（堆）」中。并规定「优先队列（堆）」排序逻辑为：
    // 如果 词频 不同，则按照 词频 倒序；
    // 如果 词频 相同，则根据 字符字典序 升序（由于本题采用 Special Judge 机制，这个排序策略随意调整也可以。但通常为了确保排序逻辑满足「全序关系」，这个地方可以写正写反，但理论上不能不写，否则不能确保每次排序结果相同）；
    // 从「优先队列（堆）」依次弹出，构造答案。
    // > 2023/04/26 14:07:04
    // 解答成功:
    // 	执行耗时:11 ms,击败了85.25% 的Java用户
    // 	内存消耗:42.2 MB,击败了66.35% 的Java用户
    public String frequencySort2(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) map.put(c, map.getOrDefault(c, 0) + 1);
        // 优先队列
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
        for (char c : map.keySet()) q.add(new int[]{c, map.get(c)});
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int c = poll[0], k = poll[1];
            while (k-- > 0) sb.append((char) (c));
        }
        return sb.toString();
    }

    // 具体的，利用 ASCII 字符集共 128 位，预先建立一个大小为 128 的数组，利用「桶排序」的思路替代「哈希表」和「优先队列（堆）」的作用。
    // > 2023/04/26 14:07:41
    // 解答成功:
    // 	执行耗时:4 ms,击败了98.30% 的Java用户
    // 	内存消耗:42.2 MB,击败了64.33% 的Java用户
    public String frequencySort3(String s) {
        int[][] cnts = new int[128][2];
        char[] cs = s.toCharArray();
        // 填充 0-127
        for (int i = 0; i < 128; i++) cnts[i][0] = i;
        for (char c : cs) cnts[c][1]++;
        Arrays.sort(cnts, (a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char c = (char) cnts[i][0];
            int k = cnts[i][1];
            while (k-- > 0) sb.append(c);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}

// 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
//
// 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
//
// 示例 1:
//
// 输入: s = "tree"
// 输出: "eert"
// 解释: 'e'出现两次，'r'和't'都只出现一次。
// 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 示例 2:
//
// 输入: s = "cccaaa"
// 输出: "cccaaa"
// 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
// 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 示例 3:
//
// 输入: s = "Aabb"
// 输出: "bbAa"
// 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
// 注意'A'和'a'被认为是两种不同的字符。
// 提示:
//
// 1 <= s.length <= 5 * 10^5
// s 由大小写英文字母和数字组成
// Related Topics
// 哈希表
// 字符串
// 桶排序
// 计数
// 排序
// 堆（优先队列）
