//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
//
// Related Topics 数组 回溯 👍 1326 👎 0


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> combine = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            if (!map.containsKey(candidates[i])) {
                map.put(candidates[i], i);
            }
        }
        dfs(candidates, target, ans, combine, 0, map);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> combine, int idx, HashMap<Integer, Integer> map) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        if (idx == candidates.length) {
            return;
        }
        if (!combine.contains(candidates[idx])) {
            if (map.get(candidates[idx]) == idx) {
            } else if (map.get(candidates[idx]) < idx) {
                return;
            }
        }

        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx + 1, map);
            combine.remove(combine.size() - 1);
        }
        dfs(candidates, target, ans, combine, idx + 1, map);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
