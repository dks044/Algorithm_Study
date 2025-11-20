function solution(board, moves) {
    var answer = 0;
    var bl = board.length;
    const bucket = [];

    for(let move of moves){
        let index = 0;
        while(index < bl && move >= 0 && board[index][move-1] >= 0){
            let findDoll = board[index][move-1];

            if(findDoll > 0){
                bucket.push(findDoll);
                board[index][move-1] = 0;
                let bucketlength = bucket.length;
                if(bucket.length > 0){
                    if(bucket[bucketlength-1-1] === findDoll){
                        bucket.pop();
                        bucket.pop();
                        answer += 2;
                    }
                }
                break;
            }
            index++;
        }
    }
        console.log(bucket);
        
    return answer;
}
