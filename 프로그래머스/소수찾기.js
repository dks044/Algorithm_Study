
function solution(numbers) {
    var answer = 0;
    const visited = new Array(numbers.length).fill(false);
    const filterNums = new Set();
    dfs(visited,filterNums,"",numbers);
    filterNums.forEach((v)=>{
        console.log(v);
        if(isPrime(v)) answer++;
    })
    
    return answer;
}

const dfs = (visited,filterNums,word,numbers) => {
    for(let i=0;i<numbers.length;i++){
        if(!visited[i]){
            filterNums.add(Number(word + numbers[i]));
            visited[i]=true;
            dfs(visited,filterNums,word + numbers[i],numbers);
            visited[i]=false;
        }
    }
}

const isPrime = (filterNum) => {
    if(filterNum < 2) return false;
    for(let i=2;i<=Math.sqrt(filterNum);i++){
        if(filterNum % i === 0) return false;
    }
    
    return true;
}
