import java.util.*;

//https://community.topcoder.com/stat?c=problem_statement&pm=2274&rd=5009

public class BombMan {
    int w, h;

    public class BombMann implements Comparable<BombMann>{
        int x, y;
        int time;
        int noBombs;
        public BombMann(int x, int y, int time, int noBombs){
            this.x=x;
            this.y=y;
            this.time=time;
            this.noBombs=noBombs;
        }

        @Override
        public int hashCode(){
            int prime = 31;
            int res = 1;
            res = res*prime + x;
            res = res*prime + y;
            //res = res*prime + time;
            res = res*prime + noBombs;
            return res;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null) return false;
            if(getClass()!=obj.getClass()) return false;
            BombMann b = (BombMann) obj;
            if(this.x!=b.x)
                return false;
            if(this.y!=b.y)
                return false;
            if(this.noBombs!=b.noBombs)
                return false;
            return true;


			/*
			BombMann b = (BombMann) obj;
			return (this.x==b.x&&this.y==b.y&&this.noBombs==b.noBombs);
			*/
        }

        @Override
        public int compareTo(BombMann b){
            return time - b.time;
        }


    }

    public int shortestPath(String[] maze, int bombs) {
        int si=0,sj=0,ei=0,ej=0;
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length();j++){
                char c=maze[i].charAt(j);
                if(c=='B'){
                    si=i;
                    sj=j;
                }
                else if(c=='E'){
                    ei=i;
                    ej=j;
                }
            }
        }

        w=maze.length;
        h =maze[0].length();

        Queue<BombMann> queue = new PriorityQueue<BombMann>();
        Set<BombMann> set = new HashSet<BombMann>();
        queue.add(new BombMann(si,sj,0,bombs));
        while(!queue.isEmpty()){
            BombMann top = queue.remove();
            if(set.contains(top)) continue; //hashCode method is important.
            set.add(top);
            int x,y;
            if(top.x==ei&&top.y==ej) return top.time;

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if((i==0&&j==0)||(i!=0&&j!=0)) continue;
                    x = top.x+i;
                    y = top.y+j;


                    if(!ok(x,y)) continue;
                    if(top.noBombs==0&&maze[x].charAt(y)=='#') continue;
                    if(maze[x].charAt(y)=='.')
                        queue.add(new BombMann(x,y,top.time+1,top.noBombs));
                    else if(maze[x].charAt(y)=='#')
                        queue.add(new BombMann(x,y,top.time+3,top.noBombs-1));
                    else if(maze[x].charAt(y)=='E') //my code did not work as I didnt write this statment forgot the condition.
                        queue.add(new BombMann(x,y,top.time+1,top.noBombs));
                }
            }

        }

        return -1;
    }

    public boolean ok(int x, int y){
        return ((x>=0&&x<w)&&(y>=0&&y<h));
    }

    public void test(){
        String[] a ={".....B.",

                ".#####.",
                ".#...#.",
                ".#E#.#.",
                ".###.#.",
                "......."};
        int v1 = 1;
        int r1 = shortestPath(a,v1);
        System.out.println(r1);

        String[] b = {"B.#.#.#...E"};
        int v2 = 2;
        //int r2 = shortestPath(b,v2);
        //System.out.println(r2);

    }

    public static void main(String[] args){
        BombMan b = new BombMan();
        b.test();
    }



}

