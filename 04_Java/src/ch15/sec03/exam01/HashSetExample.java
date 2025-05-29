package ch15.sec03.exam01;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // 객체 저장
        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java"); // 중복을 허용하지 않으므로, 덮어쓰기 됨.
        set.add("iBATIS");

        // 저장된 객체 수 출력
        // 5번의 add를 실행했지만, 하나가 중복되었으므로 객체 수는 4개이다.
        int size = set.size();
        System.out.println("총 객체 수: " +size);

    }
}
