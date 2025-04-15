

function solution(sequence, k) {
    let min = Infinity;
    var answer = [];
    let left = 0;
    let right = 0;
    let sum = sequence[0];
    
    while(left <= right && right < sequence.length){
        if(sum < k){
            right++;
            if (right < sequence.length) sum += sequence[right];
        }
        else if(sum > k){
            sum -= sequence[left++];
        }else{
            if(min > (right - left)) {
                min = right - left;
                answer = [left,right];
            }
            sum -= sequence[left++];
        }
    }
    return answer;
}

