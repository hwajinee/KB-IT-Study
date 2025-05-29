package ch17.sec07.exam02;

import java.util.ArrayList;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("최화진", 80));
        studentList.add(new Student("박지원", 90));
        studentList.add(new Student("박찬란", 85));

        studentList.stream()
                // 점수를 기준으로 오름차순 정렬
                .sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
                .forEach(s -> System.out.println(s.getName()+": "+s.getScore()));

        System.out.println();

        studentList.stream()
                // 점수를 기준으로 내림차순 정렬
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .forEach(s -> System.out.println(s.getName()+": "+s.getScore()));

    }
}
