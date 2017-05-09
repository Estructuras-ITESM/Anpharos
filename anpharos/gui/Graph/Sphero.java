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
    }

    public void moveTo(GraphNode node){
    }

    void draw(){
        parent.image(img,parent.width/2, parent.height/2, 50*multiplier,50*multiplier);
    }
}
