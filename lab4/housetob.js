function rob(nums) {
    let max_accum = {};
    function solve(max_accum, nums, i) {
        if (i === 0) {
            return nums[0];
        }
        if (i === 1) {
            return Math.max(nums[0], nums[1]);
        }
        if (i in max_accum) {
            return max_accum[i];
        }
        let take = solve(max_accum, nums, i - 2) + nums[i];
        let notTake = solve(max_accum, nums, i - 1);
        max_accum[i] = Math.max(take, notTake);
        return max_accum[i];
    }
   
    let ans = solve(max_accum, nums, nums.length - 1);
    return ans;
}