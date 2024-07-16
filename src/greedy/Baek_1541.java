package greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Baek_1541 {
    //모든 수식에서 가장 최소값을 만드는 방식
    //1. -가 나올때 뒤에있는 모든 +를 합치자(괄호를 쳐서 음수의 양을 늘리자는 말.)
    //-가 나오는 순간 다음 -나오기 전까지 모두 합산하면 됨.

    //입력을 어떻게받지? 스캐너로받아서 스플릿사용하면 되겠구만..;;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] A = line.split("[-]");

        int sum = 0;
        String[] plus = A[0].split("[+]");
        for(String p : plus) {
            sum += Integer.parseInt(p);
        }


        for(int i = 1; i < A.length; i++) {
            String[] B = A[i].split("[+]");
            for(String b : B) {
                sum -= Integer.parseInt(b);
            }
        }


        System.out.println(sum);

    }
}
