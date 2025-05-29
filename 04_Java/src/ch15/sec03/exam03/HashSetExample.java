package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        // iterator 패턴으로 순회하며 각 요소를 출력.
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
            if(element.equals("JSP")) {
                // 가져온 JSP객체를 제거.
                iterator.remove();
            }
        }
        System.out.println();

        // 향상된 for문으로 순회하며 각 요소를 출력하세요.
        for(String str : set) {
            System.out.println(str);
        }
    }
}
