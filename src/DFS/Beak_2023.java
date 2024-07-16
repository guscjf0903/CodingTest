package DFS;

import java.util.Scanner;

public class Beak_2023 {
    //소수를 찾아야한다. -> 소수의 특징. 홀수이다,첫자리가 짝수면 애초에 불가
    //자릿수를 넣고 해당 자릿수를 모두 확인.
    //첫자리 소수인 친구들 -> 둘쨰,셋째,넷째 자릿수대로 체크 -> 모두 통과하면 출력
    //재귀함수로 첫자리 소수 친구들을 넣고
    private static int nodeNum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        nodeNum = scanner.nextInt();

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    private static void DFS(int start, int N) {
        if(N == nodeNum && isSosu(start)) {
            System.out.println(start);
            return;
        }


        boolean check = isSosu(start);
        if(check) {
            DFS(start * 10 + 1,N + 1);
            DFS(start * 10 + 3,N + 1);
            DFS(start * 10 + 5,N + 1);
            DFS(start * 10 + 7,N + 1);
            DFS(start * 10 + 9,N + 1);
        } else {
            return;
        }

    }

    private static boolean isSosu(int num) {
        if(num < 2) {
            return false;
        }

        for(int i = 2; i <= num / 2; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
