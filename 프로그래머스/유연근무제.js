function solution(schedules, timelogs, startday) {
    var answer = 0;
    
    for(let i=0;i<timelogs.length;i++){
        let daycount = startday;
        let workcount = 0;
        let eventWork = eventTime(schedules[i]);
        for(let j=0;j<timelogs[i].length;j++){
            if(daycount == 8) daycount = 1;
            if(daycount == 6 || daycount == 7){
                daycount++;
                continue;
            }
            if(timelogs[i][j] <= eventWork){
                workcount++;
            }
            daycount++;
        }
        if(workcount == 5) answer++;
    }
    return answer;
}

const eventTime = (current) => {
    let hour = Math.floor(current / 100);
    let minute = current % 100;
    minute +=10;
    if(minute >= 60){
        hour++;
        minute -= 60;
    }
    return (hour * 100) + minute;
}
