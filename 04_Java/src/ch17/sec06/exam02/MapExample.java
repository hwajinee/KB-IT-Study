package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MapExample {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        IntStream intStream = Arrays.stream(intArray);
        intStream
                .asDoubleStream() // int -> double 변환
                .forEach(d -> System.out.println(d));

        System.out.println();

        intStream = Arrays.stream(intArray);
        intStream
                .boxed() // int -> Integer : Wrapper 객체로 변환
                .forEach(obj -> System.out.println(obj.intValue()));
                // obj는 Wrapper(Integer) 객체이므로, 다시 int 값을 꺼내려면 .intValue()를 사용해야 함.
    }
}
