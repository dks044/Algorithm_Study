import java.util.*;
class Solution {
    public static int numCount(int num) {
		Map<Integer, Integer> map = new HashMap<>();
		int total = 1;
		for(int i=2;i<=Math.sqrt(num);i++) {
			while(num % i ==0) {
				if(!map.containsKey(i)) {
					map.put(i, 1);
					num /=i;
				}else {
					map.put(i, map.get(i)+1);
					num /=i;
				}
			}
		}
        //또한, 소인수분해 후에도 num이 1보다 큰 경우 (즉, 남은 num이 소수인 경우)를 고려
		if (num > 1) {
	        map.put(num, 1);
	    }
		for(int i : map.values()) {
			total *= i+1;
		}
		
		
		return total;
	}
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int temp =0;
        ArrayList<Integer> sum_arr = new ArrayList<Integer>();
        for(int i=1;i<=number;i++){
            temp = numCount(i);
            
            if(temp>limit) sum_arr.add(power);
            else sum_arr.add(temp);
        }
        
        for(int i : sum_arr) answer+=i;
        
        return answer;
    }
}
