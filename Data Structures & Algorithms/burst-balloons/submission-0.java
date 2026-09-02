class Solution {

    int[][] memo;
    int[] nums;

    public int maxCoins(int[] nums) {

        int n = nums.length;

        this.nums = new int[n + 2];

        this.nums[0] = 1;
        this.nums[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            this.nums[i + 1] = nums[i];
        }

        memo = new int[n + 2][n + 2];

        return def(0, n + 1);
    }

    public int def(int left, int right) {

        // No balloon between left and right
        if (left + 1 == right) {
            return 0;
        }

        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        int max = 0;

        // k = last balloon to burst
        for (int k = left + 1; k < right; k++) {

            int coins = nums[left] * nums[k] * nums[right];

            int leftCoins = def(left, k);
            int rightCoins = def(k, right);

            max = Math.max(
                max,
                leftCoins + coins + rightCoins
            );
        }

        return memo[left][right] = max;
    }
}