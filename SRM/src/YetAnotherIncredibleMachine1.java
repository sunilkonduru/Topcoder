public class YetAnotherIncredibleMachine1
{
    public int countWays(int[] platformMount, int[] platformLength, int[] balls)
    {
        final long MOD = 1000000009;
        long res = 1;
        for(int i=0;i<platformMount.length;i++){
            long count = 0;
            for(int j = platformMount[i]-platformLength[i];j<=platformMount[i];j++){
                boolean valid = true;
                for(int b: balls){
                    //  System.out.println("j:"+j);
                    //System.out.println("b:"+b);
                    // System.out.println("j+len:"+(j+platformLength[i]));

                    if(b>=j&&b<=j+platformLength[i]){

                        valid = false;
                        break;
                    }
                }
                // System.out.println(valid);
                if(valid){
                    count++;
                    //System.out.println(count);
                }

            }
            res *= count;
            res %= MOD;
        }
        return (int)res;
    }


}
//Powered by [KawigiEdit] 2.0!