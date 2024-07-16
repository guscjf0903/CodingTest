package BFS;

import java.awt.SystemTray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak_1260 {
    private static ArrayList<Integer>[] arrayLists;
    private static boolean[] nodeCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());


        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int start = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new ArrayList[N + 1];
        nodeCheck = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }
        for(int i = 1; i <= N; i++) { //작은거부터 나오게 하기 위해 정렬.
            Collections.sort(arrayLists[i]);
        }


        DFS(start);
        Arrays.fill(nodeCheck, false);
        System.out.println();
        BFS(start);

    }

    private static void DFS(int start) {
        nodeCheck[start] = true;
        System.out.print(start + " ");

        for (int i : arrayLists[start]) {
            if (!nodeCheck[i]) {
                DFS(i);
            }
        }
    }



    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        nodeCheck[start] = true;

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            System.out.print(nowNode + " ");


            for(int i : arrayLists[nowNode]) {
                if(!nodeCheck[i]) {
                    queue.add(i);
                    nodeCheck[i] = true;
                }
            }
        }



    }

}
