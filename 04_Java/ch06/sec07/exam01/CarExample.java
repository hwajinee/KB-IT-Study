package ch06.sec07.exam01;

import org.w3c.dom.ls.LSOutput;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car("그랜저","검정", 250);
//        Car car = new Car(); // 기본 생성자 호출 불가

        System.out.println(myCar.model);
        System.out.println(myCar.color);
        System.out.println(myCar.maxSpeed);
    }
}