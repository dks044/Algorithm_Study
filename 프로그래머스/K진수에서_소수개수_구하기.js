function solution(n, k) {
    var answer = 0;
    var nums = parse(n,k).split('0');
    for(let i of nums){
        let currentNum = parseInt(i);
        if(!isNaN(currentNum)){
            if(isPrime(currentNum)){
                 answer++;
            }
        }
    }
    return answer;
}

const parse = (n,k) => {
    let number  = '';
    while(n > 0){
        number += String(n % k);
        n = Math.floor(n / k);
    }
    return number.split('').reverse().join('');
}

const isPrime = (n) => {
    if(n < 2) return false;
    for(let i=2;i<=Math.sqrt(n);i++){
        if(n % i ==0) return false;
    }
    return true;
}
