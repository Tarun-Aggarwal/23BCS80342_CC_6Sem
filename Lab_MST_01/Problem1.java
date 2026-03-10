// package Lab_MST_01;
import java.util.*;

public class Problem1 {

    public static int solve(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            if(a[1]-a[0] != b[1]-b[0]) {
                return Integer.compare(b[1]-b[0], a[1]-a[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        int ans = 0;
        int rem = 0;
        for(int[] task: tasks) {
            int actual = task[0];
            int min = task[1];
            if(rem < min) {
                ans += min-rem;
                rem = min;
            }
            if(rem < actual) {
                ans += actual-rem;
                rem = actual;
            }
            rem -= actual;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {4, 8}};
        int[][] tasks2 = {{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}};
        System.out.println(solve(tasks));
        System.out.println(solve(tasks2));
    }
}
