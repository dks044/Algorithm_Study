function solution(n) {
    var answer = [];
    ssibal(n, 1, 3, 2, answer); // n개의 원판을 1번 기둥에서 3번 기둥으로 옮김
    return answer;
}

function ssibal(n, from, to, other, answer) {
    if (n === 0) return;
    
    // n-1개의 원판을 from에서 other로 옮김
    ssibal(n - 1, from, other, to, answer);
    
    // n번째 원판을 from에서 to로 옮김
    answer.push([from, to]);
    
    // n-1개의 원판을 other에서 to로 옮김
    ssibal(n - 1, other, to, from, answer);
}
