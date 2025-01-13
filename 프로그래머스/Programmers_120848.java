import java.util.*;
class Solution {
    //팩토리얼 함수(중요)
    public static int fac(int n){
        if(n <=1){
            return 1;
        }
        return n * fac(n - 1);
    }
    
    public int solution(int n) {
       		Map<Integer, Integer> fac_list = new HashMap<>();
            int answer = 0;
		    int count = 1;
		        
		    //1~10까지 팩토리얼 저장.
		    for(int i=1;i<=10;i++){
		         fac_list.put(count,fac(count));
		         count +=1;
		    }
		    int temp = 0;
			for(Map.Entry<Integer, Integer> entry : fac_list.entrySet()) {
				Integer key = entry.getKey();
				Integer value = entry.getValue();
				if(n >= value) {
					answer = key;
				}
			}
        
        return answer;
    }
}
