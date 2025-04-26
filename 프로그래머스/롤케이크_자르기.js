function solution(topping) {
    var answer = 0;
    const big_brother = new Map();
    const brother = new Map();
    for(let t of topping){
        brother.set(t, (brother.get(t) || 0)+1 );
    }
    for(let t of topping){
        big_brother.set(t, (big_brother.get(t) || 0)+1 );
        
        brother.set(t, brother.get(t) - 1);
        if(brother.get(t) === 0){
            brother.delete(t);
        }
        
        if(big_brother.size === brother.size){
            answer++;
        }
    }
    
    
    return answer;
}
