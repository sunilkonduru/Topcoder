import java.util.*;

public class DNAString
{
    public int minChanges(int maxPeriod, String[] dna)
    {
        StringBuilder sb = new StringBuilder();
        for(String d: dna){
            sb.append(d);
        }
        String fstr = new String(sb);
        StringBuilder sb1=null;
        int min=Integer.MAX_VALUE;
        for(int k=maxPeriod;k>0;k--){
            sb1 = new StringBuilder(fstr);
            int res = 0;
            for(int i = 0;i<k;i++){
                Character a = sb1.charAt(i);
                TreeMap<Character,Integer> t = new TreeMap<Character,Integer>();
                t.put(a,1);
                int count=1;
                for(int j=i+k;j<sb.length();j+=k){
                    if(t.containsKey(sb1.charAt(j))){
                        t.put(sb1.charAt(j),t.get(sb.charAt(j))+1);

                    }
                    else{
                        t.put(sb1.charAt(j),1);
                    }
                    count++;
                }
                res += findBestValue(t,count);
            }

            System.out.println(res);
            if(res==0)
                return 0;
            min = Math.min(min,res);
        }


        return min;
    }

    public int findBestValue(TreeMap<Character,Integer> t, int count){

        int max = Integer.MIN_VALUE;
        int v = 0;
        for(Map.Entry<Character,Integer> entry: t.entrySet()){

            v = entry.getValue();
            max = Math.max(max,v);

        }

        return count-max;

    }

    public void test(){
        String[] dna= {"ATAGATA"};
        minChanges(3,dna);

    }

    public static void main(String[] args){
        DNAString d = new DNAString();
        d.test();

    }




    public int minChanges1(int maxPeriod, String[] dna){

        StringBuilder sb = new StringBuilder();
        for(String s: dna){
            sb.append(s);
        }
        int p = maxPeriod;
        char[] cs = new String(sb).toCharArray();
        for(int i=1;i<=p;i++){
            int[][] c = new int[i][p];
            for(int j=0;j<cs.length;j+=i){
                ++c[i][]
            }
        }
        return -1;
    }


    public int id(char c){
        if(c=='A') return 1;
        if(c=='C') return 2;
        if(c=='G') return 3;
        return 3;
    }


   //<%:testing-code%>
}
//Powered by [KawigiEdit] 2.0!