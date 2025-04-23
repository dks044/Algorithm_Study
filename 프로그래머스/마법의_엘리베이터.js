function solution(storey) {
    var answer = 0;
    //마법의 엘리베이터를 움직이기 위해서 버튼 한 번당 마법의 돌 한 개를 사용하게 됩니다.예를 들어, 16층에 있는 민수가 0층으로 가려면 -1이 적힌 버튼을 6번, -10이 적힌 버튼을 1번 눌러 마법의 돌 7개를 소모하여 0층으로 갈 수 있습니다. 하지만, +1이 적힌 버튼을 4번, -10이 적힌 버튼 2번을 누르면 마법의 돌 6개를 소모하여 0층으로 갈 수 있습니다.
    // => 걍 이거 보면 반올림임 ㅋㅋ
    
    while(storey > 0){
        let current = storey % 10;
        let next = Math.floor((storey % 100) / 10);
        //5는 중간값이기 떄문에, 앞자리가 5이상이면 걍 올림
        if(current > 5 || (current === 5 && next >= 5)){
            answer += 10 - current;
            storey += 10 - current;
        }else{
            answer += current;
        }
        storey = Math.floor(storey / 10);
        console.log(storey)
    }
    
    return answer;
}
