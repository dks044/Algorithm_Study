import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>(); //번호, 마릿수
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int temp = nums.length/2;
        int temp2 = map.size();
        
        if(temp2 > temp){
            return temp;
        }else if(temp >= temp2){
            return temp2;
        }        
        
        return -1;
    }
}
