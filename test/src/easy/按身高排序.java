package easy;

import java.util.Arrays;

public class 按身高排序 {
    // > 2023/04/25 09:55:11
    // 解答成功:
    // 	执行耗时:10 ms,击败了37.37% 的Java用户
    // 	内存消耗:42.2 MB,击败了18.25% 的Java用户
    public String[] sortPeople(String[] names, int[] heights) {
        int[] ints = new int[10 * 10 * 10 * 10 * 10 + 1];
        for (int i = 0; i < heights.length; i++) {
            ints[heights[i]] = i + 1;
        }
        String[] result = new String[names.length];
        int i = 0;
        for (int j = ints.length - 1; j >= 0; j--) {
            if (ints[j] > 0) {
                result[i++] = names[ints[j] - 1];
            }
        }
        return result;
    }

    // > 2023/04/25 10:47:55
    // 解答成功:
    // 	执行耗时:7 ms,击败了65.61% 的Java用户
    // 	内存消耗:42.2 MB,击败了17.54% 的Java用户
    public String[] sortPeople2(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[indices[i]];
        }
        return res;
    }
}

// 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
//
// 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
//
// 请按身高 降序 顺序返回对应的名字数组 names 。
//
// 示例 1：
//
// 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
// 输出：["Mary","Emma","John"]
// 解释：Mary 最高，接着是 Emma 和 John 。
// 示例 2：
//
// 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
// 输出：["Bob","Alice","Bob"]
// 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
// 提示：
//
// n == names.length == heights.length
// 1 <= n <= 10^3
// 1 <= names[i].length <= 20
// 1 <= heights[i] <= 10^5
// names[i] 由大小写英文字母组成
// heights 中的所有值互不相同


// Related Topics
// 数组
// 哈希表
// 字符串
// 排序
