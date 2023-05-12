class Solution {
    public int solution(int[] common) {
        int answer = 0;
    
        int temp =common[1]-common[0];
        int temp2=(common[2]-common[1]);
        //공차 배열인덱스 0번쨰랑 1번쨰 그리고, 1번쨰랑 2번쨰의 차이가 같을경우
        //공비 배열인덱스1 나누기 배열인덱스0
        if(temp == temp2){
            return answer = common[common.length-1]+temp; //공차
        }else{
            int gongBee = common[1]/common[0];          //공비
            return common[common.length-1]*gongBee;
        }
        
        
        

    }
}
