
function solution(begin, target, words) {
    const visited = new Array(words.length).fill(false);
    var answer = dfs(visited, begin, words, target, 0);
    if(answer == null) return 0;
    return answer === Infinity ? 0 : answer;
}

//한글자만 다른건지
const isDiffentWordOne = (a,b) => {
    let count =0;
    for(let i=0;i<a.length;i++){
        if(a[i] === b[i]) count++;
    }
    return (a.length - 1) === count ? true : false;
}

const dfs = (visited, current, words, target, count) => {
  if (current === target) return count;

  let min = Infinity;

  for (let i = 0; i < words.length; i++) {
    if (!visited[i] && isDiffentWordOne(current, words[i])) {
      visited[i] = true;
      const depth = dfs(visited, words[i], words, target, count + 1);
      visited[i] = false;
      min = Math.min(min, depth);
    }
  }

  return min;
};
