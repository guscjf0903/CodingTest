package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek_1707 {
    //DFS로 풀어야할듯..
    //사이클이 생겼을떄 해당 노드가 같은 집합이라면 이분그래프 조건 안됨.
    private static ArrayList<Integer>[] arrayList;
    private static boolean[] visited;
    private static int[] color;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int a = 0; a < testCase; a++) {
            int N = scanner.nextInt();
            int E = scanner.nextInt();
            arrayList = new ArrayList[N + 1];
            for(int i = 0; i <= N; i++) {
                arrayList[i] = new ArrayList<>();
            }
            for(int i = 0; i < E; i++) {
                int q = scanner.nextInt();
                int w = scanner.nextInt();
                arrayList[q].add(w);
            }
            for(int i = 1; i <= N; i++) {
                color[i] = 0;
                boolean check = DFS(i, 0);
            }
        }
    }

    private static boolean DFS(int node, int testColor) {
        if(visited[node]) {
            if (color[node] == testColor)  {
                return false;
            } else {
                return true;
            }
        }

        for(int i: arrayList[node]) {
            testColor = (testColor + 1) % 2;
            DFS(i, testColor);
        }
    }
}
