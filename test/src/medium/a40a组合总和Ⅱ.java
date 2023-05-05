package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a40a组合总和Ⅱ {


    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Boolean[] used = new Boolean[candidates.length];
        //不全初始化为false可能会报空指针异常,因为Boolean类型数组初始化时默认元素为null
        Arrays.fill(used, false);
        backTrack(candidates, target, 0, 0, used);
        return result;
    }

    private void backTrack(int[] candidates, int target, int sum, int startIndex, Boolean[] used) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // used[i - 1] == true，说明同⼀树⽀candidates[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层candidates[i - 1]使⽤过
            // 要对同⼀树层使⽤过的元素进⾏跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            //这⾥是i+1，每个数字在每个组合中只能使⽤⼀次的数
            backTrack(candidates, target, sum, i + 1, used);
            sum -= candidates[i]; //回溯
            used[i] = false;//回溯
            path.remove(path.size() - 1);//回溯
        }
    }

    public static void main(String[] args) {
        a40a组合总和Ⅱ a40a组合总和Ⅱ = new a40a组合总和Ⅱ();
        // [[1,1,6],[1,2,5],[1,7],[2,6]]
        System.out.println(a40a组合总和Ⅱ.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }


}

// 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
//
// 示例 1:
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
// 输出:
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// 示例 2:
//
// 输入: candidates = [2,5,2,1,2], target = 5,
// 输出:
// [
// [1,2,2],
// [5]
// ]
// 提示:
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
// Related Topics
// 数组
// 回溯
