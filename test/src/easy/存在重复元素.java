package easy;

import java.util.HashMap;


public class 存在重复元素 {

    // > 2023/04/25 16:57:58
    // 解答成功:
    // 	执行耗时:10 ms,击败了71.50% 的Java用户
    // 	内存消耗:53.7 MB,击败了80.09% 的Java用户
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}

// 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
// 示例 1：
//
// 输入：nums = [1,2,3,1]
// 输出：true
// 示例 2：
//
// 输入：nums = [1,2,3,4]
// 输出：false
// 示例 3：
//
// 输入：nums = [1,1,1,3,3,4,3,2,4,2]
// 输出：true
// 提示：
//
// 1 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
// Related Topics
// 数组
// 哈希表
// 排序
