function solution(topping) {
    var answer = 0;
    var big_brohter = new Map();
    var brother = new Map();
    //동생먼저 다 가져가라ㅋㅋ
    for(let t of topping){
        brother.set(t,(brother.get(t) || 0) +1);
    }
    for(let i=0;i<topping.length;i++){
        let unit = topping[i];
        //형 한테 주기
        big_brohter.set(unit,(big_brohter.get(unit) || 0) +1);
        
        //동생 제거
        brother.set(unit, brother.get(unit) - 1);
        if(brother.get(unit) ===0){
            brother.delete(unit);
        }
        if(brother.size === big_brohter.size) answer++;
    }
    
    
    return answer;
}
