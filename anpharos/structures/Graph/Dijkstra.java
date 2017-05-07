package anpharos.structures.Graph;

import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created on 5/7/17.
 */
public class Dijkstra {
    int dist[];
    PriorityQueue<GraphNodePriority> pq;
    WeightedDigraph graph;
    GraphNode source;

    Dijkstra(WeightedDigraph graph) {
        this.graph = graph;
        pq = new PriorityQueue<>();
        dist = new int[graph.size];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }

    public void setSource(String node) {
        source = graph.getNodeRef(node);
        pq.add(new GraphNodePriority(source, 0));
        dist[graph.getNodePosition(node)] = 0;
    }

    public int[] getDistances() {
        while (!pq.isEmpty()) {
        GraphNode u = pq.poll().getNode();
        int uPos = graph.getNodePosition(u);
        for (Edge e : graph.adjList.get(u)) {
            int vPos = graph.getNodePosition(e.to);
            if (dist[vPos] > dist[uPos] + e.weight) {
                dist[vPos] = dist[uPos] + e.weight;
                pq.add(new GraphNodePriority(e.to, dist[uPos] + e.weight));
            }
        }
        }
        return dist;
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

        Dijkstra dij = new Dijkstra(tmp);
        dij.setSource("0");
        int[] tmpDist = dij.getDistances();
        System.out.println(tmpDist);
    }
}
