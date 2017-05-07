package anpharos.structures;

import anpharos.structures.Graph.GraphNode;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created on 5/6/17.
 */

public class Dijkstra {
    boolean complete;
    int size;
    ArrayList<GraphNode> paths;
    ArrayList<GraphNode> visited;
    Queue<GraphNode> pathTable;

    public Dijkstra(GraphNode[] paths, GraphNode start) {
        for(GraphNode path : paths) {
            this.paths.add(path);
        }

        DijkstraPath(start);
    }

    private void DijkstraPath(GraphNode source) {
    }
}
