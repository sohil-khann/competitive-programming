import java.util.ArrayList;
import java.util.Scanner;

public class Adjecency {

    static class InnerAdjecency {
        int src, dest, wt;

        InnerAdjecency(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        Scanner sc = new Scanner(System.in);
        ArrayList<InnerAdjecency>[] graph = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            
        }

        graph[0].add(new InnerAdjecency(0, 1, 4));
        graph[0].add(new InnerAdjecency(0, 1, 4));
        graph[0].add(new InnerAdjecency(0, 1, 4));
        graph[0].add(new InnerAdjecency(0, 1, 4));
        graph[0].add(new InnerAdjecency(0, 1, 48));








    }
}|
