function solution(want, number, discount) {
    var answer = 0;

    for(let i=0;i<=discount.length-10;i++){
        let map = new Map();

        for(let j=i;j<i+10;j++){
            map.set(discount[j], (map.get(discount[j]) || 0) +1 );
        }
        if(isBuy(map,want,number)) answer++;
    }
    
    return answer;
}

const isBuy = (map,want,number) => {
    for(let i=0;i<want.length;i++){
        if(map.get(want[i]) != number[i]) return false;
    }
    
    return true;
}
