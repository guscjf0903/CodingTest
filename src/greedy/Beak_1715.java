package greedy;

import java.awt.desktop.PreferencesEvent;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Beak_1715 {
    //현재 있는 해 중에서
    //가장 작은 수끼리 먼저 합산을 하면서 총 비교수를 구해야 최소의 비교수가 도출.
    //그리디를 해야한다.
    //문제를 그지같이 논점이 흐려지게 풀었다.
    //가장 작은 수를 2개씩 항상 뽑아가면서 풀어야한다.
    //그냥 arr로 정렬해서 풀면안된다. 해가 많아지면 내 논리가 그냥 개등신 논리이다 ㅇㅇ


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.add(scanner.nextInt());
        }

        int result = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            pq.add(a + b);
            result += a + b;
        }

        System.out.println(result);
    }
}
