package niuke;

public class SkipStage {
    public int jumpFloorRecur(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        return jumpFloor(target-1) + jumpFloor(target-2);
    }

    public int jumpFloor(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;

        int cur = 0;
        int slow = 1;
        int fast = 2;
        for(int i = 2; i < target; i++){
            cur = slow + fast;
            slow = fast;
            fast = cur;
        }
        return fast;
    }
}