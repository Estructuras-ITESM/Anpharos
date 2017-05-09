package anpharos.gui.Graph;

import anpharos.structures.Graph.WeightedDigraph;
import processing.core.PApplet;
import processing.core.PImage;

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
    Map<String, GraphNodeGui> nodes;
    ArrayList<GraphEdgeGui> edges;
    ArrayList<String> cities;
    WeightedDigraph graph;

    SpainGraph(PApplet parent, int multiplier) {
        this.parent = parent;
        this.multiplier = multiplier;
        img = parent.loadImage("grafo.JPG");
        nodes = new HashMap<>();
        edges = new ArrayList<>();
        cities = setStringNodes();
        graph = new WeightedDigraph(cities);
        setGuiNodes();
        setGuiEdges();
    }

    public ArrayList<String> setStringNodes() {
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("Albacete");//Albacete
        tmp.add("Badajoz");//Badajoz
        tmp.add("Barcelona");//Barcelona
        tmp.add("Coruña");//Coruña
        tmp.add("Cádiz");//Cadiz
        tmp.add("Oviedo");//Oviedo
        tmp.add("Gerona");//Gerona
        tmp.add("Granada");//Granada
        tmp.add("Jaén");//Jaen
        tmp.add("Madrid");//Madrid
        tmp.add("Murcia");//Murcia
        tmp.add("Bilbao");//Bilbao
        tmp.add("Sevilla");//Sevilla
        tmp.add("Valladolid");//Valladolid
        tmp.add("Valencia");//Valencia
        tmp.add("Vigo");//Vigo
        tmp.add("Zaragoza");//Zaragoza
        return tmp;
    }

    public Map<String, GraphNodeGui> getGuiNodes() {
        return nodes;
    }

    public WeightedDigraph getGraph() {
        return this.graph;
    }

    public boolean contains(String city){
        return 
    }

    public void setGuiNodes() {
        nodes.put("Albacete", new GraphNodeGui(parent, 352, 409, multiplier));//Albacete
        nodes.put("Badajoz", new GraphNodeGui(parent, 160, 419, multiplier));//Badajoz
        nodes.put("Barcelona", new GraphNodeGui(parent, 484, 233, multiplier));//Barcelona
        nodes.put("Coruña", new GraphNodeGui(parent, 127, 86, multiplier));//Coruña
        nodes.put("Cádiz", new GraphNodeGui(parent, 173, 584, multiplier));//Cadiz
        nodes.put("Oviedo", new GraphNodeGui(parent, 218, 85, multiplier));//Oviedo
        nodes.put("Gerona", new GraphNodeGui(parent, 524, 172, multiplier));//Gerona
        nodes.put("Granada", new GraphNodeGui(parent, 288, 555, multiplier));//Granada
        nodes.put("Jaén", new GraphNodeGui(parent, 266, 463, multiplier));//Jaen
        nodes.put("Madrid", new GraphNodeGui(parent, 287, 308, multiplier));//Madrid
        nodes.put("Murcia", new GraphNodeGui(parent, 381, 495, multiplier));//Murcia
        nodes.put("Bilbao", new GraphNodeGui(parent, 320, 90, multiplier));//Bilbao
        nodes.put("Sevilla", new GraphNodeGui(parent, 199, 528, multiplier));//Sevilla
        nodes.put("Valladolid", new GraphNodeGui(parent, 239, 224, multiplier));//Valladolid
        nodes.put("Valencia", new GraphNodeGui(parent, 413, 372, multiplier));//Valencia
        nodes.put("Vigo", new GraphNodeGui(parent, 110, 167, multiplier));//Vigo
        nodes.put("Zaragoza", new GraphNodeGui(parent, 381, 216, multiplier));//Zaragoza
    }
    public void setGraphEdges() {
        graph.addBinaryNodeRelationShip("Albacete", "Madrid", 251);
        graph.addBinaryNodeRelationShip("Albacete", "Murcia", 150);
        graph.addBinaryNodeRelationShip("Albacete", "Valencia", 191);
        graph.addBinaryNodeRelationShip("Badajoz", "Madrid", 403);
        graph.addBinaryNodeRelationShip("Barcelona","Gerona", 100);
        graph.addBinaryNodeRelationShip("Barcelona","Valencia", 349);
        graph.addBinaryNodeRelationShip("Barcelona","Zaragoza", 296);
        graph.addBinaryNodeRelationShip("Bilbao", "Madrid", 395);
        graph.addBinaryNodeRelationShip("Bilbao", "Oviedo", 304);
        graph.addBinaryNodeRelationShip("Bilbao", "Valladolid", 280);
        graph.addBinaryNodeRelationShip("Bilbao", "Zaragoza", 324);
        graph.addBinaryNodeRelationShip("Cádiz", "Sevilla", 125);
        graph.addBinaryNodeRelationShip("Coruña", "Valladolid", 455);
        graph.addBinaryNodeRelationShip("Coruña", "Vigo", 171);
        graph.addBinaryNodeRelationShip("Granada","Jaén", 99);
        graph.addBinaryNodeRelationShip("Granada","Murcia", 278);
        graph.addBinaryNodeRelationShip("Granada","Sevilla", 256);
        graph.addBinaryNodeRelationShip("Jaén", "Madrid", 335);
        graph.addBinaryNodeRelationShip("Jaén", "Sevilla", 242);
        graph.addBinaryNodeRelationShip("Madrid", "Valladolid", 193);
        graph.addBinaryNodeRelationShip("Madrid", "Zaragoza", 325);
        graph.addBinaryNodeRelationShip("Murcia", "Valencia", 241);
        graph.addBinaryNodeRelationShip("Valladolid", "Vigo", 356);
    }

    public void setGuiEdges() {
        edges.add(new GraphEdgeGui(parent, nodes.get("Albacete"), nodes.get("Madrid"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Albacete"), nodes.get("Murcia"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Albacete"), nodes.get("Valencia"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Badajoz"), nodes.get("Madrid"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Barcelona"), nodes.get("Gerona"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Barcelona"), nodes.get("Valencia"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Barcelona"), nodes.get("Zaragoza"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Bilbao"), nodes.get("Madrid"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Bilbao"), nodes.get("Oviedo"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Bilbao"), nodes.get("Valladolid"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Bilbao"), nodes.get("Zaragoza"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Cádiz"), nodes.get("Sevilla"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Coruña"), nodes.get("Valladolid"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Coruña"), nodes.get("Vigo"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Granada"), nodes.get("Jaén"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Granada"), nodes.get("Murcia"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Granada"), nodes.get("Sevilla"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Jaén"), nodes.get("Madrid"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Jaén"), nodes.get("Sevilla"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Madrid"), nodes.get("Valladolid"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Madrid"), nodes.get("Zaragoza"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Murcia"), nodes.get("Valencia"), multiplier));
        edges.add(new GraphEdgeGui(parent, nodes.get("Valladolid"), nodes.get("Vigo"), multiplier));
    }

    public void draw() {
        parent.image(img, 2 * 20 * multiplier, 2 * 20 * multiplier, parent.width - 20 * multiplier, parent.height - 20 * multiplier);
        for (String node : nodes.keySet()) {
            nodes.get(node).draw();
        }
        for (GraphEdgeGui edge : edges) {
            edge.draw();
        }

    }

}
