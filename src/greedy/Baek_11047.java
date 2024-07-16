package greedy;

import java.util.Scanner;

public class Baek_11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] money = new int[N];
        for(int i = 0; i < N; i++) {
            money[i] = scanner.nextInt();
        }

        int result = 0;

        for(int i = N - 1; i >=0; i--) {
            if(money[i] <= sum) {
                result += (sum / money[i]);
                sum = sum % money[i];
            }
        }

        System.out.println(result);
    }
}
