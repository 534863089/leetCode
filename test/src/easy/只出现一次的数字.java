package easy;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class 只出现一次的数字 {

    public int singleNumber(int[] nums) {
        return singleNumber1(nums);
    }



    // > 2023/04/24 17:37:44
    // 解答成功:
    // 	执行耗时:2 ms,击败了33.75% 的Java用户
    // 	内存消耗:41.8 MB,击败了12.62% 的Java用户
    private int singleNumber1(int[] nums) {
        int pow = (int) Math.pow(10, 4);
        int[] ints = new int[6 * pow];
        for (int i = 0; i < nums.length; i++) {
            if (ints[nums[i] + 3 * pow + 1] > 0) {
                ints[nums[i] + 3 * pow + 1] = 0;
            } else {
                ints[nums[i] + 3 * pow + 1] = 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (ints[nums[i] + 3 * pow + 1] > 0) {
                return nums[i];
            }
        }
        return 0;
    }

    // 解法三：
    // 利用 Hash 表，Time: O(n) Space: O(n)
    // > 2023/04/24 17:43:08
    // 解答成功:
    // 	执行耗时:10 ms,击败了20.16% 的Java用户
    // 	内存消耗:42.2 MB,击败了5.05% 的Java用户
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }

    // 解法四：异或
    // A异或（A异或B）看作a^(a^b)=(a^a)^b，又因为a^a=0，原式可以简化成0^b=b。
    // > 2023/04/24 17:43:33
    // 解答成功:
    // 	执行耗时:1 ms,击败了97.37% 的Java用户
    // 	内存消耗:41.5 MB,击败了41.13% 的Java用户
    public int singleNumber3(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

}

// 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 O(n)
//
// 示例 1 ：
//
// 输入：nums = [2,2,1]
// 输出：1
// 示例 2 ：
//
// 输入：nums = [4,1,2,1,2]
// 输出：4
// 示例 3 ：
//
// 输入：nums = [1]
// 输出：1
// 提示：
//
// 1 <= nums.length <= 3 * 10^4
// -3 * 104 <= nums[i] <= 3 * 10^4
// 除了某个元素只出现一次以外，其余每个元素均出现两次。

