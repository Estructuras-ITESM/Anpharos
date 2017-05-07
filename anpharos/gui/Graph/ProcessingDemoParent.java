package anpharos.gui.Graph;

import processing.core.PApplet;

/**
 * Created on 5/7/17.
 */
public class ProcessingDemoParent extends PApplet {
    ProcessingDemoStripe[] stripes;
    public void settings() {
        //pixelDensity(2);
        size(600, 600);
        //fullScreen();
    }

    public void setup() {
        //System.out.println(displayDensity());
        fill(120,50,240);
        stripes = new ProcessingDemoStripe[50];
        for (int i = 0; i < stripes.length; i++) {
            stripes[i] = new ProcessingDemoStripe(this);
        }
    }

    public void draw() {
        //ellipse(width/2, height/2, second(), second());
        background(100);
        for (int i = 0; i < stripes.length; i++) {
            stripes[i].move();
            stripes[i].display();
        }
    }

    public static void main(String[] args) {
        PApplet.main("anpharos.gui.Graph.ProcessingDemoParent");
    }
}
