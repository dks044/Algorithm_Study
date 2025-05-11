function solution(people, limit) {
    var answer = 0;
    people.sort((a,b)=>a-b);
    let left = 0
    let right = people.length-1;
    
    while(left <= right){
        let sum = people[left] + people[right];
        if(sum > limit){
            right--;
            answer++;
        }else if(sum <= limit){
            left++;
            right--;
            answer++;
        }
    }
    
    return answer;
}
