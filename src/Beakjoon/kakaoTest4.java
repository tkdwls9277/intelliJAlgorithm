package Beakjoon;

public class kakaoTest4 {
    public static void main(String[] args) {
        System.out.println(Solution(6,4,6,2,
                new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
    }

    public static int Solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        boolean[] check = new boolean[n];
        //dfs를 하나 만들어 두고 s>a>b, s>b>a, s>a+s>b 의 경우를 각각 계산하여
        //n = 지점, s = 출발점, a = 1번째, b = 2번쨰, fares = 경로당 비용
        int sab = dfs(s,a,fares,check,0,100000)+dfs(a,b,fares,check,0,100000);
        System.out.println(sab);
        int sba = dfs(s,b,fares,check,0,100000)+dfs(b,a,fares,check,0,100000);
        System.out.println(sba);
        int sasb = dfs(s,a,fares,check,0,100000)+dfs(s,b,fares,check,0,100000);
        System.out.println(sasb);

        answer = sab>sba?sba:sab;
        answer = answer>sasb?sasb:answer;

        return answer;
    }

    public static int dfs(int start, int end, int[][] fares, boolean[] check, int cost, int result){
        for(int i=0;i<fares.length-1;i++){
            if(fares[i][1] == end) {
                return cost<result?result=cost:result;
            }
            
            if(fares[i][0] == start && !check[fares[i][1]-1]){
                check[fares[i][1]-1]=true;
                dfs(fares[i][1],end, fares, check, cost+fares[i][2], result);
                check[fares[i][1]-1]=false;
            }
        }


        return result;
    }
}
