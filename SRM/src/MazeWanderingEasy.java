/**
 * SRM 440
 *
 **/
import java.util.*;
public class MazeWanderingEasy {

    public class Point {
        int x, y;
        Point p = null;
        int count = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int prime = 97;
            int res = 1;
            res = res * prime + x;
            res = res * prime + y;
            return res;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (getClass() == o.getClass()) return true;
            Point p = (Point) o;
            if (this.x != p.x) return false;
            if (this.y != p.y) return false;
            return true;
        }
    }

    public int decisions(String[] maze) {
        int si = 0, sj = 0, ei = 0, ej = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                if (maze[i].charAt(j) == 'M') {
                    si = i;
                    sj = j;
                }
                if (maze[i].charAt(j) == '*') {
                    ei = i;
                    ej = j;
                }
            }
        }
        int res = 0;
        Point start = new Point(si, sj);
        Queue<Point> q = new LinkedList<Point>();
        Queue<Point> tempQ = new LinkedList<Point>();
        Set<Point> vis = new HashSet<Point>();
        q.add(start);
        boolean foundDest = false;
        vis.add(start);
        Point dest = null;
        while (!q.isEmpty()) {
            Point top = q.remove();
            int count = 0;
            Point prev = null;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i == 0 && j == 0) || (i != 0 && j != 0)) continue;
                    int x = top.x + i;
                    int y = top.y + j;
                    if (!ok(x, y, maze.length, maze[0].length())) continue;
                    Point p = new Point(x, y);
                    if (vis.contains(p)) continue;
                    vis.add(p);
                    // System.out.println("Visited:"+p.x+","+p.y); - easy way to debug bfs
                    if (maze[x].charAt(y) != 'X') {
                        count++;
                        if(count>1)
                            p.count = 1;
                        p.p = top;
                        if(prev==null){
                            prev = p;
                        }
                        q.add(p);
                        if (x == ei && y == ej) {
                            dest = p;
                            foundDest = true;
                        }
                    }
                }
            }

            if(prev!=null&&count>1){
                prev.count = 1;
            }


            //this code was not needed. All I need to have is to store the previous node state. For the first element I wouldnt know if count>1. Now I just update the first node. Dont need to store all the Points in one queue and need to add them.
  /*
   int size = tempQ.size();
   while (!tempQ.isEmpty()) {
    Point p1 = tempQ.remove();
    if (size > 1)
     p1.count = 1;
    q.add(p1);
    //System.out.println("Added to Q:"+p1.x+","+p1.y);
   }

   */

            count = 0;

            if (foundDest) {

                while (dest != null) {
                    count += dest.count;
                    dest = dest.p;
                    res = count;
                }
            }

        }
        return res;
    }


    public boolean ok(int x, int y, int xL, int yL) {
        return (x >= 0 && x < xL && y >= 0 && y < yL);
    }



    public void test(){
        String[] s= {".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                "M.......................................*",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X."};
        int res = decisions(s);
        System.out.println(res);
    }
    public static void main(String[] args){
        MazeWanderingEasy m = new MazeWanderingEasy();
        m.test();
    }
}
