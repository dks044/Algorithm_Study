import java.util.*;
class Solution {
    //1번사람
    public static int countOne(int[] arr){
        int count = 0;
        int[] ans ={1,2,3,4,5};
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(index==ans.length) index=0;
            if(arr[i]==ans[index] && index<ans.length) count++;
            index++;
        }
        return count;
    }
    //2번사람
    public static int countTwo(int[] arr){
        int count = 0;
        int[] ans ={2,1,2,3,2,4,2,5};
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(index==ans.length) index=0;
            if(arr[i]==ans[index] && index<ans.length) count++;
            index++;
        }
        return count;
    }
    //3번사람
    public static int countThree(int[] arr){
        int count = 0;
        int[] ans ={3,3,1,1,2,2,4,4,5,5};
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(index==ans.length) index=0;
            if(arr[i]==ans[index] && index<ans.length) count++;
            index++;
        }
        return count;
    }
    
    public int[] solution(int[] answers) {

        //1) 1 2 3 4 5
        //2) 2 1 2 3 2 4 2 5
        //3) 3 3 1 1 2 | 2 4 4 5 5 
        // 수포자번호 / 맞친횟수
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,countOne(answers));
        map.put(2,countTwo(answers));
        map.put(3,countThree(answers));
        
        int max = countOne(answers);
        ArrayList<Integer> max_arr = new ArrayList<>();
        for(int i : map.values()) if(max <i) max=i;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           if(max == entry.getValue()) max_arr.add(entry.getKey());
        }
        
        int[] answer = new int[max_arr.size()];
        if(max_arr.size()>1){
            for(int i=0;i<max_arr.size();i++){
                answer[i] = max_arr.get(i);
            }
            Arrays.sort(answer);
        }else{
            answer[0] = max_arr.get(0);
        }
        
        
        
        
        return answer;
    }
}
​
