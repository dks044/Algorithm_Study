function solution(n, lost, reserve) {
    // 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
    // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
    // 이때 이 학생은 체육복을 하나만 도난당했다고 가정
    var answer = 0;
    const currentStudents = new Array(n).fill(1);
    
    for(let i=0;i<reserve.length;i++){
        currentStudents[reserve[i]-1] = 2;
    }
    for(let i=0;i<lost.length;i++){
        currentStudents[lost[i]-1] -= 1;
    }
    
    for(let i=0;i<n;i++){
        if(currentStudents[i]==0){
            if(i > 0 && currentStudents[i-1] === 2){
                currentStudents[i-1]--;
                currentStudents[i]++;
            }
            else if(i < n-1 && currentStudents[i+1]===2){
                currentStudents[i+1]--;
                currentStudents[i]++;
            }
        }
    }
    var count = 0;
    for(let i=0;i<n;i++){
        if(currentStudents[i] >0) count++;
    }
    
    return count;
}
