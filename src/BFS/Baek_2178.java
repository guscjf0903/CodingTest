package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2178 {
    //미로찾기..
    //BFS써야함..
    //주위가 1이라면 이동.
    //만약 0이거나 이미 이동했던곳이라면 이동불가.
    //이동이 가능한곳은 모두 queue에다가 담음.
    //쭉쭉 이동하다가 올바른곳에 도착했다면 시마이.

    //솔직히 미로찾기는 워낙 자주 나오는 문제다 보니까 좀 머릿속에 넣어놓는게 맞는거같다.


    private static int[][] miro;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    private static boolean[][] visited;
    private static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        miro = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String line = stringTokenizer.nextToken();
            for(int j = 0; j < m; j++) {
                miro[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        BFS(0,0); //시작 0,0 부터
        System.out.println(miro[n - 1][m - 1]);




    }
    //queue에서 데이터를 뺌 queue에서 나온 데이터가 현재위치
    //현재위치에서 갈수있는 위치를 모두 queue에 담음
    //queue에 담으면서 이미 들린 곳이라면 체크함
    //queue에 담을때 이미 들렸거나, 갈수없는곳이라면  queue에 넣지않음
    //쭉 돌다가 도착위치에 도착한다면 여태껏 들린 갯수를 확인.

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] cursor = queue.poll(); //현재 위치.
            for(int i = 0; i < 4; i++) { //모든 위치를 들러봐야하기떄문에 4번 for문 돌림
                int newX = cursor[0] + dx[i];
                int newY = cursor[1] + dy[i];
                if(newX >= 0 && newY >= 0 && newX < miro.length && newY < miro[0].length) {
                    if(visited[newX][newY] || miro[newX][newY] == 0) {
                        continue;
                    } else {
                        miro[newX][newY] = miro[cursor[0]][cursor[1]] + 1; //최소경로의 깊이를 계속 더해감.
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

    }

}



















