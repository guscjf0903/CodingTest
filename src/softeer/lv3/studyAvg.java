package softeer.lv3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class studyAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int backPack = sc.nextInt();
        int N = sc.nextInt();
        Jam[] jams = new Jam[N];

        for(int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int price = sc.nextInt();

            jams[i] = new Jam(weight, price);
        }
        Arrays.sort(jams, new Comparator<Jam>() {
            @Override
            public int compare(Jam o1, Jam o2) {
                return Integer.compare(o2.price, o1.price);
            }
        });

        int sum = 0;
        for(int i = 0; i < N; i++) {
            if(backPack == 0) {
                break;
            }
            if(backPack >= jams[i].weight) {
                sum += jams[i].price * jams[i].weight;
                backPack -= jams[i].weight;
            } else {
                sum += jams[i].price * backPack;
                backPack = 0;
            }
        }

        System.out.println(sum);

    }
    public static class Jam {
        int weight;
        int price;

        public Jam(int weight, int price){
            this.weight = weight;
            this.price = price;
        }
    }
}
