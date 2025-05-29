package ch11.sec03.exam02;

import java.lang.reflect.Array;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for(int i=0; i<=array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]); // NumberFormatExcepton
                System.out.println("array[" + i + "]: " + value); // ArrayIndexOutBoundsException
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스 초과: " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Exception 발생 (+NumberFormatExcepton는 여기서 잡힘)");
            }
        }
    }
}
