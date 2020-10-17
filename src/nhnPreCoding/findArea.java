package nhnPreCoding;

import java.util.ArrayList;
import java.util.Collections;

public class findArea {
    static boolean[][] flag;

    public static void main(String[] args) {

        //test case 1
        //result = 3, 4 5 7
        ArrayList result = solution(6, new int[][]{{0, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 1, 0}, {1, 1, 1, 0, 0, 0}});
        System.out.println(result.size());
        Collections.sort(result);
        print(result);

        //test case 2
        //result = 0
        result = solution(4, new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}});
        System.out.println(result.size());
        Collections.sort(result);
        print(result);

        // test case 3
        // result = 2, 2 2
        result = solution(4, new int[][]{{1,0,0,0},{1,0,0,0},{0,0,0,0},{0,0,1,1}});
        System.out.println(result.size());
        Collections.sort(result);
        print(result);
    }

    public static ArrayList solution(int N, int[][] newArea) {
        flag = new boolean[N][N];
        ArrayList result = new ArrayList();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (newArea[i][j] == 0) {
                    continue;
                }
                if (flag[i][j] == true) {
                    continue;
                }

                result.add(searchArea(N, i, j, newArea, 0));

            }
        }
        return result;
    }

    public static int searchArea(int N, int i, int j, int[][] newArea, int count) {
        count++;

        if ((i + 1) < N && (j + 1) < N)
            if (newArea[i + 1][j] == 0 && newArea[i][j + 1] == 0)
                return count;

        if ((i + 1) < N) {
            if (newArea[i + 1][j] == 1 && flag[i + 1][j] == false) {
                flag[i + 1][j] = true;
                count = searchArea(N, i + 1, j, newArea, count);
            }
        }
        if ((j + 1) < N) {
            if (newArea[i][j + 1] == 1 && flag[i][j + 1] == false) {
                flag[i][j + 1] = true;
                count = searchArea(N, i, j + 1, newArea, count);
            }
        }
        return count;
    }

    public static void print(ArrayList result){
        for (int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");
        System.out.println();
    }
}
