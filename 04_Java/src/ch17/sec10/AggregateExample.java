package ch17.sec10;

import java.util.Arrays;

public class AggregateExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // 카운팅
        long count = Arrays.stream(arr)
                .filter(n -> n%2 == 0) // 짝수 필터링
                .count();
        System.out.println("짝수 개수: " + count);

        // 총합
        long sum = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .sum();
        System.out.println("짝수 총합: " + sum);

        // 평균
        double avg = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .average()
                .getAsDouble();
        System.out.println("짝수 평균: " + avg);

        // 최대값
        int max = Arrays.stream(arr)
                .max()
                .getAsInt();
        System.out.println("최대값: " + max);

        // 최소값
        int min = Arrays.stream(arr)
                .min()
                .getAsInt();
        System.out.println("최소값: " + min);

        // 첫 번째 요소
        int first = Arrays.stream(arr)
                .filter(n -> n%3==0) // 3의 배수 필터링
                .findFirst()
                .getAsInt();
        System.out.println("첫 번째 3의 배수: " + first);
    }
}
