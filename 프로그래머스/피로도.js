function solution(k, dungeons) {
    const visited = new Array(dungeons.length).fill(false);
    return dfs(visited, 0, k, dungeons);
}

const dfs = (visited, count, k, dungeons) => {
    let max = count;

    for (let i = 0; i < dungeons.length; i++) {
        const [need, use] = dungeons[i];

        if (!visited[i] && k >= need) {
            visited[i] = true;
            const next = dfs(visited, count + 1, k - use, dungeons);
            max = Math.max(max, next);
            visited[i] = false;
        }
    }

    return max;
};
