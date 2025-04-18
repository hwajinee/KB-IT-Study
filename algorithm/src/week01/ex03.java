package week01;

import java.util.Arrays;

public class ex03 {
    public static void main(String[] args) {

        int[] d = {1,3,2,5,4};
        int budget = 9;

        int result = 0;
        Arrays.sort(d);

        // budget을 초과하지 않는 선에서, 적은 금액 순으로 더하기
        for(int amount : d) {
            budget -= amount;
            if(budget < 0) break;
            result ++;
        }

        System.out.println(result);

    }
}
