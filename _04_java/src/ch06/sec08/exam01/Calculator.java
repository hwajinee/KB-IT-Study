package ch06.sec08.exam01;

public class Calculator {

    public void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    public void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    public int plus(int x, int y) {
        return x + y;
    }

    public double divide(int x, int y) {
        return (double)x / (double)y;
        // return x / y (X) int 값으로 처리하지 않게 double로 형변환 해줘야 함 !
    }

}
