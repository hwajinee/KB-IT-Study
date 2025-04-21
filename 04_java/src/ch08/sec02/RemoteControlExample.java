package ch08.sec02;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;
        rc = null;
        // 인터페이스는 참조 타입에 속하므로,
        // 구현 객체를 대입하기 전에는 null 대입 가능
        
        rc = new Television(); // 업캐스팅
        rc.turnOn(); // 자식인 Television의 turnOn() 호출

        // 구현 객체를 교체할 수 있음.
        rc = new Audio(); // 업캐스팅
        rc.turnOn(); // Audio의 turnOn() 호출
        
        
    }
}
