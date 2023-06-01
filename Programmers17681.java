import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        char[][] graph = new char[n][n];
        StringBuilder sb = new StringBuilder();
        String binary = "";
        for(int i=0;i<arr1.length;i++){
            binary = Integer.toBinaryString(arr1[i]);
            if(binary.length()<n){
                int temp = n-binary.length();
                for(int b=1;b<=temp;b++) sb.append("0");
                sb.append(binary+" ");
            }else sb.append(binary+" ");
        }
        String[] arr1_ = sb.toString().split(" ");
        sb.setLength(0);
        for(int i=0;i<arr2.length;i++){
            binary = Integer.toBinaryString(arr2[i]);
            if(binary.length()<n){
                int temp = n-binary.length();
                for(int b=1;b<=temp;b++) sb.append("0");
                sb.append(binary+" ");
            }else sb.append(binary+" ");
        }
        String[] arr2_ = sb.toString().split(" ");
        
        sb.setLength(0);
        // for(String a : arr1_) System.out.println("1) 제 길이는 =>"+a.length());
        // System.out.println("배열1사이즈"+arr1_.length);
        // System.out.println("================================");
        // System.out.println("배열2사이즈"+arr2_.length);
        // for(String a : arr2_) System.out.println("2) 제 길이는 =>"+a.length());
        
        
        for(int i=0;i<n;i++){
            String a = arr1_[i];
            String b = arr2_[i];
            for(int j=0;j<n;j++){
                if(a.charAt(j) == '1'|| b.charAt(j) == '1') sb.append("#");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        
        
        
        
        return sb.toString().split("\n");
    }
}
