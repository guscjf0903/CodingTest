package numbertheory;

import java.util.Arrays;
import java.util.Scanner;

public class Beak_1747 {
    //소수이면서 팰린드롬인 수를 찾아야함..
    //N을 정하면 N보다 큰 수 중에서 팰린드롬 소수를 찾아야함..

    //그럼 소수를 찾는 범위를 어떻게 선정해야할까?
    //1,000,000까지 모든 소수를 찾는다..?
    //그리고 N 보다 큰 소수를 확인하면서 팰린드롬인지 확인한다..?

    //팰린드롬은 어쨰확인..?
    //
    private static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        isPrime = new boolean[2000000 + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;


        for(int i = 2; i <= Math.sqrt(2000000); i++) {
            if(!isPrime[i]) {
                continue;
            }

            for(int j = i + i; j <= 2000000; j += i) {
                if(j % i == 0) {
                    isPrime[j] = false;
                }
            }
        }

        pelinCheck(N);
    }

    private static void pelinCheck(int N) {
        for (int i = N; i <= 2000000; i++) {
            if (isPrime[i]) {
                String a = Integer.toString(i);
                char[] b = a.toCharArray();
                boolean check = true;

                for (int j = 0; j < b.length; j++) {
                    if (b[j] != b[b.length - (j + 1)]) {
                        check = false;
                    }
                }

                if (check) {
                    System.out.println(i);
                    break;
                }
            }
        }


    }

}
