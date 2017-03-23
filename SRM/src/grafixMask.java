import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class grafixMask {

    boolean[][] fill = new boolean[400][600];
    public int[] sortedAreas(String[] rectangles) {
        for(String rect: rectangles){
            String[] pts = rect.split(" ");
            int x1 = (int)Integer.parseInt(pts[0]);
            int y1 = (int)Integer.parseInt(pts[1]);
            int x2 = (int)Integer.parseInt(pts[2]);
            int y2 = (int)Integer.parseInt(pts[3]);
            for(int i=x1;i<x2;i++){
                for(int j=y1;j<y2;j++){
                    fill[i][j]=true;
                }
            }

        }
        List<Integer> list = new ArrayList<Integer>();
        int res = 0;
        for(int i=0;i<400;i++){
            for(int j=0;j<600;j++){
                if(isValid(i,j)){
                    System.out.println(i+","+j);
                    res = doFloodFill(i,j);
                    list.add(res);
                }

            }
        }
        Collections.sort(list);
        int[] fres = new int[list.size()];
        int k = 0;
        for(int v: list){
            System.out.println("list"+v);
            fres[k++]=v;
        }

        return fres;
    }
    public int doFloodFill(int x, int y){
        if(!isValid(x,y))
            return 0;
        System.out.println("x,y: "+x+","+y);
        fill[x][y]=true;
        return 1+doFloodFill(x-1,y)+doFloodFill(x,y-1)+doFloodFill(x+1,y)+doFloodFill(x,y+1);
    }

    public boolean isValid(int x, int y){
        return (x>=0&&x<400&&y>=0&&y<600&&!fill[x][y]);
    }

    public void test(){
        String[] rect ={"0 20 399 40"};
        int[] res = sortedAreas(rect);
        for(int v: res){
            System.out.println(v);
        }

    }

    public static void main(String[] args){
        grafixMask g = new grafixMask();
        g.test();
    }


}
