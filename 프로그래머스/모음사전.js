function solution(word) {
    var answer = 0;
    //가중치, 큰 힘에는 큰 책임이 따른다 (사전순으로 내려갈수록 가중치 붙는다)
    //(E가 A보다 더 썜)
    var weights = [781,156,31,6,1];
    var dictionary = ['A','E','I','O','U'];
    
    for(let i=0;i<word.length;i++){
        let current = word[i];
        let findword = dictionary.indexOf(current);
        answer += weights[i] * findword + 1;
    }
    
    
    return answer;
}
