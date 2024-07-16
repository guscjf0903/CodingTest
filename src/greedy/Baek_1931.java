package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Baek_1931 {
    //주어진 시간에서 가장 많은 회의를 진행시킬려면?
    //종료시간을 기준으로 쭉 정렬한다음 -> 겹치지않는 선에서 어떤게 가장 많이 들어갈지 생각해봐야한다.
    //만약 종료시간이 같다면 시작시간이 빠른애가 앞에나오는게 좋을듯함.

    private static int[][] time;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        time = new int[N][2];

        for(int i = 0; i < N; i++) {
            time[i][0] = scanner.nextInt();
            time[i][1] = scanner.nextInt();
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if(S[1] == E[1]) {
                    return S[0] - E[0];
                }
                return S[1] - E[1];

            }
        });

        int count  = 0;
        int end = -1;

        for(int i = 0; i <N; i++) {
            if(time[i][0] >= end) {
                end = time[i][1];
                count++;
            }
        }

        System.out.println(count);



    }


}
