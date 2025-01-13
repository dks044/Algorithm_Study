import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {

    	int[] answer = new int[numlist.length];
    	ArrayList<Double> order = new ArrayList<>();
    	
    	for(int i=0;i<numlist.length;i++) {
    		if(numlist[i]-n <0) {
    			double temp = Math.abs(numlist[i]-n)+0.5;
    			order.add(temp);
    		}else {
    			double temp = numlist[i]-n;
    			order.add(temp);
    		}
    		
    	}
    	Collections.sort(order);
    	for(int i=0;i<order.size();i++) {
    		if(order.get(i) % (double)1 !=0) {
    			int temp= order.get(i).intValue();
    			answer[i]=n-temp;
    		}else {
    			int temp = order.get(i).intValue();
    			answer[i] = n+temp;
    		}
    		
    	}
        return answer;
    }
}
