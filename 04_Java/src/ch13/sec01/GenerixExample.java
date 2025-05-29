package ch13.sec01;

public class GenerixExample {
    public static void main(String[] args) {
//        Box<String> box1 = new Box<String>();
        Box<String> box1 = new Box<>();
        box1.content = "안녕하세요";
//        int n = box1.content; // 타입 불일치 시, 컴파일 에러
        String str = box1.content;
        System.out.println(str);

//        Box<Integer> box2 = new Box<Integer>();
        Box<Integer> box2 = new Box<>();
        box2.content = 100;
        int value = box2.content;
        System.out.println(value);


    }
}
