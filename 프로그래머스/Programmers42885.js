function solution(people, limit) {
    var answer = 0;
    var left = 0;
    var right = people.length-1;
    people.sort((a,b)=>a-b);
    while(left <= right){
        let sum = people[left] + people[right];
        if(sum > limit){
            right--;
        }else{
            right--;
            left++;
        }
        answer++;
    }
    
    return answer;
}
