package anpharos.gui.Graph;

import processing.core.PApplet;
import processing.core.PImage;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 5/7/17.
 */
public class SpainGraph {
    PApplet parent;
    int multiplier;
    PImage img;
    Map<String, GraphNode> nodes;
    ArrayList<GraphEdge> edges;

    SpainGraph(PApplet parent, int multiplier) {
        this.parent = parent;
        this.multiplier = multiplier;
        img = parent.loadImage("grafo.JPG");
        nodes = new HashMap<>();
        edges = new ArrayList<>();
        setNodes();
        setEdges();
    }

    public Map<String,GraphNode> getNodes(){
        return nodes;
    }

    public void setNodes() {
        nodes.put("Albacete", new GraphNode(parent, 352, 409, multiplier));//Albacete
        nodes.put("Badajoz", new GraphNode(parent, 160, 419, multiplier));//Badajoz
       nodes.put("Barcelona", new GraphNode(parent, 484, 233, multiplier));//Barcelona
        nodes.put("Coruña", new GraphNode(parent, 127, 86, multiplier));//Coruña
        nodes.put("Cádiz", new GraphNode(parent, 173, 584, multiplier));//Cadiz
        nodes.put("Oviedo", new GraphNode(parent, 218, 85, multiplier));//Oviedo
        nodes.put("Gerona", new GraphNode(parent, 524, 172, multiplier));//Gerona
        nodes.put("Granada", new GraphNode(parent, 288, 555, multiplier));//Granada
        nodes.put("Jaén", new GraphNode(parent, 266, 463, multiplier));//Jaen
        nodes.put("Madrid", new GraphNode(parent, 287, 308, multiplier));//Madrid
        nodes.put("Murcia", new GraphNode(parent, 381, 495, multiplier));//Murcia
        nodes.put("Bilbao", new GraphNode(parent, 320, 90, multiplier));//Bilbao
        nodes.put("Sevilla", new GraphNode(parent, 199, 528, multiplier));//Sevilla
        nodes.put("Valladolid", new GraphNode(parent, 239, 224, multiplier));//Valladolid
        nodes.put("Valencia", new GraphNode(parent, 413, 372, multiplier));//Valencia
        nodes.put("Vigo", new GraphNode(parent, 110, 167, multiplier));//Vigo
       nodes.put("Zaragoza", new GraphNode(parent, 381, 216, multiplier));//Zaragoza
    }

    public void setEdges() {
        edges.add(new GraphEdge(parent, nodes.get("Albacete"), nodes.get("Madrid"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Albacete"), nodes.get("Murcia"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Albacete"), nodes.get("Valencia"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Badajoz"), nodes.get("Madrid"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Barcelona"), nodes.get("Gerona"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Barcelona"), nodes.get("Valencia"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Barcelona"), nodes.get("Zaragoza"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Bilbao"), nodes.get("Madrid"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Bilbao"), nodes.get("Oviedo"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Bilbao"), nodes.get("Valladolid"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Bilbao"), nodes.get("Zaragoza"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Cádiz"), nodes.get("Sevilla"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Coruña"), nodes.get("Valladolid"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Coruña"), nodes.get("Vigo"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Granada"), nodes.get("Jaén"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Granada"), nodes.get("Murcia"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Granada"), nodes.get("Sevilla"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Jaén"), nodes.get("Madrid"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Jaén"), nodes.get("Sevilla"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Madrid"), nodes.get("Valladolid"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Madrid"), nodes.get("Zaragoza"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Murcia"), nodes.get("Valencia"), multiplier));
        edges.add(new GraphEdge(parent, nodes.get("Valladolid"), nodes.get("Vigo"), multiplier));
    }

    public void draw() {
        //parent.image(img, 2 * 20 * multiplier, 2 * 20 * multiplier, parent.width - 20 * multiplier, parent.height - 20 * multiplier);
        for (String node : nodes.keySet()) {
            nodes.get(node).draw();
        }
        for (GraphEdge edge : edges) {
            edge.draw();
        }

    }

}
