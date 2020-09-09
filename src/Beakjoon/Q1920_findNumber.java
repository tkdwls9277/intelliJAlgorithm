package Beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q1920_findNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i;

        int countN = s.nextInt();
        int[] N = new int[countN];

        for (i = 0; i < countN; i++) {
            N[i] = s.nextInt();
        }

        int countM = s.nextInt();
        int[] M = new int[countM];

        for (i = 0; i < countM; i++) {
            M[i] = s.nextInt();
        }

        Arrays.sort(N);

        for (i = 0; i < countM; i++) {
            System.out.println(binarySearch(0, N.length, M[i], N));
        }
    }

    public static int binarySearch(int start, int end, int search, int[] M) {
        int mid = (end + start) / 2;

        if (mid >= end) return 0;

        if (search == M[mid]) return 1;
        else if (search > M[mid]) return binarySearch(mid + 1, end, search, M);
        else return binarySearch(start, mid, search, M);
    }
}
