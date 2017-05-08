package anpharos.gui.Graph;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created on 5/7/17.
 */
public class Sphero {
    PApplet parent;
    PImage img;
    int multiplier;

    Sphero(PApplet parent, int multiplier) {
        this.parent = parent;
        String location = "Sphero.png";
        img = parent.loadImage(location, "png");
        this.multiplier = multiplier;
    }

    void draw(){
        parent.image(img,parent.width/2, parent.height/2, 50*multiplier,50*multiplier);
    }
}