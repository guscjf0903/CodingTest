package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Baek_1427 {
    //선택정렬로 풀어볼 생각임
    //배열이 최대 해봤자 10개 정도일듯
    //근데 어떻게 해당 숫자를 배열에 넣지..

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String N = bufferedReader.readLine();
        int len = N.length();
        arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = N.charAt(i) - '0';
        }

        for (int i = 0; i < len; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            // 스왑
            int tmp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = tmp;
        }

        for(int i : arr) {
            System.out.print(i);
        }
    }

}
