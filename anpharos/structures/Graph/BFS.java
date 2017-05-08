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
    ArrayList<GraphNode> trace;


    public BFS(WeightedDigraph graph) {
        this.graph = graph;
        visited = new boolean[graph.size];
        trace = new ArrayList<>();
        queue = new Queue<>();
    }

    public ArrayList<GraphNode> trace(String source) {
        queue.enqueue(graph.getNodeRef(source));
        visited[graph.getNodePosition(source)] = true;
        while (!queue.isEmpty()) {
            GraphNode dequeued = queue.dequeue();
            trace.add(dequeued);
            System.out.println("Visited:" +dequeued);
            for (Edge e : graph.adjList.get(dequeued)) {
                if (!visited[graph.getNodePosition(e.to)]) {
                    queue.enqueue(e.to);
                    visited[graph.getNodePosition(e.to)] = true;
                }
            }
        }
        return trace;
    }

    public static void main(String[] args) {
        ArrayList<String> nodes = new ArrayList<>();
        nodes.add("0");
        nodes.add("1");
        nodes.add("2");
        nodes.add("3");
        nodes.add("4");
        nodes.add("5");
        nodes.add("6");
        nodes.add("7");
        nodes.add("8");
        WeightedDigraph tmp = new WeightedDigraph(nodes);
        tmp.addBinaryNodeRelationShip("0", "1", 4);
        tmp.addBinaryNodeRelationShip("0", "7", 8);
        tmp.addBinaryNodeRelationShip("1", "2", 8);
        tmp.addBinaryNodeRelationShip("1", "7", 11);
        tmp.addBinaryNodeRelationShip("2", "3", 7);
        tmp.addBinaryNodeRelationShip("2", "8", 2);
        tmp.addBinaryNodeRelationShip("2", "5", 4);
        tmp.addBinaryNodeRelationShip("3", "4", 9);
        tmp.addBinaryNodeRelationShip("3", "5", 14);
        tmp.addBinaryNodeRelationShip("4", "5", 10);
        tmp.addBinaryNodeRelationShip("5", "6", 2);
        tmp.addBinaryNodeRelationShip("6", "7", 1);
        tmp.addBinaryNodeRelationShip("6", "8", 6);
        tmp.addBinaryNodeRelationShip("7", "8", 7);

        BFS tmpBFS = new BFS(tmp);
        tmpBFS.trace("0");
        System.out.println("End");
    }
}
