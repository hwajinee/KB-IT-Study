package ch02.sec03;

public class CharExample {
    public static void main(String[] args) {
        // char에 숫자를 대입하면 숫자에 해당하는 문자로 자동 변환됨.

        char c1 = 'A'; // 믄지 저장
        char c2 = 65; // 유니코드 직접 저장

        char c3 = '가'; // 문자 저장
        char c4 = 44032; // 유니코드 직접 저장

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
}
