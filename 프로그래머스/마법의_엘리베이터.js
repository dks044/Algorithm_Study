function solution(storey) {
    var answer = 0;
    while(storey > 0){
        let current = storey % 10;
        let next = Math.floor( (storey % 100) / 10 );
        if(current > 5 || (next >=5 && current === 5)){
            answer += 10 - current;
            storey += 10 - current;
        }else{
            answer += current;
        }
        storey = Math.floor(storey / 10);
    }
        
        
    return answer;
}
