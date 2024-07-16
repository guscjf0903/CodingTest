package numbertheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek_1850 {
    //최대공약수가 1로만 이루어져있는데 엄청 큰값이 입력됨.

    //입력되는 자릿수의 최대공약수에 맞추면 되는거아닌가?
    //ㅇㅇ 맞는듯?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());


        long A = Long.parseLong(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());
        long C = uclid(A,B);

        for(int i = 0; i < C; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    private static long uclid(long A, long B){
        if(B == 0) {
            return A;
        }else {
            return uclid(B, A % B);
        }
    }
}
