package ch06.sec08.exam02;

public class Computer {
    
    // 가변길이 매개변수를 갖는 메서드 선언
    int sum(int ...values){
        int sum = 0;

        // 매개변수의 길이가 매번 다르기 때문에 length로 처리
        for(int i=0; i < values.length; i++){
            sum += values[i];
        }

        return sum;
    }
}   