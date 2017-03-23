public class RockPaperScissorsMagicEasy
{
    public int count(int[] card, int score)
    {

        final int MOD = 1000000007;
        //compute ncr by using pascal triangle
        int l = card.length;
        System.out.println("card length:"+l);
        if(score>card.length)
            return 0;
        int[][] c = new int[l+1][l+1];

        for(int i=0;i<=l;i++){
            c[i][0]=1;
            for(int j=1;j<=i;j++){

                c[i][j]=(c[i-1][j-1]+c[i-1][j])%MOD;
            }
        }
	/* for(int i=0;i<=l;i++){
		  for(int j=0;j<=l;j++){
		   System.out.print(c[i][j]+" ");
		  }
		  System.out.println();
		}
		*/

        //not very efficient in terms of space, but it is what it is.
        int res1 = c[l][score];
        System.out.println(res1);
        int v = card.length-score;
        int res2 = 1;
        for(int i=0;i<v;i++){
            res1 = 2*res1%MOD;
        }
        return res1%MOD;
    }

  //  <%:testing-code%>
}
//Powered by [KawigiEdit] 2.0!