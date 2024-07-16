package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_13023 {
    //Depth가 5인지 확인하는 문제
    //그럼 DFS써야지 -> Stack 사용 -> 재귀함수 사용, 들린 노드 체크
    //ArrayList사용해서 연결된 각각의 노드 체크.
    private static ArrayList<Integer>[]  arrayList;
    private static boolean[] checkNode;
    private static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        arrayList = new ArrayList[N];
        checkNode = new boolean[N];
        for(int i = 0; i < N; i++) {
            arrayList[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            arrayList[a].add(b);
            arrayList[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            DFS(i, 1);
            if (result) break;  // 깊이가 5인 경로를 찾으면 더 이상 탐색할 필요가 없음
        }

        if(result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void DFS(int start, int depth) {
        if (result) return;  // 이미 깊이가 5인 경로를 찾았으면 더 이상 탐색하지 않음
        if (depth == 5) {
            result = true;
            return;
        }
        checkNode[start] = true;

        for (int i : arrayList[start]) {
            if (!checkNode[i]) {
                DFS(i, depth + 1);
            }
        }


        checkNode[start] = false;  // 상태 복원
    }
}
