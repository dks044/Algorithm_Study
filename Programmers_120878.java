import java.util.*;

class Solution {
    public static int gcd(int a,int b){
        if(a == 0){
            return b;
        }
        return gcd(b% a,a);
    }
    public static ArrayList<Integer> factor(int n){
        ArrayList<Integer> factors = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> factors2 = new ArrayList<Integer>();
        for(int i=2;i<=Math.sqrt(n);i++){
            while(n % i == 0){
                factors.add(i);
                n /= i;
            }
        }
        
        if(n > 1){
            factors.add(n);
        }
        for(int i : factors){
            if(set.add(i)){
                factors2.add(i);
            }
        }
        
        
        return factors2;

    }
    
    public int solution(int a, int b) {
        if(a % b ==0){
            return 1;
        }
        
        int g = gcd(a,b);
        b /= g;
        boolean two = false;
        boolean five = false;
        boolean other = false;
        
        ArrayList<Integer> temp = factor(b);
        for(int factor : temp){
           if(factor == 2){
               two = true;
           }else if(factor == 5){
                five = true;
            }else{
               other = true;
           }
        }
        
        
        
        if(!other && two && temp.size()==1){
            return 1;
        }
        if(!other && two && five){
            return 1;
        }
        if(!other && five && temp.size()==1){
            return 1;
        }
        
        return 2;
    }
}
