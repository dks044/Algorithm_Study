function solution(prices) {
    const answer = new Array(prices.length).fill(0);
    for(let i=0;i<prices.length;i++){
        let index = i+1;
        while(index < prices.length){
            answer[i]++;
            if(prices[i] <= prices[index]){
                index++;   
            }else break;
        }
    }
    
    
    return answer;
}
