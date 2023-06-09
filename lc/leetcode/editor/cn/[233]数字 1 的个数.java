//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
//
//
//
// 示例 1：
//
//
//输入：n = 13
//输出：6
//
//
// 示例 2：
//
//
//输入：n = 0
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= n <= 10⁹
//
//
// Related Topics 递归 数学 动态规划 👍 507 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int ans = 0; for (int i = 1; i <= n; i *= 10) { ans += (n / (i * 10)) * i + Math.min(Math.max(n % (i * 10) - i + 1,0), i); } return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
