package ch17.sec05;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        // List 컬렉션 생성
        List<String> list = new ArrayList<>();
        list.add("최화진");
        list.add("황병웅");
        list.add("박지원");
        list.add("서동우");
        list.add("박지원");
        
        // 중복 요소 제거
        list.stream()
                .distinct()
                .forEach(n-> System.out.println(n));
        System.out.println();
        
        // '서'로 시작하는 요소만 필터링
        list.stream()
                .filter(n -> n.startsWith("박"))
                .forEach(n -> System.out.println(n));
        System.out.println();

        // 중복 요소를 먼저 제거하고, '서'로 시작하는 요소만 필터링
        list.stream()
                .distinct()
                .filter(n -> n.startsWith("박"))
                .forEach(n -> System.out.println(n));
        System.out.println();
    }
}
