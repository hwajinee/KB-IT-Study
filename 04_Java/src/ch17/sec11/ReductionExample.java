package ch17.sec11;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
          new Student("최화진", 80),
          new Student("박지원", 90),
          new Student("황병웅", 86)
        );

        // 방법1
        int sum1 = studentList.stream()
                .mapToInt(Student::getScore)
                .sum();

        // 방법2 : reduce()
        int sum2 = studentList.stream()
                .map(Student::getScore)
                .reduce(0, (a, b) -> a+b);

        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
    }
}
