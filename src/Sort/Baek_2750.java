package Sort;

import java.util.Scanner;

public class Baek_2750 {
    //버블정렬로 한번 풀어보자
    //하나의 데이터를 선정해서 쭈욱 앞데이터와 비교하면서 Swap해보자

    private static int N;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        bubbleSort();

        for(int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }

    }
    private static void bubbleSort() {
        int complete = N;

        while(complete != 0) {
            int cur = 0;
            for(int i = 1; i < complete; i++) { //한 사이클이 끝나면 맨 마지막부터 차곡차곡 끝남
                cur = i;
                if(arr[cur - 1] > arr[cur]) {
                    swap(cur - 1, cur);
                }
            }
            complete = complete - 1;
        }
    }

    private static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
