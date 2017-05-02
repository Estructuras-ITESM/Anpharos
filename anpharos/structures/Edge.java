package anpharos.structures;

/**
 * Created on 5/2/17.
 */
public class Edge implements Comparable<Edge>{
    private final int v; // A vertex
    private final int w; // The other vertex
    private final double weight; // The vertex's weight

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either() { // ?
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }


    @Override
    public int compareTo(Edge other) {
        if (this.getWeight() < other.getWeight()) return -1;
        else if (this.getWeight() > other.getWeight()) return +1;
        else return 0;
    }

    public String toString()
    {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
