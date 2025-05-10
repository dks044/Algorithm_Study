var climbStairs = function(n) {
    const dp = new Map();
    const result = fibo(n, dp);

    return result;
};

const fibo = (n, dp) => {
    if (n <= 2) return n;

    if (!dp.has(n)) {
        dp.set(n, fibo(n - 1, dp) + fibo(n - 2, dp)); 
    }
    return dp.get(n);
};
