package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.text.html.StyleSheet;

public class Baek_2251 {
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {1,2,0,2,0,1};
    static boolean[][][] check;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] water = new int[3];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        water[0] = scanner.nextInt();
        water[1] = scanner.nextInt();
        water[2] = scanner.nextInt();
        check = new boolean[201][201][201];

        BFS();
        Collections.sort(result);
        for(int i : result) {
            System.out.println(i);
        }


    }

    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        int[] first = {0,0,water[2]};
        check[0][0][water[2]] = true;
        result.add(first[2]);
        queue.add(first);

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int[] next;


            for(int i = 0; i < 6; i++) {
                next = now.clone();
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                if(next[receiver[i]] > water[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - water[receiver[i]];
                    next[receiver[i]] = water[receiver[i]];
                }
                if(!check[next[0]][next[1]][next[2]]) {
                    queue.add(next);
                    check[next[0]][next[1]][next[2]] = true;
                    if(next[0] == 0) {
                        result.add(next[2]);
                    }
                }
            }

        }
    }
}
