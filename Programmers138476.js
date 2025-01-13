function solution(k, tangerine) {
    var answer = 0;
    var map = new Map();
    for(let fruit of tangerine){
        if(!map.get(fruit)){
            map.set(fruit,1);
        }else{
            let prventCount = map.get(fruit);
            map.set(fruit, prventCount +1);
        }
    }
    var sortedDescMap = new Map([...map.entries()].sort((a,b)=> b[1] - a[1]));
    
    let fruitStoreage = 0;
    sortedDescMap.forEach((value,key)=> {
        if(fruitStoreage < k){
            fruitStoreage += value;
            answer++;
        }
    })
    
    return answer;
}
