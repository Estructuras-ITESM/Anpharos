package anpharos.gui.Graph;

import anpharos.structures.Graph.BFS;
import anpharos.structures.Graph.DFS;
import anpharos.structures.Graph.Dijkstra;
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
    Textfield input, destination;
    Sphero sphero;
    SpainGraph spainGraph;
    int multiplier = 1;
    ArrayList<GraphNode> trace;
    String city,destCity;

    public void settings() {
        size(multiplier * 600, multiplier * 600);
    }

    public void setup() {
        city = "";
        destCity = "";
        cp5 = new ControlP5(this);
        dfs = cp5.addButton("DFS").setPosition(2 * width / 4, 20 * multiplier).setSize(100 * multiplier, 20 * multiplier);
        bfs = cp5.addButton("BFS").setPosition(3 * width / 4, 20 * multiplier).setSize(100 * multiplier, 20 * multiplier);
        input = cp5.addTextfield("input")
                .setPosition(0, 00)
                .setSize(100 * multiplier, 20 * multiplier)
        ;
        destination = cp5.addTextfield("destination")
                .setPosition(0, 40)
                .setSize(100 * multiplier, 20 * multiplier)
        ;
        spainGraph = new SpainGraph(this, multiplier);
        sphero = new Sphero(this, multiplier, spainGraph.getGuiNodes());
        dijkstra = cp5.addButton("Dijkstra")
                .setPosition(width / 4, 20 * multiplier)
                .setSize(100 * multiplier, 20 * multiplier);
    }

    public void controlEvent(ControlEvent theEvent) {
        System.out.println(theEvent.getController().getName());
        if (city != "") {
            switch (theEvent.getName()) {
                case "Dijkstra":
                    if (destCity != "") {
                        Dijkstra tmp = new Dijkstra(spainGraph.getGraph());
                        tmp.setSource(city);
                        trace = tmp.trace(destCity);
                        sphero.putTo(trace);
                    }
                    break;
                case "DFS":
                    trace = DFS.trace(spainGraph.getGraph(), city);
                    sphero.putTo(trace);
                    break;
                case "BFS":
                    trace = BFS.trace(spainGraph.getGraph(), city);
                    sphero.putTo(trace);
                    break;
            }
        }

    }

    public void Dijkstra() {
        System.out.println("Dijkstra event: " + input.getText());
        if (spainGraph.contains(input.getText())) {
            city = input.getText();
        }
        if (spainGraph.contains(destination.getText())) {
            destCity = destination.getText();
        }
    }

    public void DFS() {
        System.out.println("DFS event: " + input.getText());
        if (spainGraph.contains(input.getText())) {
            city = input.getText();
        }
    }

    public void BFS() {
        System.out.println("BFS event: " + input.getText());
        if (spainGraph.contains(input.getText())) {
            city = input.getText();
        }
    }



    public void draw() {
        background(255);
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
