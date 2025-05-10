function solution(land) {
    var answer = 0;
    const dp = [];
    
    //dp 테이블 ㄱㄱ
    for(let i=0;i<land.length;i++){
        dp[i] = land[i].slice();
    }

    for(let i=1;i<land.length;i++){
        for(let j=0;j<4;j++){
            const prev = dp[i-1].filter((value,index) => index !== j);
            dp[i][j] = Math.max(...prev) + land[i][j];
        }
    }
    
    return Math.max(...dp[land.length-1]);
}
