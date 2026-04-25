import java.util.*;

public class TargetSum {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void util(int i, int[] nums, int sum) {
        if(i == nums.length/2) {
            map.put(sum, map.getOrDefault(sum, 0)+1);
            return;
        }

        util(i+1, nums, sum+nums[i]);
        util(i+1, nums, sum-nums[i]);
    }

    public static int util2(int i, int[] nums, int sum, int target) {
        if(i == nums.length) {
            int newTarget = target - sum;
            return map.getOrDefault(newTarget, 0);
        }

        return util2(i+1, nums, sum+nums[i], target) + util2(i+1, nums, sum-nums[i], target);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        util(0, nums, 0);
        int ans = util2(nums.length/2, nums, 0, target);
        System.out.println(ans);
    }
}
