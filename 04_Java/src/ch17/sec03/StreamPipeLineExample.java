package ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("최화진", 10),
                new Student("박지원", 20),
                new Student("박찬란", 30)
        );

        // 방법1 : Stream 변수 분리
        Stream<Student> stream = list.stream();
        IntStream scoreStream = stream.mapToInt(student -> student.getScore());
        double avg = scoreStream.average().getAsDouble();
        System.out.println("평균 점수: " + avg);

        // 방법2 : 파이프라인 메서드 체이닝
        double avg2 = list.stream()
                .mapToInt(student -> student.getScore())
                .average()
                .getAsDouble();
        System.out.println("평균 점수: " + avg2);

    }
}
