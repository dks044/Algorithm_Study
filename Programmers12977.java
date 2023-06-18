class Solution {
    public static boolean factor(int n){
        if(n ==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i ==0) return false;
        }
        
        return true;
    }
    
    public int solution(int[] nums) {
        int answer = 0;

        for(int a=0;a<nums.length-2;a++){
            for(int b=a+1;b<nums.length-1;b++){
                for(int c=b+1;c<nums.length;c++){
                    int temp = nums[a]+nums[b]+nums[c];
                    if(factor(temp)) answer++;
                }
            }
        }

        return answer;
    }
}
