package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("최화진", 85);
        map.put("황병웅", 90);
        map.put("박지원", 80);
        map.put("황병웅", 95); // 동일한 키가 존재하므로, value 값이 교체됨.

        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        //키로 값 얻기
        String key = "황병웅";
        int value = map.get(key);
        System.out.println(key + ": " + value);
        System.out.println();

        // map에 존재하는 키 Set 컬렉션으로 얻고, 반복해서 키와 값 얻기.
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            String k = keyIterator.next(); // key값 순회
            Integer v = map.get(k); // key에 해당하는 value 얻기.
            System.out.println(k + ": " + v);
        }
        System.out.println();

        // map에 존재하는 모든 엔트리를 set으로 얻고, 반복해서 키와 값을 얻기
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()){
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + ": " + v);
        }
        System.out.println();
        
        // key로 entry 삭제
        map.remove("황병웅");

        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
    }
}
