package anpharos.gui.Graph;


import anpharos.structures.Graph.GraphNode;
import anpharos.structures.Queue;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created on 5/7/17.
 */
public class Sphero {
    PApplet parent;
    PImage img;
    int multiplier;
    Map<String, GraphNodeGui> nodes;
    Queue<GraphNodeGui> positionQueue;
    boolean isReady;

    float maxForce;
    float maxSpeed;
    PVector location;
    PVector velocity;
    PVector acceleration;


    Sphero(PApplet parent, int multiplier, Map<String, GraphNodeGui> nodes) {
        this.parent = parent;
        String location = "Sphero.png";
        img = parent.loadImage(location, "png");
        this.multiplier = multiplier;
        this.nodes = nodes;
        putTo(nodes.get("Gerona"));
        positionQueue = new Queue<>();
        isReady = false;
    }

    public void moveTo(GraphNodeGui node) {
    }

    public void putTo(ArrayList<GraphNode> nodeList) {
        System.out.println("Enqueing");
        for (GraphNode node : nodeList) {
            positionQueue.enqueue(nodes.get(node.getName()));
        }
        System.out.println("Enqueued" + positionQueue.size());
        isReady = true;
    }

    public void putTo(GraphNodeGui node) {
        System.out.println(node.getXPos());
        location = new PVector(node.getXPos(), node.getYPos());
    }

    void draw() {
        if (!positionQueue.isEmpty() && isReady) {
            System.out.println("is not empty");
            System.out.println("Dequeing");
            putTo(positionQueue.dequeue());
            parent.pushMatrix();
            parent.translate(multiplier * location.x, multiplier * location.y);
            parent.image(img, -50, -50, 50 * multiplier, 50 * multiplier); //¿Por qué no necesita multiplier? Misterios del universo
            parent.popMatrix();
            parent.delay(500);
            if(positionQueue.isEmpty()) isReady = false;
        } else {
            parent.pushMatrix();
            parent.translate(multiplier * location.x, multiplier * location.y);
            parent.image(img, -50, -50, 50 * multiplier, 50 * multiplier); //¿Por qué no necesita multiplier? Misterios del universo
            parent.popMatrix();
        }
//
//            location.add(10,10);
//            parent.pushMatrix();
//            parent.translate(multiplier * location.x, multiplier * location.y);
//            parent.image(img, -50, -50, 50 * multiplier, 50 * multiplier); //¿Por qué no necesita multiplier? Misterios del universo
//            parent.popMatrix();
//            parent.delay(1000);
//
    }
}
