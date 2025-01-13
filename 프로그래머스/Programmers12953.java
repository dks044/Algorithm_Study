class Solution {
    public static long gcd (int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public static long lcm (long a, long b){
        long aa = Long.valueOf(a);
        long bb = Long.valueOf(b);
        
        return (aa * bb) / gcd((int)aa, (int)bb);
    }
    
    public int solution(int[] arr) {
        long answer = arr[0];
        for(int i=1;i<arr.length;i++){
            answer = lcm(answer,arr[i]);
        }
        return (int)answer;
      
    }
}
