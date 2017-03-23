import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PathFinding {
    private class Node{
        int player1X, player1Y, player2X, player2Y;
        int steps=0;
        public Node(int player1X,int player1Y, int player2X, int player2Y,int steps){
            this.player1X=player1X;
            this.player1Y= player1Y;
            this.player2X=player2X;
            this.player2Y=player2Y;
            this.steps = steps;
        }
    }

    int X=0;
    int Y=0;
    boolean[][][][] visited = new boolean[20][20][20][20];
    public int minTurns(String[] board) {
        X = board.length;
        Y = board[0].length();
        int a=0, b= 0;
        Node start = new Node(0,0,0,0,0);
        //find the start position node
        for(int i=0;i<X;i++){
            for(int j=0;j<Y;j++){
                if(board[i].charAt(j)=='A'){
                    a++;
                    start.player1X=i;
                    start.player1Y=j;
                }
                else if(board[i].charAt(j)=='B'){
                    b++;
                    start.player2X=i;
                    start.player2Y=j;
                }
            }
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(start);
        System.out.println(start.player1X+","+start.player1Y+","+start.player2X+","+start.player2Y);
        while(!q.isEmpty()) {
            Node top = q.remove();

            if (!ok(top.player1X, top.player1Y, top.player2X, top.player2Y))
                continue;
            //check if a player is on top of another.
            if(top.player1X==top.player2X&&top.player1Y==top.player2Y)
                continue;
            //check if it is o/p exit condition
            if (reachedSolutionState(top, start))
                return top.steps;
            int[] dx = {0, 1, 0, -1, 0, 1, -1, -1, 1};
            int[] dy = {0, 0, 1, 0, -1, 1, -1, 1, -1};
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {

                            if(!ok(top.player1X+i,top.player1Y+j,top.player2X+k,top.player2Y+l))
                                continue;
                           // System.out.println("x1,y1,x2,y2: "+(top.player1X+i)+","+(top.player1Y+j)+","+(top.player2X+k)+","+(top.player2Y+l));

                            //verify if we are crossing both x and y directly
                            if (top.player1X == (top.player2X + k) && top.player1Y == (top.player2Y + l) && top.player2X == (top.player1X + i) && top.player2Y == (top.player1Y + j))
                                continue;
                            if (!visited[top.player1X + i][top.player1Y + j][top.player2X + k][top.player2Y + l] && board[top.player1X].charAt(top.player1Y) != 'X' && board[top.player2X].charAt(top.player2Y) != 'X') {
                                q.add(new Node(top.player1X + i, top.player1Y + j, top.player2X + k, top.player2Y + l, top.steps + 1));
                                visited[top.player1X + i][top.player1Y + j][top.player2X + k][top.player2Y + l] = true;
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }



    public boolean reachedSolutionState(Node top, Node start){
        return (top.player1X==start.player2X&& top.player1Y==start.player2Y&&top.player2X==start.player1X&&top.player2Y==start.player1Y);
    }

    public boolean ok(int x1, int y1, int x2, int y2){
        if(x1>=0&&x1<X&&x2>=0&&x2<X&&y1>=0&&y1<Y&&y2>=0&&y2<Y)
            return true;
        return false;
    }


    public void test(){
        String[] board={"AB.................X",
                "XXXXXXXXXXXXXXXXXXX.",
                "X..................X",
                ".XXXXXXXXXXXXXXXXXXX",
                "X..................X",
                "XXXXXXXXXXXXXXXXXXX.",
                "X..................X",
                ".XXXXXXXXXXXXXXXXXXX",
                "X..................X",
                "XXXXXXXXXXXXXXXXXXX.",
                "X..................X",
                ".XXXXXXXXXXXXXXXXXXX",
                "X..................X",
                "XXXXXXXXXXXXXXXXXXX.",
                "X..................X",
                ".XXXXXXXXXXXXXXXXXXX",
                "X..................X",
                "XXXXXXXXXXXXXXXXXXX.",
                "...................X",
                ".XXXXXXXXXXXXXXXXXXX"};



        int res = minTurns(board);
        System.out.println(res);
    }

    public static void main(String[] args){
        PathFinding p = new PathFinding();
        p.test();

    }

}
