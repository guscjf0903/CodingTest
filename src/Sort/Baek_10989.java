package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_10989 {
    //이번엔 기수정렬을 사용해보자.
    //오름차순으로 정렬하고. 1의자리 10의자리 100의자리 이렇게 정렬을 쭉쭉 한다.
    //큐를 10개만들어서 자릿수에 맞춰 넣어야한다.

    //그냥 최대횟수인 5번을 돌린다? 1 ~ 10,000
    //자릿수는 하나씩 올려가면서 돌리면 되지않을까..
    private static int[] arr;
    private static Queue<Integer>[] queue = new Queue[10];

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for(int i = 0; i < 10; i++) {
            queue[i] = new LinkedList<Integer>();
        }

        int jaritsu = 1;
        for(int i = 0; i < 5; i++) {
            redixSort(jaritsu);
            jaritsu *= 10;
        }

        for(int i : arr) {
            System.out.println(i);
        }
    }

    private static void redixSort(int jaritsu) {
        for(int i : arr) {
            int queueNum = (i / jaritsu) % 10;
            queue[queueNum].add(i);
        }

        int check = 0;
        for(int i = 0; i < 10; i++) {
            for(int q : queue[i]) {
                arr[check] = q;
                check++;
            }
            queue[i].clear();
        }
    }

}
