package anpharos.gui.Graph;

import anpharos.structures.Graph.BFS;
import anpharos.structures.Graph.GraphNode;
import processing.core.PApplet;
import controlP5.*;

import java.util.ArrayList;

/**
 * Created on 5/7/17.
 */
public class GraphParent extends PApplet {
    ControlP5 cp5;
    Button dijkstra, dfs, bfs;
    Textfield input;
    Sphero sphero;
    SpainGraph spainGraph;
    int multiplier = 2;

    public void settings() {
        size(multiplier * 600, multiplier * 600);
    }

    public void setup() {
        cp5 = new ControlP5(this);
        dijkstra = cp5.addButton("Dijkstra")
                .setPosition(width / 4, 20 * multiplier)
                .setSize(100 * multiplier, 20 * multiplier);
        dfs = cp5.addButton("DFS").setPosition(2 * width / 4, 20 * multiplier).setSize(100 * multiplier, 20 * multiplier);
        bfs = cp5.addButton("BFS").setPosition(3 * width / 4, 20 * multiplier).setSize(100 * multiplier, 20 * multiplier);
        input = cp5.addTextfield("input")
                .setPosition(0,00)
                .setSize(100*multiplier,20*multiplier)
        ;
        spainGraph = new SpainGraph(this, multiplier);
        sphero = new Sphero(this, multiplier, spainGraph.getGuiNodes());
    }

    public void Dijkstra() {
        System.out.println("Dijkstra event: " + input.getText());
    }

    public void DFS() {
        System.out.println("DFS event: " + input.getText());
    }

    public void BFS() {
        System.out.println("BFS event: " + input.getText());
        if (input.getText())
        ArrayList<GraphNode> trace = BFS.trace(spainGraph.getGraph(), input.getText());
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
