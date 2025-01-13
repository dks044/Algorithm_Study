import java.util.*;
class Solution {
    public int solution(int[] numbers) {
            int answer = 0;
            if(numbers.length ==2){
                return answer= numbers[0]*numbers[1];
            }
        
	        ArrayList<Integer> minus_arr = new ArrayList<>();
	        for(int i=0;i<numbers.length;i++){
	            if(numbers[i]<0){
	                minus_arr.add(numbers[i]);
	            }
	        }
	        Collections.sort(minus_arr);
            int m_max=0;
            if(minus_arr.size()>=2){
                m_max = minus_arr.get(0)*minus_arr.get(1); //음수의 곱중 높은값
	            System.out.println(m_max);   
            }
            Arrays.sort(numbers);
            int p_max = numbers[numbers.length-1]*numbers[numbers.length-2];
            //양수의 곱중 높은값
            answer = Math.max(p_max,m_max);
            
        
        return answer;
    }
}
