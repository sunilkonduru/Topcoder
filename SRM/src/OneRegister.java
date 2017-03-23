/**
 *  http://community.topcoder.com/stat?c=problem_statement&pm=10992&rd=14239
 *  look for java integer max values.
    division by zero - ArithmeticError
    Be always worried about integer overflows when involving multiplications.
    if the last 32 bits are zero after the overflow, the result would be zero.
 */


import java.util.*;
public class OneRegister {
    public class Node {
        long value;
        char symbol;
        StringBuffer result = new StringBuffer();

        public Node(long value, char symbol) {
            this.value = value;
            this.symbol = symbol;

        }

        public Node() {

        }

        public int hashCode() {
            long prime = 31;
            long res = 1;
            res = res * prime + value;
            res = res * prime + symbol;
            return (int) res;
        }

        public boolean equals(Object o) {
            Node n = (Node) o;
            if (this.value != n.value) return false;
            if (this.symbol != n.symbol) return false;
            if (!this.result.equals(n.result)) return false;
            return true;
        }

    }

    public String getProgram(long s, long t) {

        if (s == t) return "";
        if (t == 0) return "-";

        Queue<Node> q = new LinkedList<Node>();
        Node start = new Node(s, '-');
        Set<Node> vis = new HashSet<Node>();
        vis.add(start);
        q.add(start);
        q.add(null);
        Set<String> result = new TreeSet<String>();
        int count = 0;
        boolean foundRes = false;
        boolean first = true;
        long div = 0;
        while (!q.isEmpty()) {
            Node top = q.remove();
            if (top == null) {
                count++;
                if (!q.isEmpty()) {
                    q.add(null);
                }
                //not needed could have already ordered by adding * first and then +...
                //  if (foundRes) {
                // List<String> list = new ArrayList<String>();
                //list.addAll(result);
                // return list.get(0);
                // }
                continue;
            }


            //what is your termination condition if result is not found: Is the queue going to be empty by itself or you are going to INF.
            //Large multiplications return 0. Or negative value. Rounds.
            if (top != null & top.value > t && !first)
                continue;

            long sum = top.value + top.value; //lookout for overflows. Do the basic math.
            long mul = top.value * top.value;
            // long sub = top.value-top.value; - this was not needed at all.
            // Only need to run one time. You can very well run that in the beginning. and also should check for the /0 condition.
            if (top.value != 0 && first) {
                div = top.value / top.value;
            }

            Node[] n1 = new Node[4];
            for (int i = 0; i < 4; i++) {
                if (i == 2) continue;
                if (i == 3 && !first) continue;
                n1[i] = new Node();
                n1[i].result.append(top.result);
            }
            n1[1].value = sum;
            n1[1].symbol = '+';
            n1[1].result.append(n1[1].symbol);
            n1[0].value = mul;
            n1[0].symbol = '*';
            n1[0].result.append(n1[0].symbol);
            // n1[2].value=sub; n1[2].symbol='-';n1[2].result.append(n1[2].symbol); - again not needed.
            if (top.value != 0 && first) {
                n1[3].value = div;
                n1[3].symbol = '/';
                n1[3].result.append(n1[3].symbol);
            }
            for (int i = 0; i < 4; i++) {
                if (i == 2) //shitty code.
                    continue;
                if (i == 3 && first == false) {//more shittier.
                    continue;
                }
                if (first && i == 3)
                    first = false;

                if (!vis.contains(n1[i])) {
                    vis.add(n1[i]);
                    q.add(n1[i]);
                    if (n1[i].value == t) {
                        foundRes = true;
                        return new String(n1[i].result);
                    }
                }
            }
        }
        return ":-(";
    }

    public void test(){
        long s = 7;
        long t = 256 ;
        System.out.println(getProgram(s,t));
    }

    public static void main(String[] args){
        OneRegister o = new OneRegister();
        o.test();
    }

}
