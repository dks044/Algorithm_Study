import java.util.*;
class Solution {
    static String step2 (String new_id){
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        return new_id;
    }
    static String step3 (String new_id){
        new_id = new_id.replaceAll("\\.{2,}", ".");
        return new_id;
    }
    static String step4 (String new_id){
        char[] new_id_word = new_id.toCharArray();
        new_id = "";
        if(new_id_word[0]=='.') new_id_word[0] = 'ㅗ';
        if(new_id_word[new_id_word.length-1]=='.') new_id_word[new_id_word.length-1] = 'ㅗ';
        for(char word : new_id_word) if(word != 'ㅗ') new_id += word;
        return new_id;
    }
    static String step6 (String new_id){
        char[] new_id_word = new_id.toCharArray();
        new_id = "";
        int index = 1;
        for(char word : new_id_word){
            if(index == 15 && word == '.') break;
            if((index++) < 16) {
                new_id += word;
            }
        }
        return new_id;
    }
    static String step7 (String new_id){
        char[] new_id_word = new_id.toCharArray();
        char lastword = new_id.charAt(new_id.length()-1);
        while(new_id.length()<3){
            new_id += lastword;
        }
        return new_id;
    }
    
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        new_id = new_id.toLowerCase();
        new_id = step2(new_id);
        new_id = step3(new_id);
        new_id = step4(new_id);
        if(new_id.length()==0) new_id += "a";
        if(new_id.length()>=16){
            new_id = step6(new_id);
        }
        if(new_id.length()<=2){
            new_id = step7(new_id);
        }
        return new_id;
    }
}
