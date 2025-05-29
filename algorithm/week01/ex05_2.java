package week01;

import java.util.HashMap;

//미완 !!!!
public class ex05_2 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa",  "filipa", "marina", "nikola"};

        HashMap<String, Integer> map = new HashMap<>();

        for(String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(String s : completion) {
            map.replace(s, map.replace(s, map.get(s) - 1));
        }

        for(String s : map.keySet()){
            if( map.get(s) >= 1 ){
                System.out.println(s);
            }
        }


    }
}
