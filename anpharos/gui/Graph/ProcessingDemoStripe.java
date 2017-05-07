package anpharos.gui.Graph;

import processing.core.PApplet;

/**
 * Created on 5/7/17.
 */
public class ProcessingDemoStripe {
    PApplet parent;
    float x;
    float speed;
    float w;
    boolean mouse;

    ProcessingDemoStripe(PApplet p){
        parent = p;
        x = 0;
        speed = parent.random(1);
        w = parent.random(10,30);
        mouse = false;
    }

    void display(){
        parent.fill(255,100);
        parent.noStroke();
        parent.rect(x,0,w,parent.height);
    }

    void move(){
        x += speed;
        if (x > parent.width+20) x=-20;
    }
}
