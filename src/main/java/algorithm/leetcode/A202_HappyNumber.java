package algorithm.leetcode;

public class A202_HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int fast = n;
        int slow = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            if (fast == 1 || slow == 1) {
                return true;
            }
        } while (fast != slow);
        return false;
    }

    private int squareSum(int n){
        int sum = 0;
        while (n!=0){
            int t = (n%10);
            sum+= t*t;
            n = n/10;
        }
        return sum;
    }

}
