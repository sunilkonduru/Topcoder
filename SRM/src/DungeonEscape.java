import java.util.*;
/*
   http://community.topcoder.com/stat?c=problem_statement&pm=2449&rd=5073
*/

public class DungeonEscape {
    int depth;
    int width;
    public class Location implements Comparable<Location>{
        int level;
        int easting;
        int time;
        public Location(int level, int easting, int time){
            this.level = level;
            this.easting = easting;
            this.time = time;
        }

        public int compareTo(Location l){
            return time - l.time;
        }

        @Override
        public int hashCode(){
            int prime = 31;
            int result = 1;
            result = result*prime+level;
            result = result*prime+easting;
            return result;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null) return false;
            if(getClass()!=obj.getClass()) return false;
            Location other = (Location) obj;
            if(easting != other.easting)
                return false;
            if(level!=other.level)
                return false;
            return true;
        }

    }

    public boolean isWaterFilled(int level, int nextTime){
        return level!=depth && level >= (depth -(nextTime/width));
    }


    public int exitTime(String[] up, String[] down, String[] east, String[] west, int startLevel, int startEasting) {
        depth = up.length;
        width = up[0].length();
        Set<Location> visited = new HashSet<Location>();
        Queue<Location> loc = new PriorityQueue<Location>();
        loc.add(new Location(startLevel,startEasting,0));
        int minTime = Integer.MAX_VALUE;
        while(!loc.isEmpty()){
            Location top = loc.remove();
            if(!visited.add(top)) continue;

            if(top.level == depth){
                minTime = Math.min(minTime,top.time);
                break; //should try break and verify the answer.
            }


            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    //code to move only in up, down, left right directions - diagonals are not allowed.
                    if((i==0&&j==0) || (i!=0&&j!=0)) continue;
                    int level = top.level + i;
                    int easting = top.easting + j;
                    if(level == -1)  level = depth;
                    else if(level>=depth) continue;
                    if(easting<0 || easting>=width) continue;

                    String[] costs = null;
                    if(i==-1&&j==0) costs = up;
                    else if(i==1&&j==0) costs = down;
                    else if(i==0&&j==1) costs = east;
                    else if(i==0&&j==-1) costs = west;
                    else throw new IllegalArgumentException();

                    final char t = costs[top.level].charAt(top.easting);
                    if(t=='x') continue;
                    final int nextTime = top.time + (t-'0');
                    if(nextTime>=minTime) continue;
                    if(isWaterFilled(level,nextTime)) continue;
                    loc.add(new Location(level,easting,nextTime));


                }
            }
        }
        return minTime==Integer.MAX_VALUE?-1:minTime;
    }
}
