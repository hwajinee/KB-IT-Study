package ch11.sec03.exam01;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};
        for(int i=0; i<=array.length; i++){ // 배열의 인덱스를 초과하여, ArrayIndexOutOfBoundsException 발생
            try{
                // array[i]가 정수가 아닐 경우, NumberFormatException 발생
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch (NumberFormatException e){
                System.out.println("숫자로 변환 불가: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("배열 인덱스 초과: " + e.getMessage());
            }
        }
    }
}
