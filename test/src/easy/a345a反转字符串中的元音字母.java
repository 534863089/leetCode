package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a345a反转字符串中的元音字母 {

    // > 2023/05/05 17:54:40
    // 解答成功:
    // 	执行耗时:6 ms,击败了20.35% 的Java用户
    // 	内存消耗:43.2 MB,击败了5.03% 的Java用户
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> dictionary = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!dictionary.contains(chars[left]) && left < right) {
                left++;
            }
            if (left > right) {
                break;
            }
            while (!dictionary.contains(chars[right]) && left < right) {
                right--;
            }
            if (left > right) {
                break;
            }
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return String.valueOf(chars);
    }


    // > 2023/05/05 17:57:02
    // 解答成功:
    // 	执行耗时:4 ms,击败了41.15% 的Java用户
    // 	内存消耗:43 MB,击败了6.36% 的Java用户
    /*static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    static Set<Character> set = new HashSet<>();

    static {
        for (char c : vowels) {
            set.add(c);
            set.add(Character.toUpperCase(c));
        }
    }

    public String reverseVowels2(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (set.contains(cs[l]) && set.contains(cs[r])) {
                swap(cs, l++, r--);
            } else {
                if (!set.contains(cs[l])) l++;
                if (!set.contains(cs[r])) r--;
            }
        }
        return String.valueOf(cs);
    }

    void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
    }*/


    // > 2023/05/05 17:58:01
    // 解答成功:
    // 	执行耗时:1 ms,击败了100.00% 的Java用户
    // 	内存消耗:43.1 MB,击败了5.03% 的Java用户
    static boolean[] hash = new boolean[128];
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    static {
        for (char c : vowels) {
            hash[c] = hash[Character.toUpperCase(c)] = true;
        }
    }

    public String reverseVowels3(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (hash[cs[l]] && hash[cs[r]]) {
                swap(cs, l++, r--);
            } else {
                if (!hash[cs[l]]) l++;
                if (!hash[cs[r]]) r--;
            }
        }
        return String.valueOf(cs);
    }

    void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
    }
}


// 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
//
// 示例 1：
//
// 输入：s = "hello"
// 输出："holle"
// 示例 2：
//
// 输入：s = "leetcode"
// 输出："leotcede"
// 提示：
//
// 1 <= s.length <= 3 * 105
// s 由 可打印的 ASCII 字符组成
// Related Topics
// 双指针
// 字符串
