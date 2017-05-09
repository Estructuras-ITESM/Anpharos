package anpharos.gui.Graph;

import processing.core.PApplet;
import controlP5.*;

/**
 * Created on 5/7/17.
 */
public class GraphParent extends PApplet {
    ControlP5 cp5;
    Button dijkstra, dfs, bfs;
    Sphero sphero;
    SpainGraph spainGraph;
    int multiplier = 2;

    public void settings() {
        size(multiplier * 600, multiplier * 600);
    }

    public void setup() {
        cp5 = new ControlP5(this);
        cp5.addButton("Dijkstra")
                .setPosition(width / 4, 20 * multiplier)
                .setSize(100 * multiplier, 20 * multiplier);
        dfs = cp5.addButton("DFS").setPosition(2 * width / 4, 20 * multiplier).setSize(100 * multiplier, 20 * multiplier);
        bfs = cp5.addButton("BFS").setPosition(3 * width / 4, 20 * multiplier).setSize(100 * multiplier, 20 * multiplier);
        spainGraph = new SpainGraph(this, multiplier);
        sphero = new Sphero(this, multiplier, spainGraph.getNodes());
    }

    public void Dijkstra() {
        System.out.println("Dijkstra event");
    }

    public void DFS() {
        System.out.println("DFS event");
    }

    public void BFS() {
        System.out.println("BFS event");
    }

    public void draw() {
        spainGraph.draw();
        sphero.draw();
    }

    public static void init() {
        PApplet.main("anpharos.gui.Graph.GraphParent");
    }

    /*public void mousePressed(){
        System.out.println("X: "+this.mouseX/multiplier + " Y: " + mouseY/multiplier);
    }*/

    public static void main(String[] args) {
        GraphParent tmp = new GraphParent();
        tmp.init();
        //GraphParent.init();
    }
}
