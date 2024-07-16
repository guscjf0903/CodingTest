package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek_1352 {
    private static ArrayList<Integer>[] arrayLists;
    private static boolean[] visited;
    private static int count;


    private static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N  = Integer.parseInt(stringTokenizer.nextToken());
        int M  = Integer.parseInt(stringTokenizer.nextToken());
        arrayLists = new ArrayList[N + 1];
        result = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            arrayLists[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            count = 0;
            DFS(i);
            result[i] = count;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        count++;
        for (int adj : arrayLists[node]) {
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }
}
