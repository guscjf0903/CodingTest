package BFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beak_1167 {
    //어레이리스트 배열로 만듬
    //모든 노드들을 전부 시작해보고 들리지않았고, 거리가 먼 노드로 항상 출발
    //그리고 나온 가중치 모드합산 -> 그중에 제일 큰애를 그냥 출력하면됨 ㅇㅇ

    // 중요한 개념 : 임의의 노드에서 가장 긴 경로로 연결돼 있는 노드는 트리의 지름에 해당하는 두 노드 중 하나다. 제발 인지혀라!

    private static ArrayList<Edge>[] arrrayLists;
    private static boolean[] check;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        arrrayLists = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            arrrayLists[i] = new ArrayList<>();
        }
        check = new boolean[N + 1];
        distance = new int[N + 1];

        for(int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            while(true) {
                int b = scanner.nextInt();
                if(b == -1) {
                    break;
                }
                int length = scanner.nextInt();
                arrrayLists[a].add(new Edge(b, length));
            }
        }
       BFS(1);
       int Max = 1;
       int tmp = 0;
       for(int i = 2; i < distance.length; i++) {
           if(tmp < distance[i]) {
               Max = i;
           }
       }

        check = new boolean[N + 1];
        distance = new int[N + 1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);


    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        check[startNode] = true;

        while(!queue.isEmpty()) {
            int now_node = queue.poll();

            for(Edge a : arrrayLists[now_node]) {
                if(!check[a.node]) {
                    queue.add(a.node);
                    check[a.node] = true;
                    distance[a.node] = distance[now_node] + a.length;
                }
            }
        }
    }

    private static class Edge {
        int node;
        int length;
        public Edge(int a, int b) {
            this.node = a;
            this.length = b;
        }
    }
}
