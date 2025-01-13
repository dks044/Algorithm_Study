import java.util.*;
class Solution {
    public String solution(String polynomial) {
       String answer = "";
        String[] temp = polynomial.split(" ");
        int x_count =0;
        ArrayList<String> x_num_arr = new ArrayList<>(); //3x 4x 숫자세기용
        ArrayList<String> num_arr = new ArrayList<>();
        for(int i=0;i<temp.length;i++){
            if(temp[i].equals("1x")){
                x_count +=1;
            }
            if(temp[i].matches("[0-9]+")){
                num_arr.add(temp[i]);
            }
            //x가 포함되있고, 길이가 2이상일떄
            if(temp[i].contains("x")&& temp[i].length()>=2){
                String a = temp[i].replaceAll("x","");
                x_num_arr.add(a);
            }else if(temp[i].equals("x")){
                x_count +=1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int x_sum = 0; //x 총개수
        for(int i=0;i<x_num_arr.size();i++){
            x_sum += Integer.valueOf(x_num_arr.get(i));
        }
        x_sum+= x_count;
        
        int num_sum =0;
        if(num_arr.size()>=1){
            for(String a : num_arr){
                num_sum +=Integer.valueOf(a);
            }   
        }
        
        if(x_sum>=2){
            sb.append(x_sum);
        }
        if(x_sum>=1){
            sb.append("x");
        }
        if(x_sum>=1 && num_sum>=1){
            sb.append(" + ");
            sb.append(num_sum);   
        }
        if(x_sum ==0 && num_sum>=1){
            sb.append(num_sum);
        }
        
        answer = sb.toString();
        System.out.println(answer);
        
        
        
        return answer;
    }
}
