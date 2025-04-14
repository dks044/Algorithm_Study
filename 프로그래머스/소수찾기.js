function solution(numbers) {
    var answer = 0;
    var visited = Array(numbers.length).fill(false);
    var set = new Set();
    dfs(visited,numbers,set,'');

    set.forEach((value)=>{
        if(isPrime(value)) answer++;
    })
    return answer;
}

function dfs(visited,numbers,set,word) {
    for(let i=0;i<numbers.length;i++){
        if(!visited[i]){
            visited[i] = true;
            set.add(parseInt(word + numbers[i]));
            dfs(visited,numbers,set,word + parseInt(numbers[i]));
            visited[i] = false;
        }
    }
}

const isPrime = (num) => {
    if(num < 2) return false;
    for(let i=2;i<=Math.sqrt(num);i++){
        if(num % i ==0) return false;
    }
    return true;
}
