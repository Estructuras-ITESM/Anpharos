package anpharos.structures;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
    private final int V; // number of vertices
    private int E; // number of edges
    private List<DirectedEdge>[] adj; // adjacency lists

    public WeightedGraph(int V) {
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
            return list;
        }
    }
}
