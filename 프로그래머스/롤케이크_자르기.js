function solution(topping) {
    var answer = 0;
    const bigBrother = new Map();
    const brother = new Map();
    for(let t of topping){
        brother.set(t, (brother.get(t) || 0) + 1 );
    }
    for(let t of topping){
        bigBrother.set(t, (bigBrother.get(t) || 0) + 1 );
        
        brother.set(t,(brother.get(t) || 0) -1 );
        if(brother.get(t) <= 0){
            brother.delete(t);
        }
        if(bigBrother.size === brother.size) answer++;
    }
    
    return answer;
}
