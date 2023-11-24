import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int transaction = 0;
        Queue<Integer> q1 = createByIntArr(queue1);
        Queue<Integer> q2 = createByIntArr(queue2);
        long total = sum(q1) + sum(q2);
        if(total %2 != 0) return -1;
        long divideTotal = (total/2);
        long sumQ1 = sum(q1);
        long sumQ2 = sum(q2);
        int pollTemp = 0;
        int totalLength = queue1.length + queue2.length;
        while(sumQ1 != divideTotal || sumQ2 != divideTotal){
            //다 뒤져봐도 안나올경우
            if(transaction > totalLength*2) return -1; 
            if(sumQ1 > sumQ2){
                pollTemp = q1.poll();
                sumQ1 -= pollTemp;
                sumQ2 += pollTemp;
                q2.add(pollTemp);
            }else{
                pollTemp = q2.poll();
                sumQ2 -= pollTemp;
                sumQ1 += pollTemp;
                q1.add(pollTemp);
            }
            transaction++;
        }
        return transaction;
    }
    static long sum (Queue<Integer> q){
        long sum = 0;
        for(int i : q) sum += i;
        return sum;
    }
    static Queue<Integer> createByIntArr(int[] arr){
        Queue<Integer> q = new LinkedList<>();
        for(int i : arr) q.add(i);
        return q;
    }
}
