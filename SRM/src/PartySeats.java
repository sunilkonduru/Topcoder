/*
  Good question for its corner cases:
    1) Always consider what will happen when n =0 and n=1. Here n=1 condition fails only one boy and one girl you can never form a circle
    with host and hostess in b/w them and a body and next to each other.

    http://community.topcoder.com/stat?c=problem_statement&pm=1854

 */

import java.util.*;

public class PartySeats
{
    public String[] seating(String[] attendees)
    {
        List<String> boys = new ArrayList<String>();
        List<String> girls = new ArrayList<String>();
        for(String a: attendees){
            String[] w= a.split(" ");
            if(w[1].equals("boy"))
                boys.add(w[0]);
            else if(w[1].equals("girl"))
                girls.add(w[0]);
        }

        Collections.sort(boys);
        Collections.sort(girls);

        int bs = boys.size();
        int gs = girls.size();


        String[] res;

        if(bs!=gs){
            res = new String[0];
            return res;
        }
        else if(bs==gs&&bs==1){
            res = new String[0];
            return res;
        }
        else if(bs==gs){
            int total = bs+gs+2;
            int iHostess = total/2;
            int iHost = 0;
            res = new String[total];
            res[0]= "HOST";
            res[iHostess]="HOSTESS";
            Iterator<String> b = boys.iterator();
            Iterator<String> g = girls.iterator();
            for(int i=1;i<total;i++){
                if(i==iHostess)
                    continue;

                if(g.hasNext()){
                    if(i%2==1){
                        res[i]=g.next();
                    }
                }
                if(b.hasNext()){

                    if(i%2==0){
                        res[i]=b.next();
                    }
                }

            }
            return res;
        }
        else{
            res = new String[0];
            return res;
        }


    }


}
//Powered by [KawigiEdit] 2.0!