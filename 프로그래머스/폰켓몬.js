function solution(nums) {
    const set = new Set(nums);
    const divideLength = nums.length / 2;
    return divideLength > set.size ? set.size : divideLength;
}
