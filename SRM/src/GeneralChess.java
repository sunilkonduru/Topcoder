import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class GeneralChess
{
    public String[] attackPositions(String[] pieces)
    {
        int[] dx = {2,-2,1,1,-2,-1,-1,2};
        int[] dy = {1,1,2,-2,-1,2,-2,-1};
        int len = pieces.length;
        Map<String,Integer> map = new TreeMap<String,Integer>();
        for(String p: pieces){
            String[] xy = p.split(",");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            for(int i=0;i<dx.length;i++){
                int x1 = x+dx[i];
                int y1 = y+dy[i];
                String point = x1+","+y1;
                if(map.containsKey(point)){
                    map.put(point,map.get(point)+1);
                }
                else{
                    map.put(point,1);
                }
            }
        }

        List<String> list = new ArrayList<String>();
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue()==len){
                list.add(entry.getKey());
            }
        }

        //not

        Collections.sort(list,new Comparator<String>(){
            public int compare(String a, String b){
                Integer x1 = Integer.parseInt(a.split(",")[0]);
                Integer y1 = Integer.parseInt(a.split(",")[1]);
                Integer x2 = Integer.parseInt(b.split(",")[0]);
                Integer y2 = Integer.parseInt(b.split(",")[1]);
                int res = x1.compareTo(x2);
                if(res==0)
                    return y1.compareTo(y2);
                else
                    return res;
            }

        });

        String[] res = list.toArray(new String[list.size()]);
        return res;

    }


}
