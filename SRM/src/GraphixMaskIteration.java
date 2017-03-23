import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class GraphixMaskIteration{
    private class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y=y;
        }
    }
    final int X = 400;
    final int Y = 600;
    boolean[][] fill = new boolean[X][Y];
    public int[] sortedAreas(String[] rectangles) {
        for (String rect : rectangles) {
            String[] pts = rect.split(" ");
            int x1 = (int) Integer.parseInt(pts[0]);
            int y1 = (int) Integer.parseInt(pts[1]);
            int x2 = (int) Integer.parseInt(pts[2]);
            int y2 = (int) Integer.parseInt(pts[3]);
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    fill[i][j] = true;
                }
            }

        }
        List<Integer> list = new ArrayList<Integer>();
        int res = 0;
        for(int i=0;i<X;i++){
            for(int j=0;j<Y;j++){
                if(isValid(i,j)){
                    res =  doFloodFill(i,j);
                    //System.out.println(res);
                    list.add(res);
                }
            }
        }
        Collections.sort(list);
        int [] res1 = new int[list.size()];
        int k = 0;
        for(int v: list){
            res1[k++]=v;
        }

        return res1;
    }

    public boolean isValid(int x, int y){
        return (x>=0&&x<400&&y>=0&&y<600&&!fill[x][y]);
    }

    public int doFloodFill(int x, int y){

        Stack<Node> st = new Stack<Node>();
        Node n1 = new Node(x,y);
        st.push(n1);
        int res = 0;
        while(!st.isEmpty()){
            Node top = st.pop();
            //System.out.println("x,y: "+top.x+","+top.y);
            if(!isValid(top.x,top.y))
                continue;
            res++;
            fill[top.x][top.y]=true;
            Node n2 = new Node(top.x-1,top.y);
            Node n3 = new Node(top.x,top.y-1);
            Node n4 = new Node(top.x+1,top.y);
            Node n5= new Node(top.x,top.y+1);
            st.push(n2);
            st.push(n3);
            st.push(n4);
            st.push(n5);
        }
        //  System.out.println("res:"+res);
        return res;
    }

    public void test(){
        //String[] rect1 ={"0 292 399 307"};
        //int[] res = sortedAreas(rect1);
        String[] rect2 = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
        int[] res2 = sortedAreas(rect2);
        for(int v: res2){
            System.out.println(v);
        }

    }

    public static void main(String[] args){
        GraphixMaskIteration g = new GraphixMaskIteration();
        g.test();
    }




}