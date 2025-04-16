package ch06.sec06.exam01;

public class Car {

    // 필드 값 초기화 하지 않을 경우, 기본값이 할당된다.
    String model; // null로 자동 초기화
    boolean start;  // false로 자동 초기화
    int speed; // 0으로 자동 초기화

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.model);
        System.out.println(car.start);
        System.out.println(car.speed);
    }

}
