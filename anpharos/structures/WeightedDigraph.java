package anpharos.structures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class WeightedDigraph {
    private final int V; // number of vertices
    private int E; // number of edges
    private List<DirectedEdge>[] adj; // adjacency lists

    public WeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<DirectedEdge>[]) new List[V]; // Unsafe operation (array of generic type)
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> list = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            for (DirectedEdge e : adj[i]) {
                list.add(e);
            }
        }
        return list;
    }

    public String toString() {
        return this.edges().toString();
    }

    public double[][] toMatrix() {
        double[][] matrix = new double[E][E];
        String tmp = "";
        System.out.println(this.V);
        System.out.println(Arrays.toString(adj));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                matrix[adj[i].get(j).from()][adj[i].get(j).to()] = adj[i].get(j).getWeight();
            }
        }
        return matrix;
    }

    public String toStringMatrix(){
        double[][] matrix = this.toMatrix();
        int x = 0;
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (double[] row : matrix) {
            sj.add(Arrays.toString(row));
        }
        String result = sj.toString();
        return result;
    }



    public static void main(String[] args) {
        WeightedDigraph tmp = new WeightedDigraph(20);
        System.out.println("Empty" + tmp);
        tmp.addEdge(new DirectedEdge(0,1,100));
        tmp.addEdge(new DirectedEdge(1,2,100));
        tmp.addEdge(new DirectedEdge(0,3,100));
        tmp.addEdge(new DirectedEdge(1,2,100));
        tmp.addEdge(new DirectedEdge(3,4,100));
        System.out.println("Empty" + tmp);
        System.out.println("Matrix \n" + tmp.toStringMatrix());
    }
}
