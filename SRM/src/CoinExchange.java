public class CoinExchange{

    private static void minCoins(int[] coins, int n){
        if(coins==null||coins.length==0)
            throw new IllegalArgumentException("coins array is empty or null");
        int[] count = new int[n+1];
        count[0]=0;
        for(int i=1;i<=n;i++){
            int minCoins = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    int c = count[i-coins[j]]+1;
                    if(c<minCoins){
                        minCoins = c;
                        count[i]=minCoins;
                    }
                }
            }
        }
        System.out.println(count[n]);
    }



    public static void main(String[] arg){
        int[] coins = {};
        minCoins(coins,10);
    }
}