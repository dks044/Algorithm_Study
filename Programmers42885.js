function solution(people, limit) {
    var answer = 0;
    people.sort((a,b)=>a-b);
    var slender = 0;
    var royder = people.length -1;

    while(slender <= royder){
        let sum = people[slender] + people[royder];
        if(sum > limit){
            royder--;
        }else{
            slender++;
            royder--;
        }
        answer++;
    }
    
    return answer;
}
