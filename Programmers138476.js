function solution(k, tangerine) {
    var answer = 0;
    var map = new Map();
    tangerine.sort();
    for(let i of tangerine) {
        if(!map.get(i)){
            map.set(i,1);
        }else{
            let preventCount = map.get(i);
            map.set(i,preventCount + 1);
        }
    }
    const sortedByValue = new Map([...map.entries()].sort((a, b) => b[1] - a[1]));
    
    let attack =0;
    sortedByValue.forEach((value,key)=>{
        if(attack < k){
            attack += sortedByValue.get(key);
            answer++;
        }
    });
    
    
    return answer;
}
