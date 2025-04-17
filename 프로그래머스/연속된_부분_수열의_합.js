function solution(sequence, k) {
    var minLength = Infinity;
    var answer = [];
    var left = 0;
    var right = 0;
    var sum = sequence[0];
    while(right < sequence.length && left <= right){
        if(sum < k){
            right++;
            if(right < sequence.length) sum += sequence[right];
        }
        if(sum > k){
            sum -= sequence[left++];
        }
        if(sum == k){
            if(minLength > (right - left)){
                answer = [left,right];
                minLength = right - left;
            }
            sum -= sequence[left++];
        }
    }
    
    return answer;
}
