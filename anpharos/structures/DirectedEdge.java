package anpharos.structures;

/**
 * Created on 5/2/17.
 */
public class DirectedEdge {
    private final int v; // edge source
    private final int w; // edge target
    private final double weight; // edge weight

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
