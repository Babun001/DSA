import java.io.*;
import java.util.*;

/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time.

Count the number of ways, the person can reach the top (order does matter). 

Examples:

Input: n = 1
Output: 1
Explanation: There is only one way to climb 1 stair. 
Input: n = 3
Output: 3
Explanation: The following are three ways to reach the n-th stair.


Input: n = 4
Output: 5
Explanation: There are five ways to reach 4th stair: [1, 1, 1, 1], [1, 1, 2], [2, 1, 1], [1, 2, 1] and [2, 2].
 */
class ClimbingStairsWith1nd2{
    //using recurtion
    public static int stairsClimbing(int n){
        if(n==1)return 1;
        if(n==2)return 2;
        return stairsClimbing(n-1)+ stairsClimbing(n-2);
    }


    //using memoization or top-down approach
    public static int stairsClimbingMemo(int n){
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memoSolve(n,dp);
    }
    static int memoSolve(int n, int[] dp){
        if(n==1)return 1;
        if(n==2)return 2;
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = memoSolve(n-1,dp)+ memoSolve(n-2,dp);
    }

    //using tabulation or bottom-up approach
    public static int stairsClimningTab(int n){
        if(n==1 || n==2)return n;

        int [] dp = new int[n];
        // dp[0]=0;
        dp[0]=1;
        dp[1]=2;

        for(int i = 2; i<n; i++){
            dp[i] = dp[i-1]+dp[i-2];            
        }

        return dp[n-1];

    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        int temp = 5;
        System.out.println(stairsClimningTab(temp));
        // System.out.println(stairsClimbing(temp));
    }
}