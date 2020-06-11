package kr.gsm.model;

public class MyUtil {
    public int sum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    public int sum(int s, int e) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += i;
        }
        return sum;
    }

    public int count(int s, int e) {
        int count = 0;
        for (int i = s; i <= e; i++) {
            if (i % 3 + i % 5 == 0) count++;
        }
        return count;
    }
}
