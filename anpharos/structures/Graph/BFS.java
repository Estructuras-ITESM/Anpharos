package anpharos.structures.Graph;

import anpharos.structures.Queue;

import java.util.ArrayList;

/**
 * Created on 5/7/17.
 */
public class BFS {
    boolean[] visited;
    Queue<GraphNode> queue;
    WeightedDigraph graph;
    ArrayList<Edge> trace;


    public void BFS(WeightedDigraph graph){
        this.graph = graph;
        visited = new boolean[graph.size];
        trace = new ArrayList<>();
        queue = new Queue<>();
    }
    public ArrayList<Edge> trace(String source){
        queue.enqueue(graph.getNodeRef(source));
        while(!queue.isEmpty()){
            GraphNode dequeued = queue.dequeue();
            trace.add()
        }
        return trace;
    }
    public static void main(String[] args) {

    }
}
