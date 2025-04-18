
function solution(video_len, pos, op_start, op_end, commands) {
    var start = calculateTime(pos,'');
    start = isOpenning(start,op_start, op_end);

    for(let command of commands){
        let parseTime = String(start.m +':'+start.s);
        start = calculateTime(parseTime,command);
        start = isOpenning(start,op_start, op_end);
        start = isOverVideo(start,video_len);
    }
    let minute_zero = '';
    let second_zero = '';
    if(start.m < 10) minute_zero = '0';
    if(start.s < 10) second_zero = '0';
    
    return String(minute_zero + start.m + ':' + second_zero + start.s);
}
const Time = (m,s) => {
    this.m = m;
    this.s = s;
    let realtime = (m* 60) + s;
    return {m,s,realtime};
}


const isOpenning = (current_time,op_start,op_end) => {
    let start = calculateTime(op_start,'');
    let end = calculateTime(op_end,'');
    
    return (
        start.realtime <= current_time.realtime && current_time.realtime <= end.realtime ?
                                                                            end : current_time
    )
}

const isOverVideo = (current_time,video_len) => {
    let end = calculateTime(video_len,'');
    return end.realtime < current_time.realtime ? end : current_time;
}

const calculateTime = (time,command) => {
    let minute = Number(time.split(':')[0]);
    let second = Number(time.split(':')[1]);
    if(command === 'next'){
        second += 10;
        if(second >= 60){
            second -= 60;
            minute += 1;
        }
    }
    
    if(command === 'prev'){
        second -= 10;
        if(second < 0){
            second = 60 + second;
            minute -= 1;
        }
    }
    
    return minute < 0 ? Time(0,0) : Time(minute,second);
}
