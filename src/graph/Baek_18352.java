package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baek_18352 {
    //단방향 도로, 가중치 없음
    //노드,엣지,거리, 출발도시 정보로 되어있음.
    private static ArrayList<Integer>[] arr;
    private static boolean[] check;
    private static int L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int E = scanner.nextInt();
        L = scanner.nextInt();
        int start = scanner.nextInt();
        arr = new ArrayList[N + 1];
        check = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[a].add(b);
        }
        BFS(start);

    }
    private static void BFS(int start) {
        Queue<Node> queue = new LinkedList<Node>();
        Node startNode = new Node(start, 0);
        queue.add(startNode);
        check[start] = true;
        List<Integer> result = new ArrayList<Integer>();

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            for(int i : arr[now.node]) {
                if(!check[i]) {
                    Node newNode = new Node(i, now.depth + 1);
                    queue.add(newNode);
                    check[i] = true;
                    if(newNode.depth == L) {
                        result.add(i);
                    }
                }
            }
        }

        if(result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for(int i : result) {
                System.out.println(i);
            }
        }
    }

    private static class Node {
        int node;
        int depth;
        public Node(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

}
