package ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("최화진", 80));
        studentList.add(new Student("박지원", 90));
        studentList.add(new Student("박찬란", 85));

        // 오름차순 정렬 (compareTo 기준)
        System.out.println("오름차순 정렬");
        studentList.stream()
                .sorted()
                .forEach(s -> System.out.println(s.getName()+ ": "+s.getScore()));
        System.out.println();

        // 내림차순 정렬 (reverseOrder)
        System.out.println("내림차순 정렬");
        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getName()+ ": "+s.getScore()));
    }
}
