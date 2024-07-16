package numbertheory;

import java.util.Scanner;

public class Baek_1929 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[M + 1];
        for(int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }



        for(int i = 2; i <= Math.sqrt(M); i++) {
            if(arr[i] == 0) {
                continue;
            }
            for(int j = i + i; j <= M; j += i) {
                arr[j] = 0;
            }
        }

        for(int i = N; i <= M; i++) {
            if(arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }


}
