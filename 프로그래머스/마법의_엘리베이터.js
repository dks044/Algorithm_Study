function solution(storey) {
    let answer = 0;

    while (storey > 0) {
        const digit = storey % 10;
        const next = Math.floor((storey % 100) / 10);
        

        if (digit > 5 || (digit === 5 && next >= 5)) {
            answer += 10 - digit;
            storey += 10 - digit; 
            console.log(answer);
            console.log(storey);
        } else {
            answer += digit;
        }

        storey = Math.floor(storey / 10);
    }

    return answer;
}
