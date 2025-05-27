package week01;

import java.util.HashMap;

public class ex07_2 {
    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "1195524421"};

        HashMap<String, Integer> map = new HashMap<>();

        for(String s : phone_book){
            map.put(s,0);
        }

        for(String s : map.keySet()){
            for(int i=0; i<s.length(); i++){
                if(map.containsKey(s.substring(0,i))) System.out.println("false");
            }
        }


    }
}
