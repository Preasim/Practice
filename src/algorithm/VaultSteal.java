package algorithm;

class VaultSteal {
    public static void main(String[] args) {
        int target = 30;
        int[] type = {5,6,7};

        long[] dp = new long[target+1];
        dp[0] = 1;

        for(int coin : type){
            for(int i=coin; i<=target;i++){
                System.out.println(coin);
                dp[i] += dp[i-coin];
            }
        }
        System.out.println("result : "+dp[target]);
    }
}
