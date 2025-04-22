function solution(numbers, target) {
    return dfs(numbers, target, 0, 0);
}

const dfs = (numbers, target, sum, depth) => {
    if (depth === numbers.length) {
        return sum === target ? 1 : 0;
    }

    return dfs(numbers, target, sum + numbers[depth], depth + 1) +
           dfs(numbers, target, sum - numbers[depth], depth + 1);
}
