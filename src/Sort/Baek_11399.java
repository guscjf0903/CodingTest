package Sort;

import java.util.Scanner;

public class Baek_11399 {
    //오름차순 정렬
    //이번엔 삽입정렬로 풀어보자

    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i = 1; i < N; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        int resultTmp = 0;
        int result = 0;
        for(int i = 0; i < N; i++) {
            resultTmp += arr[i];
            result += resultTmp;
        }

        System.out.println(result);

    }
}
