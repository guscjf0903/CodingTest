package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek_11724 {
    //연결 요소를 구해야 한다?
    //DFS탐색을하다가 끝나는 지점이 몇개있는지 찾아야함.
    private static ArrayList<Integer>[] nodeList;
    private static boolean[] nodeCheck;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        nodeList = new ArrayList[N + 1];
        nodeCheck = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            nodeList[a].add(b);
            nodeList[b].add(a);
        }
        int result = 0;
        for(int i = 1; i <= N; i++) {
            if(!nodeCheck[i]) {
                DFS(i);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void DFS(int startNode) {
        if(nodeCheck[startNode]) {
            return;
        }
        nodeCheck[startNode] = true;
        for(int i : nodeList[startNode]) {
            if(!nodeCheck[i]) {
                DFS(i);
            }
        }
    }
}
