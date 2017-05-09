package anpharos.gui.Graph;


import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.Map;

/**
 * Created on 5/7/17.
 */
public class Sphero {
    PApplet parent;
    PImage img;
    int multiplier;
    Map<String, GraphNode> nodes;

    float maxForce;
    float maxSpeed;
    PVector location;
    PVector velocity;
    PVector acceleration;


    Sphero(PApplet parent, int multiplier, Map<String, GraphNode> nodes) {
        this.parent = parent;
        String location = "Sphero.png";
        img = parent.loadImage(location, "png");
        this.multiplier = multiplier;
        this.nodes = nodes;
        putTo(nodes.get("Barcelona"));
    }

    public void moveTo(GraphNode node){
    }

    public void putTo(GraphNode node){
        location = new PVector(node.getXPos(), node.getYPos());
    }

    void draw(){
        parent.pushMatrix();
        parent.translate(multiplier*location.x, multiplier*location.y);
        parent.image(img,-50, -50, 50*multiplier,50*multiplier); //¿Por qué no necesita multiplier? Misterios del universo
        parent.popMatrix();
    }
}
