import java.util.*;
class Solution {
    public int solution(int[] elements) {
        
    	HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ssibal_arr =new ArrayList<>();
        //1 2 3 4 5 1 2 3 4 5 시작과 끝이 같은 원형수열 완성
        for(int a=1;a<=2;a++){
            for(int i : elements) ssibal_arr.add(i);
        }
        
        int point =0;
    	while(point < elements.length) {
        	for(int i=0;i<ssibal_arr.size()-point;i++) {
        		ArrayList<Integer> int_arr = new ArrayList<>();
                //System.out.print(point+"번쨰");
        		for(int j=i;j<=i+point;j++) {
        			int_arr.add(ssibal_arr.get(j));
                    //System.out.print(" "+elements[j]+" ");
        		}
                //System.out.println(" ");
        		int sum =0;
        		for(int num : int_arr) sum+=num;
        		set.add(sum);
        	}
        	point++;
    	}
        
        
        
        
        return set.size();
    }
}
