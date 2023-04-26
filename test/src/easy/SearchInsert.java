package easy;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        return binarySearch(left, right, nums, target);
    }

    // 1,3,5; t:2 -> (0,2); m:3; -> (0,0) m:1 -> (1,0) || (0,-1)
    // 递归
    // > 2023/04/17 17:16:49
    // 解答成功:
    // 	执行耗时:0 ms,击败了100.00% 的Java用户
    // 	内存消耗:41.2 MB,击败了13.26% 的Java用户
    private int binarySearch(int left, int right, int[] nums, int target) {
        int middle = (left + right) / 2;

        if (right >= left) {
            if (nums[middle] < target) {
                // 右区间
                return binarySearch(middle + 1, right, nums, target);
            } else if (nums[middle] > target) {
                // 左区间
                return binarySearch(left, middle - 1, nums, target);
            } else {
                return middle;
            }
        } else {
            if (left == middle) {
                // 左区间，middle大于target，插入到当前位置
                return middle;
            } else {
                // 右区间,插入到当前位置+1
                return middle + 1;
            }
        }
    }

    // 非递归
    // > 2023/04/17 18:36:28
    // 解答成功:
    // 	执行耗时:0 ms,击败了100.00% 的Java用户
    // 	内存消耗:41.2 MB,击败了21.02% 的Java用户
    private int binarySearch2(int left, int right, int[] nums, int target) {
        while (right >= left) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            }  else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        int middle = (left + right) / 2;
        if (left == middle) {
            // 左区间，middle大于target，插入到当前位置
            return middle;
        } else {
            // 右区间,插入到当前位置+1
            return middle + 1;
        }
    }
}


// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
// 示例 1:
//
// 输入: nums = [1,3,5,6], target = 5
// 输出: 2
// 示例 2:
//
// 输入: nums = [1,3,5,6], target = 2
// 输出: 1
// 示例 3:
//
// 输入: nums = [1,3,5,6], target = 7
// 输出: 4
// 提示:
//
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums 为 无重复元素 的 升序 排列数组
// -104 <= target <= 104
