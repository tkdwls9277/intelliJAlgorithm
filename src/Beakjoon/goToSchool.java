package Beakjoon;

public class goToSchool {
    public static void main(String[] args) {
        System.out.println(solution(4,3,new int[][]{{2,2}}));
    }
        public static int solution(int m, int n, int[][] puddles) {
            int[][] roadMap = new int[m][n];

            for(int[] puddle: puddles){
                roadMap[puddle[1]-1][puddle[0]-1]=-1;
            }

            roadMap[0][0]=1;

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(roadMap[i][j]==-1){
                        roadMap[i][j]=0;
                        continue;
                    }
                    if(i!=0){
                        roadMap[i][j] += roadMap[i-1][j] % 1000000007;
                    }
                    if(j!=0)
                        roadMap[i][j] += roadMap[i][j-1] % 1000000007;
                }
            }

            return roadMap[m-1][n-1] % 1000000007;
        }
}
