package week01;

import java.util.HashMap;

public class ex05 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa",  "filipa", "marina", "nikola"};

        HashMap<String, Integer> map = new HashMap<>();

        for(String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for(String s : participant) {
            if(!map.containsKey(s)) {
                result.append(s);
            } else {
                if( map.get(s) > 1) {
                    map.replace(s, map.get(s) - 1);
                } else if (map.get(s) == 0) {
                    result.append(s);
                }
            }
        }
        System.out.println(result);



    }
}
