package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_1920 {
    private static int[] num;

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int N = scanner.nextInt();
        num = new int[N];

        for(int i = 0; i < N; i++) {
            num[i] = scanner.nextInt();
        }
        Arrays.sort(num);

        int M = scanner.nextInt();
        int[] find = new int[M];

        for(int i = 0; i < M; i++) {
            find[i] = scanner.nextInt();
            boolean result = binarySearch(find[i]);
            if(result) {
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        }

    }

    private static boolean binarySearch(int findNum) {
        int startIdx = 0;
        int endIdx = num.length - 1;

        while(startIdx <= endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            if(num[midIdx] < findNum) {
                startIdx = midIdx + 1;
            } else if(num[midIdx] > findNum) {
                endIdx = midIdx - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
