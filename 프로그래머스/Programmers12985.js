function solution(n,a,b)
{
    let round = 0;
    while(n > 1){
        round++;
        // 서로 만나는지 확인
        if (Math.abs(a - b) === 1 && Math.min(a, b) % 2 === 1) {
            break;
        }
        // 다음 라운드로 진출
        a = Math.ceil(a / 2);
        b = Math.ceil(b / 2);
        n /= 2;
    }

    return round;
}
