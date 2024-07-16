package greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baek_1744 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>(); // 제일 작은수 부터 나옴
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder()); //큰수부터 나옴
        int sum = 0;

        for(int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            if(a <= 0) {
                minusQueue.add(a);
            }else {
                plusQueue.add(a);
            }
        }

        while(plusQueue.size() > 1) {
            int a = plusQueue.poll();
            int b = plusQueue.poll();

            if(a == 1 || b == 1) {
                sum += a + b;
                continue;
            }

            sum += a * b;
        }
        if(!plusQueue.isEmpty()) {
            sum += plusQueue.poll();
        }

        while(minusQueue.size() > 1) { //제일 작은놈 부터 꺼냄.
            int a = minusQueue.poll();
            int b = minusQueue.poll();

            sum += a * b;
        }
        if(!minusQueue.isEmpty()) {
            sum += minusQueue.poll();
        }

        System.out.println(sum);

    }
}
