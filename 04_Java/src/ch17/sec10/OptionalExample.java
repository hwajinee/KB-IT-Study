package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

//        // list에 요소가 없기 때문에, NoSuchElementException 발생
//        double avg = list.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .getAsDouble();

        // 방법1: OptionalDouble 클래스 내 isPresent()로 값 존재 여부 확인
        OptionalDouble optional = list.stream()
                .mapToInt(Integer::intValue)
                .average();
        if(optional.isPresent()){
            System.out.println("방법1 평균: " + optional.getAsDouble());
        } else {
            System.out.println("방법1 평균: 0.0");
        }

        // 방법2: orElse()를 사용하여 값이 없을 경우 기본값을 지정하도록 처리
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("방법2 평균: " + avg);

        // 방법3: isPresent(람다식)을 사용하여, 값이 있을 때만 처리
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("방법3 평균: " + a));
        // 한 번에 출력문까지 처리 가능하나, 기본값 설정이 불가능.

    }
}
