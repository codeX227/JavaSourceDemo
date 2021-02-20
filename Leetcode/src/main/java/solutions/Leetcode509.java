package solutions;

import java.util.Vector;

/**
 * @Description 斐波那契额数列
 * @Author Goodenough
 * @Date 2021/2/20 15:23
 */
public class Leetcode509 {
    /**
     * 1.备忘录优化解
     */
    public int fib(int n) {
        if (n == 0)
            return 0;

        int[] temp = new int[n];

        return helper(temp, n);
    }
    public int helper(int[] temp, int n) {

        if (n == 1 || n == 2)
            return 1;
        if(temp[n-1] != 0){
            return temp[n-1];
        }
        temp[n-1] = helper(temp, n-1) + helper(temp, n-2);

        return temp[n-1];
    }

    /**
     * 2.循环解法
     */
    int fib2(int N) {
        if (N < 1) return 0;
        if (N == 1 || N == 2) return 1;
        int[] dp = new int[N];
        // base case
        dp[1] = dp[2] = 1;
        for (int i = 3; i < N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[N-1];
    }

    /**
     * 3.循环内存优化
     */
    int fib3(int n) {
        if (n < 1) return 0;
        if (n == 2 || n == 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
