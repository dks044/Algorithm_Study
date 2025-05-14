function solution(land) {
    var answer = 0;
    const dp = [...land];
    
    for(let i=1;i<land.length;i++){
        for(let j=0;j<4;j++){
            const prev = land[i-1].filter((v,index)=> index !== j);
            dp[i][j] = Math.max(...prev) + dp[i][j];
        }
    }
    
    return Math.max(...dp[land.length-1]);
}
