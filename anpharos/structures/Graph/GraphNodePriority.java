package anpharos.structures.Graph;

/**
 * Created on 5/7/17.
 */
public class GraphNodePriority implements Comparable<GraphNodePriority> {
    GraphNode node;
    int priority;

    public GraphNodePriority(String name, int priority) {
        node = new GraphNode(name);
        this.priority = priority;
    }

    public GraphNodePriority(GraphNode node, int priority) {
        this.node = node;
        this.priority = priority;
    }

    public String getName() {
        return node.getName();
    }

    public int getPriority() {
        return priority;
    }

    public GraphNode getNode(){
        return node;
    }

    @Override
    public int compareTo(GraphNodePriority other) {
        if (this.priority > other.getPriority())
            return 1;
        else if (this.priority < other.getPriority())
            return -1;
        else return 0;
    }
}
