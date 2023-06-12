class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int max = 0;
        int min =0; 
        for(int b : budgets) if(b > max) max=b;
        //최솟값이 최댓값을 수렴할떄까지
        while(min <= max){
            int mid = (max + min) /2; //중간값
            
            int sum =0;
            for(int i=0;i<budgets.length;i++){
                if(budgets[i]>mid) sum+=mid;
                else sum += budgets[i];
            }
            if(sum <= M){
                min = mid +1;
                answer = mid;
            }else{
                max = mid -1;
            }
            
        }
        
        
        
        return answer;
    }//solution
}
