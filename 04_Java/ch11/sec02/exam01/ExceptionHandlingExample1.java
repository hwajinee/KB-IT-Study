package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data){
        try{
            // 여기서 NullPointerException 발생
            // data가 null일 경우, length()를 호출할 수 없다.
            int result = data.length();
            System.out.println("문자 수: " + result);
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("[마무리 실행(finally문)]\n");
        }
    }
    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}
