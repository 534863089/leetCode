package easy;

public class a344a反转字符串 {
    // > 2023/05/05 17:18:55
    // 解答成功:
    // 	执行耗时:0 ms,击败了100.00% 的Java用户
    // 	内存消耗:49.8 MB,击败了5.03% 的Java用户
    public void reverseString(char[] s) {
        for (int i = 0; i <= (s.length - 2) / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    // > 2023/05/05 17:20:57
    // 解答成功:
    // 	执行耗时:0 ms,击败了100.00% 的Java用户
    // 	内存消耗:49.6 MB,击败了5.03% 的Java用户
    // 双指针法
    public void reverseString2(char[] s) { // 双指针法
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    // > 2023/05/05 17:27:05
    // 解答成功:
    // 	执行耗时:0 ms,击败了100.00% 的Java用户
    // 	内存消耗:49.4 MB,击败了5.03% 的Java用户
    // 异或
    public void reverseString3(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];
            // s[left] ^= s[right] ^= s[right]
            s[right] ^= s[left];
            // s[left] ^= s[left] ^= s[right] ^= s[left]
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}

// 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
// 示例 1：
//
// 输入：s = ["h","e","l","l","o"]
// 输出：["o","l","l","e","h"]
// 示例 2：
//
// 输入：s = ["H","a","n","n","a","h"]
// 输出：["h","a","n","n","a","H"]
// 提示：
//
// 1 <= s.length <= 105
// s[i] 都是 ASCII 码表中的可打印字符
// Related Topics
// 双指针
// 字符串
//
// 👍 769
// 👎 0
