
import java.io.*;
import lib.*;


import java.io.OutputStream;

public class Maze377ADFS{
    public static void main(String[] args){
        InputStream inputStream = System.in;
        OutputStream outStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outStream);
        TaskA solver = new TaskA();
        solver.solve(1,in,out);
        out.close();
    }
}
class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int rowCount = in.nextInt();
        int columnCount = in.nextInt();
        int fill = in.nextInt();
        char[][] map = new char[rowCount][columnCount];
        for(int i=0;i<rowCount;i++){
            String line = in.next();
            for(int j =0;j<line.length();j++){
                map[i][j]=line.charAt(j);
            }
        }

        int size = 0;
        int[] rowQueue = new int[rowCount*columnCount];
        int[] colQueue = new int[rowCount*columnCount];
        for(int i=0;i<rowCount && size==0;i++){
            for(int j=0;j<columnCount && size==0;j++){
                if(map[i][j]=='.'){
                    rowQueue[0]=i;
                    colQueue[0]=j;
                    map[i][j]='X';
                    size = 1;
                }
            }
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int i=0;i<size;i++){
            int row = rowQueue[i];
            int col = colQueue[i];
            for(int j=0;j<4;j++){
                int nRow = row+dx[j];
                int nColumn = col+dy[j];
                if(ok(nRow,nColumn,rowCount,columnCount)&&map[nRow][nColumn]=='.'){
                    map[nRow][nColumn] = 'X';
                    rowQueue[size] = nRow;
                    colQueue[size++] = nColumn;
                }
            }
        }

        for(int i=0;i<size-fill;i++){
            map[rowQueue[i]][colQueue[i]]='.';
        }

        for(char[] row:map){
            out.printLine(new String(row));
        }


    }

    boolean ok(int row, int col, int rowLen, int colLen){
        return(row >=0 && col>=0 && row<rowLen && col<colLen);
    }
}



