package week01;

import java.util.Arrays;

public class ex07 {
    public static void main(String[] args) {

         String[] phone_book = {"119", "97674223", "1195524421"};

         // 전화번호 정렬
         Arrays.sort(phone_book);

         boolean result = true;

         for(int i=0; i<phone_book.length; i++){
             for(int j=i+1; j< phone_book.length; j++){
                 if(phone_book[j].startsWith(phone_book[i])) result = false;
             }
         }
         System.out.println(result);
    }
}
