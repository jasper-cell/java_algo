package niuke;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0, temp; i< numbers.length; i++){
            temp = numbers[i];
            if(map.containsKey(target -temp)){
                return new int[]{map.get(target-temp)+1, i+1};
            }
            map.put(temp, i);
        }
        throw new RuntimeException("dont exists");
    }
}
