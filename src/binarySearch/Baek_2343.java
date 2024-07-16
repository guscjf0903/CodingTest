package binarySearch;

import java.util.Scanner;

public class Baek_2343 {
    //레슨의 순서가 바뀌면 안됨. 블루레이 크기가 모두 동일해야함.
    //모두 더했을때 블루레이 갯수만큼 나오지 않으면, 블루레이 용량을 줄임
    //더했을때 용량이 모자라면 블루레이 갯수를 늘림.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N];
        int start = 0;
        int end = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            if(start < arr[i]) {
                start = arr[i];
            }
            end += arr[i];
        }


        while(start <= end) {
            int mid = (start + end)/ 2;
            int sum = 0;
            int count = 0;
            for(int i = 0; i < N; i++) {
                if(sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum = sum + arr[i];
            }
            if(sum != 0) {
                count++;
            }
            if(count > M) { //목표하는 블루레이 갯수를 넘어갔다 -> 용량이 너무 작다.
                start = mid + 1;
            } else { // 목표하는 블루레이 갯수이거나 모자라다 -> 용량이 너무 크다.
                end = mid - 1;
            }

        }
        System.out.println(start);

    }
}
