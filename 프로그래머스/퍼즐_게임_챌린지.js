function solution(diffs, times, limit) {
    //diff: 난이도 | level: 숙련도
    
    //diff ≤ level => time_cur만큼의 시간을 사용하여 해결
    //diff > level => (time_prev + time_cur) * (diff-level) + time_cur
    
    
    let left = 1
    let right = 100_001
    let minLevel = Infinity;
    while(left <= right){
        let midDiff = Math.floor( (right + left) / 2);
        let timeSum = times[0];
        for(let i=1;i<times.length;i++){
            if(midDiff >= diffs[i]){
                timeSum += times[i];
            }else{
                timeSum += (times[i-1] + times[i]) * (diffs[i] - midDiff) + times[i];
            }
        }
        if(timeSum > limit){
            left = midDiff + 1;
        }else{
            right = midDiff - 1;
            minLevel = Math.min(minLevel,midDiff);
        }
    }

    return minLevel;
}
