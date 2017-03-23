/*
 SRM 364 Div2 Mid
 http://community.topcoder.com/stat?c=problem_statement&pm=8060
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;



public class Paintball
{
    public String[] getLeaderboard(String[] players, String[] messages)
    {
        int cntt = 0;
        Map<String, String> pt= new HashMap<String, String>();
        Map<String, Integer> t = new HashMap<String, Integer>();
        HashMap<String, Integer> p = new HashMap<String, Integer>();
        for(String player: players){
            String[] p1 = player.split(" ");
            pt.put(p1[0],p1[1]);
            t.put(p1[1],0);
           p.put(p1[0],0);
        }
        for(String msg: messages){
            String[] msgs = msg.split(" ");
            String h=msgs[0];
            String v = msgs[2];
            if(pt.get(h).equals(pt.get(v))){
                p.put(h,p.get(h)-1);
                t.put(pt.get(h), t.get(pt.get(h))-1);
            }
            else{
                p.put(h,p.get(h)+1);
                t.put(pt.get(h),t.get(pt.get(h))+1);
                p.put(v,p.get(v)-1);
                t.put(pt.get(v),t.get(pt.get(v))-1);
            }
        }

        int tSize = t.size();
        int pSize = p.size();
        String[] res = new String[tSize+pSize];
        int i = 0;

        Map<String, List<String>> finalResults = new HashMap<String, List<String>>();

        for(Map.Entry<String, Integer> entry: t.entrySet()){
            String team = entry.getKey();
            int count = entry.getValue();
            res[i]=team+" "+count;


            List<String> list = new ArrayList<String>();
            for(Map.Entry<String,Integer> entry1: p.entrySet()){
                if(pt.get(entry1.getKey()).equals(team)){
                    //res[i]="  "+entry1.getKey()+" "+entry1.getValue();
                    //i++;
                    list.add("  "+entry1.getKey()+" "+entry1.getValue());
                }

            }
            finalResults.put(res[i],list);
            i++;
        }


        List<Map.Entry<String,List<String>>> list = new ArrayList<Map.Entry<String,List<String>>>(finalResults.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,List<String>>>(){
            public int compare(Map.Entry<String,List<String>> m1, Map.Entry<String,List<String>> m2){
                int v1 = Integer.parseInt(m1.getKey().split(" ")[1]);
                int v2 = Integer.parseInt(m2.getKey().split(" ")[1]);
                if(v1>v2)
                    return -1;
                else if(v1<v2)
                    return 1;
                else
                {
                    return m1.getKey().compareTo(m2.getKey());
                }
            }

        });
         i = 0;

        for(Map.Entry<String,List<String>> m1:list){
            List<String> l1 = m1.getValue();
            Collections.sort(l1, new Comparator<String>(){
                public int compare(String a, String b){
                    Integer v1 = Integer.parseInt(a.trim().split(" ")[1]);
                    Integer v2 = Integer.parseInt(b.trim().split(" ")[1]);
                    int v3 = v2.compareTo(v1);
                    if(v3==0)
                        return a.trim().split(" ")[0].compareTo(b.trim().split(" ")[0]);
                    return v3;
                }
            });
            res[i]=m1.getKey();
            i++;
            for(String s:l1){
                res[i]=s;
                i++;
            }
        }

        System.out.println("After:");
        for(String re: res)
          System.out.println(re);

        return res;

    }
}
//Powered by [KawigiEdit] 2.0!