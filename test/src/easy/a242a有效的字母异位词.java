package easy;

public class a242a有效的字母异位词 {

    // > 2023/05/05 15:37:14
    // 解答成功:
    // 	执行耗时:4 ms,击败了40.22% 的Java用户
    // 	内存消耗:40.8 MB,击败了99.81% 的Java用户
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sInts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sInts[s.charAt(i) - 'a']++;
            sInts[t.charAt(i) - 'a']--;
        }
        for (int sInt : sInts) {
            if (sInt != 0) {
                return false;
            }
        }
        return true;
    }
}

// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
// 输出: true
// 示例 2:
//
// 输入: s = "rat", t = "car"
// 输出: false
// 提示:
//
// 1 <= s.length, t.length <= 5 * 104
// s 和 t 仅包含小写字母
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
//
// Related Topics
// 哈希表
// 字符串
// 排序
