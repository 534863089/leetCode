//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//
//
// 只使用数字1到9
// 每个数字 最多使用一次
//
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
//
//
//
// 示例 1:
//
//
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。
//
// 示例 2:
//
//
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。
//
// 示例 3:
//
//
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
//
//
//
//
// 提示:
//
//
// 2 <= k <= 9
// 1 <= n <= 60
//
//
// Related Topics 数组 回溯 👍 668 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int min = 0;
        int max = 0;
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            min += i + 1;
            max += 9 - i;
            ints[i] = i + 1;
        }
        if (min > n) {
            return result;
        }
        if (max < n) {
            return result;
        }

        while (ints[0] <= 10 - k) {
            loop(n, result, ints);

            for (int i = 1; i <= k; i++) {
                if (ints[k - i] < 10 - i) {
                    ints[k - i] += 1;
                    int plus = 1;
                    for (int j = i - 1 ; j > 0; j--) {
                        ints[k - j] = ints[k - i] + plus++;
                    }
                    break;
                } else if (i == k) {
                    ints[k - i] += 1;
                }

            }
        }

        return result;

    }

    private static void loop(int n, ArrayList<List<Integer>> result, int[] ints) {
        int val = 0;
        for (int i = ints.length - 1; i >= 0; i--) {
            val += ints[i];
            if (val > n) {
                break;
            }
        }
        if (val == n) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < ints.length; i++) {
                list.add(ints[i]);
            }
            result.add(list);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
