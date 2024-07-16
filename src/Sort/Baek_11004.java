package Sort;

import java.util.Scanner;

public class Baek_11004 {
    //퀵정렬로 풀어보자

    //배열의 중간을 피벗으로 선정
    //해당 피벗을 맨 오른쪽으로 옮김
    //start, end를 커서를 잡고 피벗기준으로 찾음
    //피벗 기준으로 계속 스왑.
    //스타드 엔드 커서가 만날때 피벗의 위치를 옮김
    //피벗을 기준으로 나뉜 두 집합을 다시 피벗을 잡고 계산
    //결국 남은 집합이 1개이하일떄 끗

    private static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        quickSort(0, N - 1, M - 1);
        System.out.println(arr[M - 1]);
    }
    // 5, 6, 7, 1, 3, 4
    private static void quickSort(int S, int E, int K) {
        if(S < E) {
            int pivot = partition(S, E);
            if(pivot == K) {
                return;
            } else if (pivot > K) {
                quickSort(S, pivot - 1, K);
            } else {
                quickSort(pivot + 1, E, K);
            }
        }
    }

    private static int partition(int S, int E) {
        if(S + 1 == E) {
            if(arr[S] > arr[E]) swap(S,E);
            return E;
        }

        int M = (S + E) / 2;
        swap(S, M);
        int pivot = arr[S];

        int i = S + 1; int j = E;
        while(i <= j) {
            while(j >= S + 1 && pivot < arr[j]) {
                j--;
            }
            while(i <= E && pivot > arr[i]) {
                i++;
            }
            if(i <= j) {
                swap(i++, j--);
            }
        }
        arr[S] = arr[j];
        arr[j] = pivot;

        return j;

    }

    private static void swap(int S, int E) {
        int tmp = arr[S];
        arr[S] = arr[E];
        arr[E] = tmp;
    }
}
