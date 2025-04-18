package week01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ex01 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] output = new int[2];

//      합이 target이 되는 nums의 두 원소를 찾고, 인덱스를 반환한다.
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                output[0] = i;
                output[1] = map.get(target-nums[i]);
            } else{
                map.put(nums[i], i);
            }
        }

        Arrays.sort(output);

        System.out.println(output);
    }
}
