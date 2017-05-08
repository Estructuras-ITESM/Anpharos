package anpharos.structures.Graph;

/**
 * Created on 5/6/17.
 */
public class Edge {
    public GraphNode from;
    public GraphNode to;
    int weight;

    Edge(GraphNode from, GraphNode to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public String toString(){
        return "From: " + from + " to: " + to + " costs: " + weight;
    }
}
