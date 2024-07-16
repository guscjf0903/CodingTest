package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_2751 {
    //병합 정렬로 풀어보자 -> 분할과 정복
    //분할하고 병합해보자 재귀함수로.
    private static int[] tmp;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(bufferedReader.readLine());
        arr = new int[a + 1];
        tmp = new int[a + 1];

        for(int i = 1; i <= a; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        merge_sort(1,a);
        for(int i = 1; i <= a; i++) {
            bufferedWriter.write(arr[i] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();


    }

    private static void merge_sort(int s, int e) {
        if(e - s < 1) { // 분할의 끝
            return;
        }
        int m = s + (e - s) / 2;
        merge_sort(s, m);
        merge_sort(m + 1, e); // 재귀적으로 분할.

        for(int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while(index1 <= m && index2 <= e) { //병합 로직
            if(tmp[index1] > tmp[index2]) {
                arr[k] = tmp[index2];
                k++;
                index2++;
            } else {
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= m) {
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e) {
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
