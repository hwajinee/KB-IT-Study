package ch17.sec04.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // List 컬렉션 생성
        List<Product> list = new ArrayList<>();
        for(int i=1; i<=5; i++){
            // 상품 객체 생성 및 추가
            Product product = new Product(i, "상품"+i, "멋진회사", (int)(1000*Math.random())); // 0 ~ 9999 사이 랜덤 값.
            list.add(product);
        }

        // 객체 스트림 얻기
        Stream<Product> stream = list.stream();
        stream.forEach(p -> System.out.println(p));
    }
}
